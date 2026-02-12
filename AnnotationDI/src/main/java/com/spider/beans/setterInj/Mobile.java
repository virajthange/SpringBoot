package com.spider.beans.setterInj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    @Value(value = "10000")
    int price;
    @Value(value = "MI")
    String brand;
    @Autowired
    Battery battery;

    public void setPrice(int price) {
        this.price = price;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setBattery(Battery battery) {
        this.battery = battery;
    }
    public void details() {
        System.out.println("price: "+ price);
        System.out.println("Brand: "+ brand);
        battery.details();

    }
}
