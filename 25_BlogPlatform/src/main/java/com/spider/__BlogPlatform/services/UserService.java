package com.spider.__BlogPlatform.services;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import org.springframework.ui.Model;

import java.security.Principal;

public interface UserService {
    public String home(Model model, Integer pageNumber);
    public String createPostLogic(BlogDTO blogDTO, Principal principal);
    public String profile(Principal principal, Model model) ;
    public String createPost(Model model, String msg);

}
