package com.wyq.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: wyq
 * @Date: 2021/2/1 10:08
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7001.class,args);
    }
}
