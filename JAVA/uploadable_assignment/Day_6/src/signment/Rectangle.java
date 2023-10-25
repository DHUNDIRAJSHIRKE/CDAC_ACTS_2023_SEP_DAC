package signment;

public class Rectangle extends BoundedShape {
	private double height;
	private double width;
	Rectangle(double x, double y, double height, double width){
		super(x,y);
		this.height = height;
		this.width = width;
	}
	public double area() {
		return height*width;
	}
	
}
