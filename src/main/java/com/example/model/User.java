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

    private  String name;
    private  String role;

    protected  User(){}

    public User(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", UserName='" + name + '\'' +
                ", Role='" + role + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
