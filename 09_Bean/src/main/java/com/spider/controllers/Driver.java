package com.spider.controllers;

import com.spider.Configurations.AppConfig;
import com.spider.beans.HeadPhones;
import com.spider.beans.Watch;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("---Watch Details---");
        Watch watch = context.getBean(Watch.class);
        System.out.println(watch);

        System.out.println();
        System.out.println("---Headphone Details---");
        HeadPhones headPhones = context.getBean(HeadPhones.class);
        System.out.println(headPhones);

     }
}
