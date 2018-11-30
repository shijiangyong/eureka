package com.example.webconsumerservice.service;

import com.example.webconsumerservice.controller.UserController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shijy
 * @Date 2018/11/27 17 : 00
 * @Descriprion
 */

@FeignClient("controller")
//@FeignClient(name = "",configuration = UserController.class)
public interface FeignService {

    /**
     * feign测试
     * @param age
     * @return
     */
    @RequestMapping("/feignHello")
    String hello(@RequestParam("age") Integer age);
}
