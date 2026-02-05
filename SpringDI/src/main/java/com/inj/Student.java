package com.inj;

public class Student {

	int age;
	String name;
	
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public void details() {
		System.out.println("Name :" +name+ " "+ "Age is: "+ age);
	}
}
