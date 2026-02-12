package com.spider.beans.variableInj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lid {
    @Value(value = "round")
    String shape;

    public void details() {
        System.out.println("Shape of lid: "+ shape);
    }
}
