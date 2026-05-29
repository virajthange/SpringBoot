package com.spider.__BlogPlatform.repositories;

import com.spider.__BlogPlatform.entities.Blog;
import com.spider.__BlogPlatform.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findByStatus(String status);
}
