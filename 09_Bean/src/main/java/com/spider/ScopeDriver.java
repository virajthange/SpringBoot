package com.spider;

import com.spider.scope.Config;
//import com.spider.scope.bean1.Config;
import com.spider.scope.bean1.Person;
//import com.spider.scope.bean2.Config;
import com.spider.scope.bean2.Student;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeDriver {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student = context.getBean(Student.class);
        System.out.println(student);

        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}
