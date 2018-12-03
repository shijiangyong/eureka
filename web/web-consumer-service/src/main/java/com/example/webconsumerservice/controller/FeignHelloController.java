package com.example.webconsumerservice.controller;

import com.example.webconsumerservice.service.FeignService;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
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

    @RequestMapping("/hi")
    public String hi(@RequestParam("name") String name){
        return feignService.hi(name);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
