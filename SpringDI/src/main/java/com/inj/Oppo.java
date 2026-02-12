package com.inj;

public class Oppo {
	int price;
	String name;

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void showPrice() {
		System.out.println("The name of mobile is: "+ name);
		System.out.println("The price of mobile is: "+ price);

	}

}
