package com.spider.__ReactConnection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin("http://localhost:5173/")
public class MyController {

    @GetMapping
    public String welcome() {
        return "Welcome to Dashboard";
    }

    @GetMapping("/students")
    public List<String> list() {
        List<String> lst = new ArrayList<>();
        lst.add("Viraj");
        lst.add("Yash");
        lst.add("Swaraj");

        return lst;
    }


}
