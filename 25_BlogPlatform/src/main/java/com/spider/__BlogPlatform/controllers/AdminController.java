package com.spider.__BlogPlatform.controllers;

import com.spider.__BlogPlatform.serviceImplementation.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServiceImpl adminServiceImpl;

    @GetMapping("/dashboard")
    public String managePosts(Model model) {
        return adminServiceImpl.managePosts(model);
    }

    @GetMapping("/manage-users")
    public String manageUsers(Model model) {
        return adminServiceImpl.manageUsers(model);
    }

    @GetMapping("/post-moderation")
    public String postModeration(Model model) {
        return adminServiceImpl.postModeration(model);
    }

    @GetMapping("/report")
    public String report() {
        return "report";
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Integer id) {
        return adminServiceImpl.approve(id);
    }
    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Integer id) {
        return adminServiceImpl.reject(id);
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Integer id) {
        return adminServiceImpl.remove(id);
    }

}
