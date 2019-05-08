package com.gaurav.springAOP.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called value is: " + name);
		throw(new RuntimeException());
	}

}
