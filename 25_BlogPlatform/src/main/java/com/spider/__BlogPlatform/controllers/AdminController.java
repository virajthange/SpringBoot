package com.spider.__BlogPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public String managePosts() {
        return "manage-post";
    }

    @GetMapping("/manage-users")
    public String manageUsers() {
        return "manage-user";
    }

    @GetMapping("/post-moderation")
    public String postModeration() {
        return "post-moderation";
    }

    @GetMapping("/report")
    public String report() {
        return "report";
    }
}
