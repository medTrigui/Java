//Mohamed Trigui CS201-01

package labs.lab2;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		//Creating a new scanner
	 Scanner input = new Scanner(System.in);
	 
	   //Asking for input, input limit
	 System.out.println("Enter a limit");
	 int limit = Integer.parseInt(input.nextLine());
	 
	   //for loop that moves from a line to another
	 for (int i=1; i<=limit; i++) {
	   //for loop that prints the stars needed 
		 for (int j=0; j<i; j++) {
			 
			System.out.print("*");
			 
		 }
		 System.out.println();
		 
	 }
	 
	 

	}

}
