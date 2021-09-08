/*
 * 
 * 		Input in Faranheit			Expected Out in Celcius		    Actual Out
 * 			32		          |			      0		           |	    	0
 * 			98		          |	    	 36.66666              |	 	 36.66666   
 * 		   -32		          |			-35.55555		       |        -35.55555	
 *         
 * 
 *      Input in Celcius            Expected Out in Faranheit          Actual Out
 *         0                   |              32                 |           32
 *         45                  |             113                 |         113
 *         -10                 |             -14                 |        -14
 */
package labs.lab1;
// Mohamed Trigui CS 201-01
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		// Creating a new class
		 Scanner input = new Scanner(System.in);
		 
		// Asking for temp in Faranheit, input, output it in Celcius
		 System.out.println("Enter temperature in Faranheit"); 
		 double tf = Double.parseDouble(input.nextLine());
		 System.out.println("The temperature you entered is "+ (tf-32)/1.8 + " Celcius\n");
		 
		 // Asking for temp in Faranheit, input, output it in Celcius
		 System.out.println("Enter temperature in celcius");
		 double tc = Double.parseDouble(input.nextLine());
		 System.out.println("The temperature you entered is" + ((tc*1.8) + 32) + " Faranheit\n");

	}

}
