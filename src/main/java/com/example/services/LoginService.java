package com.example.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService{
    public String getLoginMessage(){
        return "logn message from service....";
    }
}
