package com.spider.__BlogPlatform.controllers;

import com.spider.__BlogPlatform.dtos.UserDTO;
import com.spider.__BlogPlatform.entities.User;
import com.spider.__BlogPlatform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerLogic(UserDTO userDTO) {
        System.out.println(userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        System.out.println("User saved...");
        return "redirect:/auth/login";
    }
}
