package com.spider.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Oppo implements Mobile{
    public void call() {
        System.out.println("Calling from Oppo...");
    }
}
