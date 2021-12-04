package exams.second;

public class Q1Client {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle(2);
		Square square1 = new Square(4);
		
		System.out.println(circle1.toString());
		System.out.println(circle1.area());
		System.out.println(square1.getSide());
		System.out.println(circle1.equals(square1));

	}

}
