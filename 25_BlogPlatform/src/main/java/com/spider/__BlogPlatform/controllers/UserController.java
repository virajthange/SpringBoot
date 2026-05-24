package com.spider.__BlogPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create-post")
    public String createPost() {
        return "create-post";
    }

    @GetMapping("/dashboard")
    public String home() {
        return "user-dashboard";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
