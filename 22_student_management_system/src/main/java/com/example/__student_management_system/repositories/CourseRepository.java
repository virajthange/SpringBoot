package com.example.__student_management_system.repositories;

import com.example.__student_management_system.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findByUserId(Integer id);

    public Integer countByUserId(Integer id);

    public List<Course> findTop4ByUserIdOrderByCreatedDateDesc(Integer id);

}
