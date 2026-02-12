package com.oper;

import com.ent.Car;
import com.ent.Library;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ent.Computer;
import com.ent.Laptop;

import java.net.CacheRequest;

public class Driver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("laptopConfig.xml");
//		Once we create an object of ConfigurableApplicationContext, automatically it creates the object of all the bean classes
		
		Laptop laptop = (Laptop) context.getBean("laptopBean");
		System.out.println(laptop.getBrand());
		
		Computer computer = (Computer) context.getBean("compBean2");
		computer.getLaptop();

		System.out.println();
		System.out.println("---Library Details---");
		Library library = (Library) context.getBean("libBean");
		System.out.println(library);

		System.out.println();
		System.out.println("---Car & Engine");
		Car car = (Car) context.getBean("car");
		System.out.println(car);
	}
}
