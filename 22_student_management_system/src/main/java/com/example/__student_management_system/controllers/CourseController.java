package com.example.__student_management_system.controllers;

import com.example.__student_management_system.dtos.CourseDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.UserRepository;
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

    @GetMapping("/courselist")
    public String getCourseList(Principal principal, Model model) {
        String email = principal.getName();
        Optional<Users> byEmail = userRepository.findByEmail(email);
        if(byEmail.isPresent()) {
            Users user = byEmail.get();
            List<Course> allCourses = courseRepository.findByUserId(user.getId());
            model.addAttribute("courses", allCourses);
            return "courselist";
        }
        return "redirect:/dashboard?msg=User Not Found";

    }




    @GetMapping("/newcourse")
    public String newCourse(Model model) {
        CourseDTO courseDTO = new CourseDTO();
        model.addAttribute("courseDTO", courseDTO);
        return "newcourse";
    }
    @PostMapping("/newcourse")
    public String addNewCourse(Principal principal, CourseDTO courseDTO) {
        String email = principal.getName();
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);

        Optional<Users> byEmail = userRepository.findByEmail(email);
        if(byEmail.isPresent()) {
            course.setUser(byEmail.get());
        courseRepository.save(course);
        return "redirect:/dashboard?msg=Course Added Successfully";
        }
        return "redirect:/login?msg=User not found";
    }


//    @GetMapping("/editcourse")
//    public String editcourse() {
//
//        return "editcourse";
//    }

    @GetMapping("/editcourse/{courseId}")
    public String editCourse(@PathVariable Integer courseId, Model model) {
        Optional<Course> byId = courseRepository.findById(courseId);
        model.addAttribute("course", byId.get());
        model.addAttribute("courseDTO", new CourseDTO());
        return "editcourse";
    }

    @PostMapping("/editcourse")
    public String editCourse(CourseDTO courseDTO) {
        Optional<Course> byId = courseRepository.findById(courseDTO.getId());
        Course course = byId.get();
        BeanUtils.copyProperties(courseDTO, course);
        courseRepository.save(course);

        return "redirect:/dashboard?msg=Course Updated Successfully";
    }

    @GetMapping("/deletecourse/{courseId}")
    public String deletecourse(@PathVariable Integer courseId) {
        Optional<Course> byId = courseRepository.findById(courseId);
        if(byId.isEmpty()) {
            return "redirect:/dashboard?msg=Course not found";
        }
        Course course = byId.get();
        List<Student> students = course.getStudents();
        for (Student val : students) {
            List<Course> courses = val.getCourses();
            courses.remove(course);
        }

        courseRepository.delete(course);
        return "redirect:/dashboard?msg=Course deleted successfully !";
    }





}