package com.spider.__ReactConnection.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private Integer id;
    private String name;
    private Integer age;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
