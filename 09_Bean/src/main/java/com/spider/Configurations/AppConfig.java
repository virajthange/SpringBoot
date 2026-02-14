package com.spider.Configurations;

import com.spider.beans.HeadPhones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.spider.beans")
public class AppConfig {
    @Bean
    public HeadPhones getHeadPhones() {
        return new HeadPhones();
    }

//    Here we have 2 @Bean who have same return type - If we make any one primary always that primary bean will be returned
    @Bean
//    @Primary
    public List<String> getUsers() {
        return Arrays.asList("Viraj", "Yash", "Swaraj");
    }
    @Bean
    public List<String> getProducts() {
        return Arrays.asList("Boat 2", "Boat sparx", "Boat pro");
    }
}
