package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.CourseDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.UserRepository;
import com.example.__student_management_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseService courseService;

    @GetMapping("/courselist")
    public String getCourseList(Principal principal, Model model) {
        return courseService.getCourses(principal, model);
    }

    @GetMapping("/newcourse")
    public String newCourse(Model model) {
       return courseService.newCourse(model);
    }

    @PostMapping("/newcourse")
    public String addNewCourse(Principal principal, CourseDTO courseDTO) {
        return courseService.addNewCourse(principal, courseDTO);
    }

    @GetMapping("/editcourse/{courseId}")
    public String editCourse(@PathVariable Integer courseId, Model model) {
       return courseService.getEditCourse(courseId, model);
    }

    @PostMapping("/editcourse")
    public String editCourse(CourseDTO courseDTO) {
        return courseService.editCourse(courseDTO);
    }

    @GetMapping("/deletecourse/{courseId}")
    public String deletecourse(@PathVariable Integer courseId) {
        return courseService.deleteCourse(courseId);
    }
}