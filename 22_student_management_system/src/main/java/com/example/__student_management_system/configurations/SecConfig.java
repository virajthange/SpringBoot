package com.example.__student_management_system.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf((c) -> c.disable())
                .authorizeHttpRequests((req) ->
                        req.
                                requestMatchers("/dashboard").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((f) -> Customizer.withDefaults())
                .logout((l) -> Customizer.withDefaults())
        ;
        return httpSecurity.build();
    }



}
