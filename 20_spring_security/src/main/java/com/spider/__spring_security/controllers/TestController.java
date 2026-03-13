package com.spider.__spring_security.controllers;


import com.spider.__spring_security.entities.Student;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
//    Jackson needs a way to access the fields of java object, and by default it uses getters, that's why getters are required, without getters it gives empty object
    @GetMapping("/home")
    public String home(HttpServletRequest request) {

        return "Welcome on home page\n" + request.getSession().getId();
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>(List.of(new Student(1,"Viraj",22, "BE"), new Student(2,"Sanket",21,"Bsc")));
        System.out.println("Students is: "+students);
        return students;
    }
}
