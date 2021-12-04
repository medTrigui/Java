package exams.second;

public class Circle extends Shape {

	private double radius;

	public Circle() {
		super();
		this.radius = 1;
	}

	public Circle(double radius) {
		super();
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius > 0) {
		this.radius = radius;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	public double area() {
		return radius * radius * 3.14;
	}
	
	public double perimeter() {
		return 2 * radius * 3.14;
	}
	
	
	
}
