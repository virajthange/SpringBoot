package com.spider.__BlogPlatform.repositories;

import com.spider.__BlogPlatform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
