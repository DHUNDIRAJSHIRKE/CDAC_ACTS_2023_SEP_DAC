package com.app.fruits;

public class Fruit {
	private String name;
	private String color;
	private double weight;
	boolean fresh = true;

	public Fruit(String name, String color, double weight) {
		this.name = name;
		this.color = color;
		this.weight = weight;
		// System.out.println("inside fruit");
	}

	public boolean getFresh() {
		return fresh;
	}

	public String getName() {
		return "Name: " + name;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}

	public String toString() {
		// System.out.println("inside toString");
		return "\t Name: " + name + " \tcolor: " + color + "\t weight: " + weight;

	}

	public String taste() {
		return "No Specific Taste";
	}
}
