package com.example.webconsumerservice.controller;

import com.example.webconsumerservice.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijy
 * @Date 2018/11/28 11 : 19
 * @Descriprion
 */
@RestController
@RequestMapping("/feign")
public class FeignHelloController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/hello")
    public String hello(Integer age){
        return feignService.hello(age);
    }
}
