package com.spider.beans.variableInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bottle {
    @Value(value = "35")
    private int price;
    @Value(value = "round")
    private String shape;
    @Value(value = "pink")
    private String color;
    @Autowired
    private Lid lid;

    public void details() {
        System.out.println("Price: "+ price);
        System.out.println("Shape: "+ shape);
        System.out.println("Color: "+ color);
        lid.details();
    }

}
