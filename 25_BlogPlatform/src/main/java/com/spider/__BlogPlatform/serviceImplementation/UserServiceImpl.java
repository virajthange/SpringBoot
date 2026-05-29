package com.spider.__BlogPlatform.serviceImplementation;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import com.spider.__BlogPlatform.entities.Blog;
import com.spider.__BlogPlatform.entities.User;
import com.spider.__BlogPlatform.enums.Status;
import com.spider.__BlogPlatform.repositories.BlogRepository;
import com.spider.__BlogPlatform.repositories.UserRepository;
import com.spider.__BlogPlatform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public String home(Model model, Integer pageNumber) {
        Pageable page = PageRequest.of(pageNumber, 1);
        Page<Blog> foundPage = blogRepository.findAll(page);
        model.addAttribute("page", foundPage);
        return "user-dashboard";
    }

    public String createPostLogic(BlogDTO blogDTO, Principal principal) {
        if(blogDTO.getTitle() == null || blogDTO.getContent() == null || blogDTO.getTags() == null) {
            return "redirect:/create-post?msg=Fields must not be empty";
        }
        Optional<User> byEmail = userRepository.findByEmail(principal.getName());
        if(byEmail.isEmpty()) {
            throw new UsernameNotFoundException("User not found..>!");
        }
        User user = byEmail.get();

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blog.setStatus(Status.PENDING.toString());
        blog.setUser(user);

        blogRepository.save(blog);
        return "redirect:/user/create-post?msg=Post created successfully...!";
    }

    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        Optional<User> byEmail = userRepository.findByEmail(email);
        if(byEmail.isEmpty()) {
            throw new UsernameNotFoundException("User not found...!");
        }
        User user = byEmail.get();
        model.addAttribute("user", user);
        return "profile";
    }

    public String createPost(Model model, String msg) {
        BlogDTO blogDTO = new BlogDTO();
        model.addAttribute("blogDTO", blogDTO);
        model.addAttribute("msg", msg);
        return "create-post";
    }
}
