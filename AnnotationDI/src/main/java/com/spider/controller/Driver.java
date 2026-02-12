package com.spider.controller;

import com.spider.Configuration.Config;
import com.spider.beans.constructorInj.Car;
import com.spider.beans.setterInj.Mobile;
import com.spider.beans.variableInj.Bottle;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Bottle bottle = context.getBean(Bottle.class);
        bottle.details();

        System.out.println();
        System.out.println("---Mobile Details---");
        Mobile mobile = context.getBean(Mobile.class);
        mobile.details();

        System.out.println("---Car---");
        Car car = context.getBean(Car.class);
        System.out.println(car);
    }
}
