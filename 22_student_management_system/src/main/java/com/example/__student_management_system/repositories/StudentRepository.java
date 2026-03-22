package com.example.__student_management_system.repositories;

import com.example.__student_management_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
