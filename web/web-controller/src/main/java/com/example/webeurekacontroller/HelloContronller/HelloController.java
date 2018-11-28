package com.example.webeurekacontroller.HelloContronller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author shijy
 * @Date 2018/11/27 14 : 22
 * @Descriprion
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String getHello(@RequestParam("name") String name){
        return "Hello," + name;
    }

    @RequestMapping(value = "/feignHello",method = {RequestMethod.GET,RequestMethod.POST})
    public String getAge(@RequestParam("age") Integer age){
        return "She is a "+age+"-year-odl girl";
    }

}
