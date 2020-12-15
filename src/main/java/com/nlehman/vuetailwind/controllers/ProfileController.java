package com.nlehman.vuetailwind.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
