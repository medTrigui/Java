package exams.first;
import java.util.Scanner;
public class QuestionThree {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		String[] words = new String[5];
		
		for(int i=0; i<words.length; i++) {
			System.out.println("Enter word " + (i+1));
			words[i] = input.nextLine();
		}
		
		
		String last = words[0];
		for(int i=1; i<words.length; i++) {
			if (words[i].compareTo(last) > 0) {
				last = words[i];
			}
		}
		
		System.out.println("\n" + last);
		
		input.close();
	}

}
