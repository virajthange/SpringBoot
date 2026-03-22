package com.example.__student_management_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @GetMapping("/")
    @ResponseBody
    public String getData() {
        return "Welcome to home";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login.jsp";
//    }
//    @GetMapping("/register")
//    public String register() {
//        return "register.jsp";
//    }

    @GetMapping("/dashboard")
    public String getme() {
        return "dashboard.jsp";
    }

    @GetMapping("/courselist")
    public String getCourseList() {
        return "courselist.jsp";
    }
    @GetMapping("/studentlist")
    public String getStudentList() {
        return "studentlist.jsp";
    }
    @GetMapping("/newcourse")
    public String newCourse() {
        return "newcourse.jsp";
    }
    @GetMapping("/newstudent")
    public String newStudent() {
        return "newstudent.jsp";
    }
}
