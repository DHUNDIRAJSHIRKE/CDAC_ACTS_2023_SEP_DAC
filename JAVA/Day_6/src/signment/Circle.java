package signment;
import java.lang.Math.*;
public class Circle extends BoundedShape{
	private double radius;
	public Circle(double x,double y,double radius) {
		super(x,y);
		this.radius = radius;
	}
	public double area() {
		return Math.PI*radius*radius;
	}
}
