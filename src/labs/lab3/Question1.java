//Mohamed Trigui CS201-01
package labs.lab3;
import java.io.*;
import java.util.Scanner;
public class Question1 {

	public static void main(String[] args) throws IOException {
//Creating a representative of  file
		File f = new File("src/labs/lab3/grades.csv");
//Creating a new scanner
		Scanner input = new Scanner(f);
		
//Declaring variables
		int i =0;
		double total = 0.0;
		
//Reading the lines in the file as long as there is a next line starting from the index of the comma towards the end
		while (input.hasNextLine()) {
			String line = input.nextLine();
			int ind = line.indexOf(',');
			String score = line.substring(ind+1);
			double grade = Double.parseDouble(score);
			
			i++;
//Adding the grades to obtain the total
			total += grade;
			
		}
		
		input.close();
//Printing out the average
		System.out.println("Average is : " + total/i);
		
		
		
		
		
	
		
	}

}
