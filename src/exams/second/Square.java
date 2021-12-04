package exams.second;

public class Square extends Shape{

	private double side;

	public Square() {
		super();
		this.side = 1;
	}

	public Square(double side) {
		super();
		setSide(side);
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if(side > 0) {
			this.side = side;
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
		Square other = (Square) obj;
		return Double.doubleToLongBits(side) == Double.doubleToLongBits(other.side);
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}
	
	public double area() {
		return side * side;
	}
	
	public double perimeter() {
		return 4 * side;
	}
	
	
	
}
