package com.spider.__BlogPlatform.controllers;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import com.spider.__BlogPlatform.entities.Blog;
import com.spider.__BlogPlatform.enums.Status;
import com.spider.__BlogPlatform.repositories.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final BlogRepository blogRepository;

    @GetMapping("/create-post")
    public String createPost(Model model, @RequestParam(required = false) String msg) {
        BlogDTO blogDTO = new BlogDTO();
        model.addAttribute("blogDTO", blogDTO);
        model.addAttribute("msg", msg);
        return "create-post";
    }

    @PostMapping("/create-post")
    public String createPostLogic(BlogDTO blogDTO) {
        System.out.println("create-post triggered");
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blog.setStatus(Status.PENDING.toString());
        System.out.println("BlogDTO is: "+ blogDTO);
        System.out.println("Blog is: "+blog);
        blogRepository.save(blog);
        return "redirect:/user/create-post?msg=Post created successfully...!";
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
