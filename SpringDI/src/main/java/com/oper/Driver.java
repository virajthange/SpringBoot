package com.oper;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inj.Oppo;
import com.inj.Student;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Oppo oppo = (Oppo) context.getBean("oppoBean");
		oppo.showPrice();

	}

}
