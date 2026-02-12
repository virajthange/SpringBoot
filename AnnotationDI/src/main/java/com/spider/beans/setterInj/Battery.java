package com.spider.beans.setterInj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Battery {
    @Value(value = "40000")
    int backup;
    @Value(value = "SAMSUNG")
    String brand;

    public void details() {
        System.out.println("Backup: "+ backup);
        System.out.println("Brand: "+ brand);
    }
}
