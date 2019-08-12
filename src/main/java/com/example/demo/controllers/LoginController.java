package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private  LoginService service;

    @RequestMapping("/login")
    public String loginMessage(){

        return  service.getLoginMessage();
    }
}

@Component
class LoginService{
    public String getLoginMessage(){
        return "logn message from service....";
    }
}
