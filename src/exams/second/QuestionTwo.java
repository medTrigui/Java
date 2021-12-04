package exams.second;
import java.util.Scanner;
import java.util.ArrayList;
public class QuestionTwo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		
		boolean done = false;
		while(!done) {
			System.out.println("Enter a word or done to finish: ");
			String word = input.nextLine();
			words.add(word.toUpperCase());
			
			if (word.equalsIgnoreCase("done")) {
				done = true;
			}
			
		} 
		
		
		char c;
		for(c = 'A' ; c <= 'Z' ; ++c) {
			int a = 0;
			for (int i = 0; i<words.size() - 1; i++) {
				if (c == words.get(i).charAt(0)) {
					a = a + 1;
				}
			}
			if (a!=0) {
			System.out.println(c + " - " + a);
			}
		}
		
		
			input.close();
	}
}
