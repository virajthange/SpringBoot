package com.spider.controllers;

import com.spider.beans.ALLCAP;
import com.spider.beans.Student;
import com.spider.beans.TestBean;
import com.spider.configurations.Config;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student =  context.getBean(Student.class);
        Student student2 = (Student) context.getBean("student");
        student.play();
        System.out.println("Printing student: "+student2);

        ALLCAP allcap = (ALLCAP) context.getBean("ALLCAP");
        System.out.println("All cap is: "+allcap);

        TestBean testbean = (TestBean) context.getBean("testBean");
        System.out.println("Printing testbean: "+testbean);

    }
}
