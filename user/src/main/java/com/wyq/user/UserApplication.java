package com.wyq.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: wyq
 * @Date: 2021/2/1 11:58
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.wyq.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
