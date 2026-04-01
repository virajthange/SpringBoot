package com.example.__student_management_system.service;

import com.example.__student_management_system.dtos.CourseDTO;
import org.springframework.ui.Model;

import java.security.Principal;

public interface CourseService {
    String getCourses(Principal principal, Model model);
    String newCourse(Model model);
    String addNewCourse(Principal principal, CourseDTO courseDTO);
    String getEditCourse(Integer courseId, Model model);
    String editCourse(CourseDTO courseDTO);
    String deleteCourse(Integer courseId);
}
