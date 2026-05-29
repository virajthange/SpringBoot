package com.spider.__BlogPlatform.controllers;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import com.spider.__BlogPlatform.serviceImplementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/create-post")
    public String createPost(Model model, @RequestParam(required = false) String msg) {
        return userServiceImpl.createPost(model, msg);
    }

    @PostMapping("/create-post")
    public String createPostLogic(BlogDTO blogDTO, Principal principal) {
       return userServiceImpl.createPostLogic(blogDTO, principal);
    }

    @GetMapping("/dashboard")
    public String home(@RequestParam(required = false, defaultValue = "0") Integer pageNumber , Model model) {
        return userServiceImpl.home(model, pageNumber);
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        return userServiceImpl.profile(principal, model);
    }
}
