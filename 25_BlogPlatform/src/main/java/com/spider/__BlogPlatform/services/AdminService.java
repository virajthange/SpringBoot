package com.spider.__BlogPlatform.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

public interface AdminService {
    public String managePosts(Model model);
    public String manageUsers(Model model) ;
    public String postModeration(Model model);

    public String approve(Integer id);

    public String reject(Integer id);

    public String remove(Integer id);
}
