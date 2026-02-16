package com.spider.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value(value = "Viraj")
    String name;
    @Value(value = "30")
    int age;
    @Autowired
//    @Qualifier(value = "samsungBean")
    @Qualifier(value = "vivoBean")
    Mobile mobile;

    public void details() {
        System.out.println("Name: "+ name+ "\nAge: "+ age);
        mobile.call();
    }
}

//Scope of @Primary is global whereas scope of @Qualifier is local
//@Qualifier Overrides @Primary
//@Qualifier is prefered in constructor injection