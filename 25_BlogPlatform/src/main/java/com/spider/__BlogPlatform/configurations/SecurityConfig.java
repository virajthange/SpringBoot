package com.spider.__BlogPlatform.configurations;

import com.spider.__BlogPlatform.enums.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) {
        httpSecurity.csrf(c -> c.disable())
                .authorizeHttpRequests(req ->
                                req.requestMatchers(
                                        "/", "/login", "/register").permitAll()
                                        .requestMatchers("/WEB-INF/**").permitAll()
                                        .requestMatchers("/user/**").hasRole(Role.USER.toString())
                                        .requestMatchers("/admin/**").hasRole(Role.ADMIN.toString())
                                        .anyRequest().authenticated()
                        )
                .formLogin(l -> l.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .failureUrl("/register")
                        .successHandler(this::loginSuccessHandler)
//                        .defaultSuccessUrl("/user/dashboard")
//                       .permitAll()
                )
                .logout(Customizer.withDefaults())
        ;
        return httpSecurity.build();
    }

    private void loginSuccessHandler(HttpServletRequest request, HttpServletResponse response,
                                     org.springframework.security.core.Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {

            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/dashboard");
                return;
            }

            if (authority.getAuthority().equals("ROLE_USER")) {
                response.sendRedirect("/user/dashboard");
                return;
            }
        }

        response.sendRedirect("/auth/login");
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
