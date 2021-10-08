//Question4
package exams.first;

public class Circle {

	private double  radius;

	public Circle() {
		this.radius = 1;
	}

	public Circle(double radius) {
		setRadius(radius);
	}

	public void setRadius(double radius) {
		if (radius>0) {
			this.radius = radius;	
		} else {
			this.radius = 1;
		}
		
	}

	public double getRadius() {
		return radius;
	}

	
	public String toString() {
		return "Circle[radius=" + radius + "]";
	}
	
	public boolean equals(Circle c) {
		if (radius != c.getRadius()) {
			return false;
		} else {
			return true;
		}
	}
	
	public double area() {
		return (3.14*radius*radius);
	}
	
	public double circumference() {
		return (2*3.14*radius);
	}
}
