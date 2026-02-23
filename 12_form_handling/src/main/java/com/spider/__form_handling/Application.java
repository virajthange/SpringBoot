package com.spider.__form_handling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.spider")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
