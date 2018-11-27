package com.example.webconsumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shijy
 */
@SpringBootApplication
@EnableEurekaClient
public class WebConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebConsumerServiceApplication.class, args);
    }
}
