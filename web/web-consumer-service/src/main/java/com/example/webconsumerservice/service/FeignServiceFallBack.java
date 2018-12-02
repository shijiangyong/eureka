package com.example.webconsumerservice.service;

import org.springframework.stereotype.Component;

/**
 * @author sjy
 * @Date 2018/12/2 22:59
 * @Description
 */
@Component
public class FeignServiceFallBack implements FeignService{

    @Override
    public String hello(Integer age) {
        return "hello ,hstrix == fail age" + age;
    }

    @Override
    public String hi(String name) {
        return "hello ,hstrix == fail name" + name;
    }
}
