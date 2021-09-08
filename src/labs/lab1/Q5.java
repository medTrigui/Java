
// Inputs: length,width,depth |  Expected surface area in square feet  | Actual out
//    15,10,3                 |        3.125                           |   3.125 
//   18,3,6                   |        2.5                             |    2.5
//   80,36,19                 |        70.61111111111111               |   70.61111111111111


package labs.lab1;
//Mohamed Trigui CS201-L01


import java.util.Scanner;
public class Q5 {

	public static void main(String[] args) {
		
		//Creating a new class
		Scanner input = new Scanner(System.in);	

		//Asking for length, input length
		System.out.println("Enter length");
		double l = Double.parseDouble(input.nextLine());
		
		//Asking for width, input width
		System.out.println("Enter width");
		double w = Double.parseDouble(input.nextLine());
		
		//Asking for depth, input depth
		System.out.println("Enter depth");
		double d = Double.parseDouble(input.nextLine());
		
		// Calculating Surface area in square inch and then converting it to square feet
		System.out.println("The amount of wood needed in square feet is " +  (2*d*w + 2*d*l + 2*w*l)/144 + " square feet");
	}

}
