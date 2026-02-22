package com.spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Control {
    @RequestMapping("/reg")
    public String reg() {
        return "register.html";
    }

    @RequestMapping
    @ResponseBody
    public String home () {
        return "hey there";
    }

}
