package com.ent;

public class Laptop {
	int price;
	String brand;
	public Laptop() {
		System.out.println("Laptop constructor...");
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return this.brand;
	}
}
