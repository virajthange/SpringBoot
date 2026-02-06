package com.ent;

public class Application {
	private String name;

	public String getName() {
		return name;
	}
	public Application() {
		System.out.println("Application constructor...");
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
