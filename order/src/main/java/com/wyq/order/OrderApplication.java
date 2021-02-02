package com.wyq.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:58
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "com.wyq.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
