package com.spider.__BlogPlatform.repositories;

import com.spider.__BlogPlatform.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
