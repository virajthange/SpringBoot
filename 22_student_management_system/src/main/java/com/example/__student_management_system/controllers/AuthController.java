package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.RegisterDTO;
import com.example.__student_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String msg) {
        model.addAttribute("msg", msg);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO dto = new RegisterDTO();
        model.addAttribute("registerDTO", dto);
        return "register";
    }

    @PostMapping("/reg")
    public String registerUser(RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @GetMapping("/dashboard")
    public String getDashboard(Principal principal, @RequestParam(required = false) String msg, Model model) {
       return userService.dashboard(principal, model, msg);
    }
}
