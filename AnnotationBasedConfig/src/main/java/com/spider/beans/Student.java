package com.spider.beans;

import org.springframework.stereotype.Component;

//@Component(value = "studentBean")
@Component
public class Student {
    int id;
    String name;

    Student() {
        System.out.println("Student constructor has been called...");
    }
    public void play() {
        System.out.println("Student is playing....");
    }
}
