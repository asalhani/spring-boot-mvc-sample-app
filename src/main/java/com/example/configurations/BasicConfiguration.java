package com.example.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicConfiguration {
    private  boolean boolValue;
    private  String message;
    private  int number;

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBoolValue() {
        return boolValue;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
