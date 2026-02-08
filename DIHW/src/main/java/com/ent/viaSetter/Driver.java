package com.ent.viaSetter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student students = (Student) context.getBean("studentBean");
		
		for(Subject sub : students.getSubjects()) {
			System.out.println(sub);
		}
		
		
		Shop shop =(Shop) context.getBean("shopBean");
		String id = shop.getName();
		System.out.println(id);
		for(String val : shop.getItems().keySet()) {
			System.out.println(val +" "+ shop.items.get(val)); 
		}
	}
}
