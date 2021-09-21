//Mohamed Trigui CS201-01

package labs.lab2;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		
		// Creating a new scanner 
		Scanner input = new Scanner(System.in);
		
		// Asking for input (grade), input grade
		System.out.println("Enter a grade for an exam (or -1 to exit):");
		double grade = Double.parseDouble(input.nextLine());
		
		//Declaring variables
		int i = 0; //Number of grades
		double total = 0.0; //Total of the grades
		
		//Adding grades to the total until a negative input
		while (grade>=0) {
			
		i++;
		total += grade;
		//Asking for grade, input grade
		System.out.println("Enter another grade (or -1 to exit): ");
		grade = Double.parseDouble(input.nextLine());
		
			
		}
		
		input.close();
		
		//Output average which is total divided by the number of grades
		System.out.println("Average is: "+ total/i);

		
		

	}

}
