package com.example.webconsumerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shijy
 * @Date 2018/11/27 17 : 00
 * @Descriprion
 */

@FeignClient("controller")
public interface FeignService {

    /**
     * feign测试
     * @param age
     * @return
     */
    @RequestMapping("/feignHello")
    String hello(@RequestParam("age") Integer age);
}
