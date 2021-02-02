package com.wyq.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.wyq.api.pojo.user.PO.User;
import com.wyq.common.system.AuthorizationCodeEnum;
import com.wyq.common.system.Result;
import com.wyq.common.system.SystemCodeEnum;
import com.wyq.common.jwt.JwtUtil;
import com.wyq.common.servlet.BaseServiceImpl;
import com.wyq.user.mapper.IUserMapper;
import com.wyq.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:28
 * @Description:
 */
@Service
public class IUserServiceImpl extends BaseServiceImpl<IUserMapper, User> implements IUserService {

    @Override
    public Result userLogin(String username, String password) {
        if("admin".equals(username) && "123456".equals(password)){
            String userId = "1";
            User user = new User(1l,"admin","15265043665","123456");
            String s = JSON.toJSONString(user);
            String jwt = JwtUtil.createJWT(userId, s, null);
            Map<String,Object> map = new HashMap();
            map.put("user",s);
            map.put("jwt",jwt);
            return Result.ok(map);
        }

        return Result.error(AuthorizationCodeEnum.AUTHORIZATION_LOGIN_ERR);
    }
}
