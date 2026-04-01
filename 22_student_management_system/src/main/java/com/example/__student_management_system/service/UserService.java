package com.example.__student_management_system.service;

import com.example.__student_management_system.dtos.RegisterDTO;
import org.springframework.ui.Model;

import java.security.Principal;

public interface UserService {
    String register(RegisterDTO registerDTO);
    String sendOtp(String email);
    String validateOtp(Integer otps);
    String changePass(String password);
    String dashboard(Principal principal, Model model, String msg);
}
