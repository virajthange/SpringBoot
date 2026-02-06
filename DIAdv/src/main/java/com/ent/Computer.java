package com.ent;

public class Computer {
	Laptop laptop;
	public Computer() {
		System.out.println("Computer constructor...");
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void getLaptop() {
		System.out.println(this.laptop.brand);
	}

}
