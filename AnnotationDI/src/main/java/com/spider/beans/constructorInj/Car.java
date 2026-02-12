package com.spider.beans.constructorInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    int id;
    String color;
    Engine engine;

    public Car(@Value(value = "1") int id,@Value(value = "White") String color,@Autowired Engine engine) {
        this.id = id;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\nColor: "+ this.color + "\nEngine: "+ engine;
    }
}
