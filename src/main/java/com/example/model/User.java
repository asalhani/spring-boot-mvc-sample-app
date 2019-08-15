package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long Id;

    private  String UserName;
    private  String Role;

    protected  User(){}

    public User(String userName, String role) {
        super();
        UserName = userName;
        Role = role;
    }

    public long getId() {
        return Id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getRole() {
        return Role;
    }
}
