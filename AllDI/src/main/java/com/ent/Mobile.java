package com.ent;

import java.util.List;

public class Mobile {
	int price;
	String brand;
	private Battery battery;
	private List<String> apps;
	private List<Application> applications;
	private List<Object> objects;

	public Mobile() {
		System.out.println("Mobile constructor...");
	}

	
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public void setApps(List<String> apps) {
		this.apps = apps;
	}
	
	public List<Object> getObjects() {
		return objects;
	}
	public String getBrand() {
		return brand;
	}
	public Battery getBattery() {
		return battery;
	}
	public List<String> getApps() {
		return apps;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Mobile [price=" + price + ", brand=" + brand + "]";
	}

}
