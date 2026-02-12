package com.oper;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spider.Car;
import com.spider.Engine;

public class Driver {

	public static void main(String[] args) {

//		Resource resource = new ClassPathResource("config.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		This doesn't work in modern spring versions
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Car car = (Car) context.getBean("carBean");
		car.showMil();
		
		Engine engine = (Engine) context.getBean("engineBean");
		engine.run();
	}

}
