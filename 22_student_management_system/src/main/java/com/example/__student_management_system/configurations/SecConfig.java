package com.example.__student_management_system.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf((c) -> c.disable())
                .authorizeHttpRequests((req) ->req
                        .requestMatchers("/", "/login", "/register", "/reg", "/auth", "/forgetpassword","/sendotp", "/otp", "/changepass", "/changepassword").permitAll()
                        .requestMatchers("/WEB-INF/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((f) -> f
                        .loginPage("/login")
                        .loginProcessingUrl("/auth")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/dashboard", true)
                        .failureUrl("/login?msg=Invalid Credentials")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                );
//                .logout(Customizer.withDefaults())
//                .logout((l) -> l.logoutUrl("/logout").permitAll())
        ;
        return httpSecurity.build();
    }
}
