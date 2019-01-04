package com.example.mitrais.ProjectWebSimple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index() {
        // Calling Index.html
        return "index";
    }
}
