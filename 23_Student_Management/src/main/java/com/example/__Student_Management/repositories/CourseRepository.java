package com.example.__student_management_system.repositories;

import com.example.__student_management_system.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
