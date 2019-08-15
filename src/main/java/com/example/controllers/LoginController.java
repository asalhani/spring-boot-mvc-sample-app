package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.LoginService;

@RestController
public class LoginController {

    @Value("${admin.name}")
    private String AdminName;

    @Autowired
    private LoginService service;

    @RequestMapping("/login")
    public String loginMessage(){

        return  service.getLoginMessage();
    }

    @GetMapping("/login/admin")
    public ResponseEntity<?> GetAdminInfo(){
        return ResponseEntity.ok(AdminName);
    }
}

