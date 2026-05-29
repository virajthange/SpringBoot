package com.spider.__BlogPlatform.services;

import com.spider.__BlogPlatform.entities.User;
import com.spider.__BlogPlatform.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetail implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(username);
        if(byEmail.isEmpty()) {
            throw new RuntimeException("User not found !");
        }
        User user = byEmail.get();
        return org.springframework.security.core.userdetails.
                User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }
}
