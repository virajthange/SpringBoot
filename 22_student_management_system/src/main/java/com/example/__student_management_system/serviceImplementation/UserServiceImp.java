package com.example.__student_management_system.serviceImplementation;

import com.example.__student_management_system.dtos.RegisterDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.StudentRepository;
import com.example.__student_management_system.repositories.UserRepository;
import com.example.__student_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final JavaMailSender javaMailSender;
    private Integer fourDigitNumber;
    private String userEmail;

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

    public String sendOtp(String email) {
        Optional<Users> fetchedUser = userRepository.findByEmail(email);
        userEmail = email;
        if(fetchedUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        Random rand = new Random();
        int min = 1000;
        int max = 9999;
        // The expression generates a number in the range [1000, 9999]
        fourDigitNumber = rand.nextInt(max - min + 1) + min;    // The nextInt method generates a number between 0 (inclusive) and the bound (exclusive).

        simpleMailMessage.setSubject("About changing the password");
        simpleMailMessage.setFrom("virajst21hite@student.mes.ac.in");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText("Your OTP is: "+ fourDigitNumber);
        javaMailSender.send(simpleMailMessage);
        return "redirect:/forgetpassword?msg=OTP sent";
    }

    public String validateOtp(Integer otps) {
        if(fourDigitNumber.equals(otps)) {
            return "redirect:/changepassword";
        }
        return "redirect:/forgetpassword?msg=You have entered wrong OTP, kindly check it !";
    }

    public String changePass(String password) {
        Optional<Users> user = userRepository.findByEmail(userEmail);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found...!");
        }
        Users users = user.get();
        users.setPassword(passwordEncoder.encode(password));
        userRepository.save(users);
        return "redirect:/login?msg=Password updated successful, login now !";
    }
}