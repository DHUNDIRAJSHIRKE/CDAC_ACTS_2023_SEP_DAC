package signment;

public abstract class BoundedShape {
	private double x;
	private double y;

	public BoundedShape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public abstract double area();

	@override
	public String toString() {
		return "(X : "+x+", Y"+y+" )";
	}
}
