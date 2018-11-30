package com.example.webconsumerservice.controller;

import com.example.webconsumerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shijy
 * @Date 2018/11/29 10 : 04
 * @Descriprion
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


}
