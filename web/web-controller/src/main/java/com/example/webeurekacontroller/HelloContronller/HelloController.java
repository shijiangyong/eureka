package com.example.webeurekacontroller.HelloContronller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String getHello(@RequestParam("name") String name){
        return "Hello," + name + " , i am from  port : " + port;
    }

    @RequestMapping(value = "/feignHello",method = {RequestMethod.GET,RequestMethod.POST})
    public String getAge(@RequestParam("age") Integer age){
        return "She is a "+age+"-year-odl girl from port " + port;
    }

    @RequestMapping(value = "/hi",method = {RequestMethod.GET,RequestMethod.POST})
    public String home(@RequestParam(value = "name",defaultValue = "forezp") String name){
        return "hi " + name + " , i am form port : " + port;
    }
}
