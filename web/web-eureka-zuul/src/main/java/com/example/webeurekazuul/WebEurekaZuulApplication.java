package com.example.webeurekazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class WebEurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebEurekaZuulApplication.class, args);
    }
}
