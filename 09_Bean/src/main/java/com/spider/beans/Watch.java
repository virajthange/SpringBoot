package com.spider.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Watch {
    @Value("5000")
    private int price;
    @Value("Titan")
    private String brand;
    @Autowired
    @Qualifier("getUsers")
    private List<String> usedBy;
//    List<String> getUsers;          //If directly using the method name (defined as @Bean) then no need of @Qualifier

    @Override
    public String toString() {
        return "Price: " + price + " Brand: " + brand + " Used By: " + usedBy;
    }
}
