package com.spider.postman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("/show")
    public String show() {
        return "show";
    }

    @PostMapping("/register")
    public String register() {
        return "register successful...";
    }
    @PutMapping("/update")
    public String update() {
        return "updation successful...";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "deleted successfully";
    }
    @PatchMapping("/patch")
    public String patch() {
        return "update successfully";
    }
}
