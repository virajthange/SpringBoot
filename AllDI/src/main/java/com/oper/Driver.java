package com.oper;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ent.Application;
import com.ent.Mobile;

public class Driver {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Mobile mobile = (Mobile) context.getBean("mobileBean");
		System.out.println(mobile);
		System.out.println(mobile.getBattery());    //Object
		
		List<String> apps = mobile.getApps();     //List<String>
//		for (String val : apps) {
//			System.out.println(val);	
//		}
		apps.forEach(val -> System.out.println(val));
		
		List<Application> applications = mobile.getApplications();
		applications.forEach(val -> System.out.println(val));
		
		List<Object> objects = mobile.getObjects();
		for(Object val: objects) {
			System.out.println(val);
		}
		
	}
}
