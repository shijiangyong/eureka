package com.example.webconsumerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shijy
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.example.webconsumerservice.mapper")
public class WebConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebConsumerServiceApplication.class, args);
    }
}
