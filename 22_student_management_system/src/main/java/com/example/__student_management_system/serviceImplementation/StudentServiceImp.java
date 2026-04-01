package com.example.__student_management_system.serviceImplementation;

import com.example.__student_management_system.dtos.StudentDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.StudentRepository;
import com.example.__student_management_system.repositories.UserRepository;
import com.example.__student_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

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

    public String getEditStudent(Integer studentId, Principal principal, Model model) {
        String email = principal.getName();
        Optional<Users> byEmail = userRepository.findByEmail(email);
        if(byEmail.isEmpty()) {
            return "redirect:/login?msg=User not found!";
        }
        Users user = byEmail.get();
        List<Course> byUserId = courseRepository.findByUserId(user.getId());
        model.addAttribute("allcourses",byUserId);

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

    public String editStudents(StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(studentDTO.getId());
        if(optionalStudent.isEmpty()) {
            return "redirect:/dashboard?msg=User not found";
        }
        Student student = optionalStudent.get();
        BeanUtils.copyProperties(studentDTO, student);
        List<Course> courses = courseRepository.findAllById(studentDTO.getCourseIds());
        student.setCourses(courses);
        studentRepository.save(student);
        return "redirect:/dashboard?msg=Student edited successfully";
    }
}