package com.example.__student_management_system.service;

import com.example.__student_management_system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository CourseRepository;

}
