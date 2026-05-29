package com.spider.__BlogPlatform.repositories;

import com.spider.__BlogPlatform.entities.User;
import com.spider.__BlogPlatform.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);

}
