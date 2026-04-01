package com.example.__student_management_system.service;

import com.example.__student_management_system.dtos.StudentDTO;
import org.springframework.ui.Model;

import java.security.Principal;

public interface StudentService {
    String getStudentList(Principal principal, Model model);
    String newStudent(Principal principal, Model model);
    String addNewStudent(Principal principal, StudentDTO studentDTO);
    String getEditStudent(Integer studentId, Principal principal, Model model);
    String editStudents(StudentDTO studentDTO);
}
