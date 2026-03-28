package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.RegisterDTO;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import tools.jackson.databind.util.BeanUtil;

import java.util.Optional;

@Controller
//@RequiredArgsConstructor
public class AuthController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    @ResponseBody
    public String getData() {
        return "Welcome to home";
    }

    @GetMapping("/login")
//    @ResponseBody
    public String login() {
        return "login";
    }



    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO dto = new RegisterDTO();
        model.addAttribute(dto);
        return "register";
    }

    @PostMapping("/reg")
    public String registerUser(RegisterDTO registerDTO) {

        Optional<Student> opt = studentRepository.findByEmail(registerDTO.getEmail());
        if(opt.isPresent()) {
            return "redirect:/login?msg=Already Registered , Please login !";
        }

        Student student = new Student();
        BeanUtils.copyProperties(registerDTO, student);
        student.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        studentRepository.save(student);
        System.out.println(registerDTO);

        return "redirect:/login?msg=Register successful, login now !";
    }

    @GetMapping("/dashboard")
    public String getme() {
        System.out.println("Dashboard hit");
        return "dashboard";
    }

    @GetMapping("/courselist")
    public String getCourseList() {
        return "courselist";
    }
    @GetMapping("/studentlist")
    public String getStudentList() {
        return "studentlist";
    }
    @GetMapping("/newcourse")
    public String newCourse() {
        return "newcourse";
    }
    @GetMapping("/newstudent")
    public String newStudent() {
        return "newstudent";
    }


}
