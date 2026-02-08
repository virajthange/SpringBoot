package com.ent.viaConstructor;

import java.util.Map;

public class Shop {
	private String name;
	private Map<String, Double> items;
	
	public Shop(String name, Map<String, Double> items) {
		this.name = name;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", items=" + items + "]";
	}
}
