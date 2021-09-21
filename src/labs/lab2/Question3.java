//Mohamed Trigui CS201-01

package labs.lab2;
import java.util.Scanner;
public class Question3 {

	public static void main(String[] args) {
		
		//Creating a new scanner
		Scanner input = new Scanner(System.in);
		
		//Declaring the boolean variable that allows to exit
		boolean done = false;
		//Declaring the choice number
		int number; 
		
		//Loop that stops when done is true
		while (!done) {
			//Printing out Menu
			System.out.println("[1]: Hello\n[2]:Addition\n[3]:Multiplication\n[4]:Exit ");
			//Input choice
		    number = Integer.parseInt(input.nextLine());
		    
		    switch(number) {
		    //Printing out Hello
		    case 1:
		    	System.out.println("Hello");
		    	break;
		    //Addition	
		    case 2:
		    	//Asking for first input, input Number1
		    	System.out.println("Enter Number1:\n>");
		    	int x = Integer.parseInt(input.nextLine());
		    	
		    	//Asking for first input, input Number2
		    	System.out.println("Enter Number2:\n>");
		    	int y = Integer.parseInt(input.nextLine());
		    
		    	//Printing out result of addition
		    	System.out.println(x + " + " + y +" = " + (x+y));
		    	break;
		    //Multiplication
		    case 3:
		    	
		    	//Asking for first input, input Number1
		    	System.out.println("Enter Number1:\n>");
		    	int u = Integer.parseInt(input.nextLine());
		    	
		    	//Asking for first input, input Number2
		    	System.out.println("Enter Number2:\n>");
		    	int v = Integer.parseInt(input.nextLine());
		    	
		    	//Printing out result of Multiplication
		    	System.out.println(u + " * " + v +" = " + (u*v));
		    	break;
		    //Exit case
		    case 4:
		    	done = true;
		    	break;
		    default:
				System.out.println("What!?");
		    
		      
		    }
		   		
		}
		
		
		input.close();
		System.out.println("Goodbye");
		
		
		
		
		
		
		

	}

}
