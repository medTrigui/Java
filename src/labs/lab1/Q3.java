package labs.lab1;


//Mohamed Trigui CS201-01

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		//Creating a new class
				Scanner input = new Scanner(System.in);	
				
		//Asking for name, input name, printing out first letter		
				System.out.println("Enter your name");
				String name = input.nextLine();
				System.out.println("The first letter of your name is "+ name.charAt(0));
		

	}

}
