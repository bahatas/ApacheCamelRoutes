package com.example.apachecamelroutes.routes;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomBean {

    public String getCurrentDateandTime() {

        return String.format("%s", LocalDateTime.now());
    }
}
