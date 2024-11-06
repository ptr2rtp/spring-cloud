package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/spring")
    public String hello(){
        return "Greetings from Spring Boot!";
    }
}
