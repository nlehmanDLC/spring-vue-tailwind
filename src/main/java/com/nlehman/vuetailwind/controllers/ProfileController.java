package com.nlehman.vuetailwind.controllers;

import com.nlehman.vuetailwind.entities.User;
import com.nlehman.vuetailwind.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        User user = repo.findByUsername(currentUser.getUsername());
        model.addAttribute("loggedInUser", user);
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
