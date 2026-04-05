package com.example.__JWT_Authentication.controllers;

import com.example.__JWT_Authentication.entities.Users;
import com.example.__JWT_Authentication.repositories.UserRepository;
import com.example.__JWT_Authentication.service.JWTservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTservice jwtService;

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        Optional<Users> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            return "Already registered";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "registered successfully";
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        Optional<Users> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isEmpty()) throw new RuntimeException("User not found !");

        Users dbUser = optionalUser.get();

        if( passwordEncoder.matches(user.getPassword(), dbUser.getPassword()) ) {
            return jwtService.generateToken(dbUser.getUsername());
        }
        return "Invalid credentials";
    }

    @GetMapping("/home")
    public String home() {
        return "welcome to home";
    }
}


//AuthenticationManager is needed only for the login , after every request is handled by JWT filter
//if we provide our implementation for login without AuthenticationManager, we bypass the security filters, not scalable , have to handle exceptions manually
//authenticationManager.authenticate(...)
//👉 Internally:
//Calls UserDetailsService
//Fetches user from DB
//Uses PasswordEncoder.matches()
//If valid → authentication success
//If invalid → throws exception