package com.example.__JWT_Authentication.service;

import com.example.__JWT_Authentication.entities.Users;
import com.example.__JWT_Authentication.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
//We have to create this class to tell spring security , we don't want your system user we are using our own users
//It is mandatory to provide if want to use inmemory or db
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found !");
        }
        Users users = optionalUser.get();


        return User.withUsername(users.getEmail()).password(users.getPassword()).build();
    }
}