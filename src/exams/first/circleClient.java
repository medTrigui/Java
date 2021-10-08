
package exams.first;

public class circleClient {

	public static void main(String[] args) {

		Circle c1 = new Circle();
		Circle c2 = new Circle(2);
		
		System.out.println(c1.getRadius());
		System.out.println(c2.getRadius());
		
		c1.setRadius(-1);
		System.out.println(c1.getRadius());
		
		c1.setRadius(3);
		System.out.println(c1.getRadius());
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		System.out.println(c1.equals(c2));
		
		System.out.println(c1.area());
		System.out.println(c2.circumference());
	}

}
