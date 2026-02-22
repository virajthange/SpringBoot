package com.spider.springWebProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.spider")
public class SpringWebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebProjectApplication.class, args);
	}

}
