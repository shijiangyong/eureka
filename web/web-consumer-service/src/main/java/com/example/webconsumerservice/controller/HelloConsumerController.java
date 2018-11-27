package com.example.webconsumerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shijy
 * @Date 2018/11/27 16 : 15
 * @Descriprion
 */
@RestController
@RequestMapping("/consumer")
public class HelloConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    public ResponseEntity<String> hello(@RequestParam("name") String name){
        return restTemplate.getForEntity("http://controller/hello?name=" + name,String.class);
    }

}
