package com.example.webconsumerservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author sjy
 * @Date 2018/12/2 21:38
 * @Description
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(@RequestParam("name") String name){
        return restTemplate.getForObject("http://controller/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name + " , sorry error";
    }
}
