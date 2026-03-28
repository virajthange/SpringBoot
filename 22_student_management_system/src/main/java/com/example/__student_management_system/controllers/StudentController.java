package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.StudentDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.StudentRepository;
import com.example.__student_management_system.repositories.UserRepository;
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
//@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/studentlist")
    public String getStudentList(Principal principal, Model model) {
        String email = principal.getName();
        Optional<Users> byEmail = userRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            return "redirect:/login?msg=User Not Found, kindly login !";
        }
        Users user = byEmail.get();
        List<Student> students = studentRepository.findByUserId(user.getId());
        model.addAttribute("students", students);
        return "studentlist";
    }
    @GetMapping("/newstudent")
    public String newStudent(Principal principal, Model model) {
        String email = principal.getName();
        Optional<Users> byEmail = userRepository.findByEmail(email);
        if(byEmail.isEmpty()) {
            return "redirect:/login?msg=User not found, login !";
        }
        StudentDTO studentDTO = new StudentDTO();
        Users user = byEmail.get();
        List<Course> courses = courseRepository.findByUserId(user.getId());

        model.addAttribute("studentdto" , studentDTO);
        model.addAttribute("courses" , courses);
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String addNewStudent(Principal principal, StudentDTO studentDTO) {
        String email = principal.getName();

        Optional<Users> byEmail = userRepository.findByEmail(email);
        if(byEmail.isPresent()) {
            List<Course> allById = courseRepository.findAllById(studentDTO.getCourseIds());
            Student student = new Student();
            BeanUtils.copyProperties(studentDTO, student,"id");   //Copying everyting except id
            student.setUser(byEmail.get());
            student.setCourses(allById);

            studentRepository.save(student);
            return "redirect:/dashboard?msg=Student saved successfully";
        }
        return "redirect:/login?msg=User Not found, kindly login...!";
    }


    @GetMapping("/editstudent/{studentId}")
    public String editstudent(@PathVariable Integer studentId, Model model) {
        System.out.println("Student id is: "+studentId);
        Optional<Student> byId = studentRepository.findById(studentId);
        if(byId.isEmpty()) {
            return "redirect:/dashboard?msg=User details not found!!";
        }
        Student student = byId.get();
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);
        model.addAttribute("student", student);
        model.addAttribute("courses", student.getCourses());
        return "editstudent";
    }

    @PostMapping("/editstudent")
    public String editStudent(StudentDTO studentDTO) {
        System.out.println("Student dto email is " + studentDTO.getId());
        Optional<Student> optionalStudent = studentRepository.findById(studentDTO.getId());
        if(optionalStudent.isEmpty()) {
            return "redirect:/dashboard?msg=User not found";
        }
        Student student = optionalStudent.get();
        BeanUtils.copyProperties(studentDTO, student);
        studentRepository.save(student);
        return "redirect:/dashboard?msg=Student edited successfully";
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
