package exams.first;
import java.util.Scanner;
public class QuestionTwo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a positive number (or -1 to exit): ");
		double number = Double.parseDouble(input.nextLine());
		
		int i =0;
		double total = 0.0;
		
		while (number>=0) {
			i++;
			total += number;
			System.out.println("Enter another number (or -1 to exit): ");
			number = Double.parseDouble(input.nextLine());
		}
		
		input.close();
		
		System.out.println("Average is: " + total/i);
		
		
	}

}
