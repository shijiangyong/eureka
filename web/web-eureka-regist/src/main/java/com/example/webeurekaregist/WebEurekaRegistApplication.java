package com.example.webeurekaregist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author shijy
 */
@SpringBootApplication
@EnableEurekaServer
public class WebEurekaRegistApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebEurekaRegistApplication.class, args);
    }
}
