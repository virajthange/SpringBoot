package com.spider.__spring_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration   //telling to spring that this is configuration class contains bean definitions
@EnableWebSecurity
//specifying to override the default security, It activates the security filter chain that intercepts all HTTP requests.
public class SecurityConfig {

//    This method configures security rules for HTTP requests.
//    HttpSecurity is used to configure things like: authentication, authorization, login,logout,  CSRF protection
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((req) -> req        //This defines who can access which URLs.
                        .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((f) -> Customizer.withDefaults())      //Enables default login page provided by Spring Security
                .logout((l) -> Customizer.withDefaults())         //Enables logout functionality.
        ;
        return httpSecurity.build();    //This converts the configuration into a SecurityFilterChain bean used by Spring Security
    }

//    In Spring Boot, UserDetailsService is a core interface from Spring Security used to load user-specific data during authentication (like username, password, roles).

    @Bean
    public UserDetailsService inMemory() {
        UserDetails user1 = User.withUsername("Viraj")
                .password("{noop}123")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("Ram")
                .password("{noop}345")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

}
