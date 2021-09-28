//Mohamed Trigui CS201-01
package labs.lab3;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question2b {

	public static void main(String[] args) {
		
//Creating a new scanner
		Scanner input = new Scanner(System.in);
		
//Declaring variables
		boolean done = false;
//Declaring a first array with the size of 0
		double[] numbers = new double[0];
		
//A while loop that continues to prompt the user for numbers, storing them in an array, until they enter "Done" to finish
		while(!done)
		{							
			 System.out.println("Enter another number or Done to finish: ");
			 String text = input.nextLine();
			 
//exit if the text entered is "done"
			  if(text.equalsIgnoreCase("done"))
			 {
				 done = true;
			 }
//Declaring a new array whose size continues to get larger as long as we don't enter done
			 else 
			 {
				 try
				 {
					 double x = Double.parseDouble(text);
					 double[] array = new double[numbers.length+1];
					 for(int i = 0; i < numbers.length; i++)
					 {
						 array[i] = numbers[i];
					 }
					 numbers = array;
					 
					 numbers[numbers.length-1] = x;
					 
				 }
				 catch(Exception e)
				 {
					 System.out.println(e.getMessage());
					 System.out.println("Could not parse '" + text + "'");
					 
				 }
				 
				
			 }
		} 

//Printing out the numbers saved in the array
		for (int i=0 ; i< numbers.length ; i++) {
			System.out.println(numbers[i] + " ");
		}
			
		try 
		{	
//prompting the user for a file name 
			System.out.println("Enter your file's name: ");
			String name = input.nextLine();
			FileWriter file = new FileWriter("src/labs/lab3/"+name);
			
//Saving numbers to the file
			for (int i=0 ; i< numbers.length ; i++) {
				file.write(numbers[i] + " \n");
				
			}
			file.flush();
			file.close();
		}
		catch(IOException e) {
		System.out.println("Error writing to file.");
		}	
		
		input.close();
	}

}
	