package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private  String UserName;
    private  String role;

    protected  User(){}

    public User(String userName, String role) {
        super();
        UserName = userName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", UserName='" + UserName + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public String getRole() {
        return role;
    }
}
