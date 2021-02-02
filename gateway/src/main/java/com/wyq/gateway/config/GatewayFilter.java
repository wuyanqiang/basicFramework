package com.wyq.gateway.config;

import com.wyq.common.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @author: wyq
 * @Date: 2021/2/1 14:21
 * @Description:
 */
@Slf4j
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    // 令牌头名字
    private static final String AUTHORIZE_TOKEN = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String url = request.getPath().value();
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);; //令牌信息
        String method = request.getMethodValue();
        String contentType = request.getHeaders().getFirst("Content-Type");
        log.info("<------------------------------------------------------------------------>");
        log.info("requestUrl->:"+url+";token->:"+token+";method->:"+method+";contentType->:"+contentType);

        // 直接放行登录
        if (url.startsWith("/user/login"))  return chain.filter(exchange);

        // 如果为true：说明令牌在头文件中， false：令牌不在头文件中，将令牌封装入头文件，再传递给其他微服务
        boolean hasToken = true;
        // 如果头文件中没有令牌信息，则从请求参数中获取
        if (StringUtils.isEmpty(token)) {
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
            hasToken = false;
        }
        // 如果为空，则输出错误代码
        if (StringUtils.isEmpty(token)) {
            // 设置方法不允许被访问，405错误代码
            response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
            return response.setComplete();
        }
        // 如果不为空，则解析令牌数据
        try {
            Claims claims = JwtUtil.parseJWT(token);
            log.info("user sub------>:" + claims.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
            // 解析失败，响应401错误
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 放行之前，将令牌封装到头文件中(这一步是为了方便AUTH2校验令牌)
        request.mutate().header(AUTHORIZE_TOKEN,token);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
