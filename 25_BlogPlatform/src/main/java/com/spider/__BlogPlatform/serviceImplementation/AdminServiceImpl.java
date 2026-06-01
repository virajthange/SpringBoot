package com.spider.__BlogPlatform.serviceImplementation;

import com.spider.__BlogPlatform.dtos.BlogDTO;
import com.spider.__BlogPlatform.dtos.UserDTO;
import com.spider.__BlogPlatform.entities.Blog;
import com.spider.__BlogPlatform.entities.User;
import com.spider.__BlogPlatform.enums.Role;
import com.spider.__BlogPlatform.enums.Status;
import com.spider.__BlogPlatform.repositories.BlogRepository;
import com.spider.__BlogPlatform.repositories.UserRepository;
import com.spider.__BlogPlatform.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public String managePosts(Model model) {
        List<Blog> all = blogRepository.findAll();
        model.addAttribute("blogs", all);
        return "manage-post";
    }

    public String manageUsers(Model model) {
        List<User> allusers = userRepository.findByRole(Role.USER);
        System.out.println(allusers);
        model.addAttribute("users", allusers);
        return "manage-user";
    }

    @Override
    public String postModeration(Model model) {
        List<Blog> blogs = blogRepository.findByStatus(Status.PENDING.name());
        model.addAttribute("blogs", blogs);
        return "post-moderation";
    }

    @Override
    public String approve(Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found...!");
        }
        Blog blog = byId.get();
        blog.setStatus(Status.ACCEPT.name());
        blogRepository.save(blog);
        return "redirect:/admin/post-moderation";
    }

    @Override
    public String reject(Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found...!");
        }
        Blog blog = byId.get();
        blog.setStatus(Status.REJECT.name());
        blogRepository.save(blog);
        return "redirect:/admin/post-moderation";
    }

    @Override
    public String remove(Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found...!");
        }
        Blog blog = byId.get();
        blog.setStatus(Status.REMOVE.name());
        blogRepository.delete(blog);
        return "redirect:/admin/post-moderation";
    }

    @Override
    public String editBlog(Model model, Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found !");
        }
        Blog blog = byId.get();

        BlogDTO blogDTO = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDTO);

        model.addAttribute("blogDTO", blogDTO);
        return "edit-post";
    }

    @Override
    public String editBlogLogic(BlogDTO blogDTO) {
        Optional<Blog> byId = blogRepository.findById(blogDTO.getId());
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found...!");
        }
        Blog blog = byId.get();
        blog.setContent(blogDTO.getContent());
        blog.setTitle(blogDTO.getTitle());
        blog.setTags(blogDTO.getTags());
        blogRepository.save(blog);
        return "redirect:/admin/dashboard";
    }

    @Override
    public String deleteBlog(Integer id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("Blog not found...!");
        }
        Blog blog = byId.get();
        blogRepository.delete(blog);
        return "redirect:/admin/dashboard";
    }

    @Override
    public String editUser(Integer id, Model model) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isEmpty()) {
            throw new RuntimeException("User not found !");
        }
        User user = byId.get();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        model.addAttribute("userDTO" ,userDTO);
        return "edit-user";
    }

    @Override
    public String editUserLogic(UserDTO userDTO) {
        Optional<User> byId = userRepository.findById(userDTO.getId());
        User user = byId.orElseThrow(()-> new RuntimeException("User not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return "redirect:/admin/manage-users";
    }
}