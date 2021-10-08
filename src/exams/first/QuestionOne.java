package exams.first;
import java.util.Scanner;
public class QuestionOne {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an integer: ");
		
		int x = Integer.parseInt(input.nextLine());
		
		if ((x%3 == 0) && (x%5 != 0)) {
			System.out.println("foo");
		} else if ((x%5 == 0) && (x%3 != 0)){
			System.out.println("bar");
		} else if ((x%3 == 0) && (x%5 == 0)) {
			System.out.println("foobar");
		}
		
		
		input.close();
	}

}
