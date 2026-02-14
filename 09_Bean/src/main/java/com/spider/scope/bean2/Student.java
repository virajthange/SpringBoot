package com.spider.scope.bean2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("2")
    int id;
    @Value("Naresh")
    String name;

    @Override
    public String toString() {
        return "Id: " + id + ", name: "+ name;
    }
}
