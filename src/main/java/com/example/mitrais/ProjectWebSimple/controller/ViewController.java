package com.example.mitrais.ProjectWebSimple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/view-products")
    public String viewProducts() {
        return "view-product";
    }
    @RequestMapping("/add-products")
    public String addProducts() {
        return "add-product";
    }

    @RequestMapping("/locale")
    public String viewLocale() {
        return "internationalization";
    }
}
