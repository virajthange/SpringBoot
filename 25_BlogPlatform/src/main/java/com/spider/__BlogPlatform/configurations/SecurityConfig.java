package com.spider.__BlogPlatform.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) {
        httpSecurity.csrf(c -> c.disable())
                .authorizeHttpRequests(req ->
                                req.requestMatchers("/login", "/register").permitAll()
                                        .anyRequest().authenticated()
                        )
                .formLogin(l -> l.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .failureUrl("/registr")
                        .successForwardUrl("/user-dashboard")
                )
                .logout(Customizer.withDefaults())
        ;
        return httpSecurity.build();
    }

}
