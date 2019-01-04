package com.example.mitrais.ProjectWebSimple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/")
    public String hello() {
        return "Hello Spring Boot";
    }
}
