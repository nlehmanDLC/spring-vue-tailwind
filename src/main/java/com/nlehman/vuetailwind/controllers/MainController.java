package com.nlehman.vuetailwind.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @RequestMapping("/products/**")
    public String products() {
        return "products";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
