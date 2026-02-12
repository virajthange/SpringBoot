package com.spider.beans;

import org.springframework.stereotype.Component;

@Component(value = "vivoBean")
public class Vivo implements Mobile{
    public void call() {
        System.out.println("Calling from vivo...");
    }
}
