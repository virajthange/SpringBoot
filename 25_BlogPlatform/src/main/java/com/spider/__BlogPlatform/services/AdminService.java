package com.spider.__BlogPlatform.services;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import com.spider.__BlogPlatform.dtos.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

public interface AdminService {
    public String managePosts(Model model);
    public String manageUsers(Model model) ;
    public String postModeration(Model model);

    public String approve(Integer id);

    public String reject(Integer id);

    public String remove(Integer id);

    public String editBlog(Model model, Integer id);

    public String editBlogLogic(BlogDTO blogDTO);

    public String deleteBlog(Integer id);

    public String editUser(Integer id, Model model);

    public String editUserLogic(UserDTO userDTO);
}
