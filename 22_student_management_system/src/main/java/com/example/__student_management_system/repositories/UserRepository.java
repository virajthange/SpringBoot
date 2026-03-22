package com.example.__student_management_system.repositories;

import com.example.__student_management_system.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
