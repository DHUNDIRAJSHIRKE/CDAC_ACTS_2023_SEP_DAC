package com.app.fruits;

public class Orange extends Fruit {
	public Orange(String name, String color, double weight) {
		super(name, color, weight);
	}

	public String taste() {
		return "sour";
	}

	public void juice() {
		System.out.println("Extracting juice!");
	}
}
