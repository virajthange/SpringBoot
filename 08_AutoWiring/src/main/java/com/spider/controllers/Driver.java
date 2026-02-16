package com.spider.controllers;

import com.spider.beans.Person;
import com.spider.configurations.Config;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//We can make this file as configuration file , no need of any external file
@Configuration
@ComponentScan(basePackages = "com.spider.beans")
public class Driver {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Driver.class);
        Person person = (Person) context.getBean("person");
        System.out.println("---Person Details---");
        person.details();
    }
}

