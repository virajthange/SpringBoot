package com.spider.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("samsungBean")
//@Primary
public class Samsung implements Mobile{
    public void call() {
        System.out.println("Calling from samsung...");
    }
}
