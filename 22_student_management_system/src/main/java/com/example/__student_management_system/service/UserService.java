package com.example.__student_management_system.service;

import com.example.__student_management_system.dtos.RegisterDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.StudentRepository;
import com.example.__student_management_system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public String register(RegisterDTO registerDTO) {
        Optional<Users> opt = userRepository.findByEmail(registerDTO.getEmail());
        if(opt.isPresent()) {
            return "redirect:/login?msg=Already Registered , Please login !";
        }
        Users user = new Users();
        BeanUtils.copyProperties(registerDTO, user);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        userRepository.save(user);
        return "redirect:/login?msg=Register successful, login now !";
    }

    public String dashboard(Principal principal, Model model, String msg) {
        String email = principal.getName();
        Optional<Users> byEmail = userRepository.findByEmail(email);

        if(byEmail.isPresent()) {
            Integer userId = byEmail.get().getId();
            Integer courseCount = courseRepository.countByUserId(userId);
            model.addAttribute("coursecount", courseCount);

            Integer studentCount = studentRepository.countByUserId(userId);
            model.addAttribute("studentcount", studentCount);

            List<Student> recentstudents = studentRepository.findTop4ByUserIdOrderByCreatedDateDesc(byEmail.get().getId());
            model.addAttribute("recentstudents", recentstudents);    //remaining to display in dashboard

            List<Course> recentCourses = courseRepository.findTop4ByUserIdOrderByCreatedDateDesc(userId);
            model.addAttribute("recentcourses", recentCourses);
        }
        if(msg != null) {
            model.addAttribute("msg", msg);
        }else{
            model.addAttribute("msg", "Welcome, "+ byEmail.get().getName());
        }
        return "dashboard";
    }
}
