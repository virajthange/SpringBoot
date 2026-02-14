package com.spider.scope.bean1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value("1")
    int id;
    @Value("Rahul")
    String name;

    @Override
    public String toString() {
        return "Id: " + id + ", name: "+ name;
    }
}
