import java.lang.Math;

class Point2D {
	double x;
	double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String show() {
		return "(" + x + ", " + y+")";
	}

	public Boolean isEqual(Point2D obj) {
		if ((this.x == obj.x) && (this.y == obj.y)) {
			return true;
		} else {
			return false;
		}
	}

	public double calculateDistance(Point2D obj) {
		double dis, x3, y3;
		x3 = (this.x - obj.x) * (this.x - obj.x);
		y3 = (this.y - obj.y) * (this.y - obj.y);
		dis = x3 + y3;
		dis = Math.sqrt(dis);
		return dis;
	}
}
