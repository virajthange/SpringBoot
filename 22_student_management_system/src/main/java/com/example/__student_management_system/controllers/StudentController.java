package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.StudentDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.repositories.StudentRepository;
import com.example.__student_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
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
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @GetMapping("/studentlist")
    public String getStudentList(Principal principal, Model model) {
        return studentService.getStudentList(principal, model);
    }

    @GetMapping("/newstudent")
    public String newStudent(Principal principal, Model model) {
       return studentService.newStudent(principal, model);
    }

    @PostMapping("/newstudent")
    public String addNewStudent(Principal principal, StudentDTO studentDTO) {
       return studentService.addNewStudent(principal, studentDTO);
    }

    @GetMapping("/editstudent/{studentId}")
    public String editstudent(@PathVariable Integer studentId,Principal principal, Model model) {
       return studentService.getEditStudent(studentId, principal, model);
    }

    @PostMapping("/editstudent")
    public String editStudent(StudentDTO studentDTO) {
       return studentService.editStudents(studentDTO);
    }

    @GetMapping("/deletestudent/{studentId}")
    public String deletestudent(@PathVariable Integer studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()) {
            return "redirect:/dashboard?msg=User not found !";
        }
        Student student = optionalStudent.get();
        List<Course> courses = student.getCourses();
        for (Course val : courses) {
            List<Student> students = val.getStudents();
            students.remove(student);
        }
        studentRepository.delete(student);
        return "redirect:/dashboard?msg=Student deleted successfully !";
    }
}