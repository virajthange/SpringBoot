package com.spider.form_binding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/data")
    public String data() {
        return "data";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
