package com.oper;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inj.Student;

public class ConstructorInjection {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("constructorConfig.xml");

		Student student = (Student) context.getBean("studentBean");
		student.details();

	}

}
