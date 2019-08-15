package com.example.controllers;

import com.example.configurations.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.LoginService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Value("${admin.name}")
    private String AdminName;

    @Autowired
    private LoginService service;

    @Autowired
    private BasicConfiguration basicConfiguration;

    @RequestMapping("/login")
    public String loginMessage(){

        return  service.getLoginMessage();
    }

    @GetMapping("/login/admin")
    public ResponseEntity<?> GetAdminInfo(){
        return ResponseEntity.ok(AdminName);
    }

    @GetMapping("/admin/config")
    public ResponseEntity<?> GetCofnig(){
        Map map = new HashMap();
        map.put("bool value", basicConfiguration.isBoolValue());
        map.put("message", basicConfiguration.getMessage());
        map.put("number", basicConfiguration.getNumber());

        return ResponseEntity.ok(map);
    }
}

