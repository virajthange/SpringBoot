package com.ent.viaConstructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("conConfig.xml");
		Student student = (Student) context.getBean("studentBean");

		System.out.println(student);
		
		Shop shop =(Shop) context.getBean("shopBean");
		System.out.println(shop);
	}
}

//No need to specify id attribute for inner bean