package com.spider.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class HeadPhones {
    @Value("300")
    private int price;
    @Value("Black")
    private String color;
    @Value("Boat")
    private String brand;
    @Autowired
    @Qualifier("getProducts")
    private List<String> products;
//    List<String> getProducts;


    public String toString() {
        return "Price: "+ price + " Color: "+ color+ " Brand: "+ brand + " Products: " + products;
    }
}
