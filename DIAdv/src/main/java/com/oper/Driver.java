package com.oper;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ent.Computer;
import com.ent.Laptop;

public class Driver {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("laptopConfig.xml");
//		Once we create an object of ConfigurableApplicationContext, automatically it creates the object of all the bean classes
		
//		Laptop laptop = (Laptop) context.getBean("laptopBean");
//		System.out.println(laptop.getBrand());
		
		Computer computer = (Computer) context.getBean("compBean2");
		computer.getLaptop();
	}

}
