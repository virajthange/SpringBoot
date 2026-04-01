package com.example.__student_management_system.serviceImplementation;

import com.example.__student_management_system.dtos.CourseDTO;
import com.example.__student_management_system.entities.Course;
import com.example.__student_management_system.entities.Student;
import com.example.__student_management_system.entities.Users;
import com.example.__student_management_system.repositories.CourseRepository;
import com.example.__student_management_system.repositories.UserRepository;
import com.example.__student_management_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public String getCourses(Principal principal, Model model) {
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

    public String newCourse(Model model) {
        CourseDTO courseDTO = new CourseDTO();
        model.addAttribute("courseDTO", courseDTO);
        return "newcourse";
    }

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

    public String getEditCourse(Integer courseId, Model model) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if(optionalCourse.isEmpty()) {
            return "redirect:/dashboard?msg=Page not found !";
        }
        Course course = optionalCourse.get();
        model.addAttribute("course", course);
        model.addAttribute("courseDTO", new CourseDTO());
        return "editcourse";
    }

    public String editCourse(CourseDTO courseDTO) {
        Optional<Course> byId = courseRepository.findById(courseDTO.getId());
        if(byId.isEmpty()) {
            return "redirect:/dashboard?msg=Course not found";
        }
        Course course = byId.get();
        BeanUtils.copyProperties(courseDTO, course);
        courseRepository.save(course);
        return "redirect:/dashboard?msg=Course Updated Successfully";
    }

    public String deleteCourse(Integer courseId) {
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
