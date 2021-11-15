package labs.lab7;
import java.util.Scanner;
public class Question3 {

	public static void main(String[] args) {
		String[] lang = {"c", "html", "java", "python", "ruby", "scala"};
		
		Scanner input = new Scanner(System.in);
		System.out.print("Search term: ");
		String value = input.nextLine();
		int index = search(lang, value);
		if (index == -1) {
			System.out.println(value + " not found.");
		} else {
			// I added 1 to the index so that the output is clearer to the user.
			System.out.println(value + " found at index " + (index +1) + ".");
		}
		
		input.close();
	}

	public static int search(String[] array, String value) {
		return search(array, value, 0, array.length);
	}
	
	public static int search(String[] array, String value, int start, int end) {
		if (start >= end) {
			return -1; // not found
		}
		
		int middle = (start + end) / 2;
		if (array[middle].compareToIgnoreCase(value) < 0) {
			return search(array, value, middle+1, end); // value comes after array[middle]
		} else if (array[middle].compareToIgnoreCase(value) > 0) {
			return search(array, value, start, middle);	// value comes before array[middle]
		}
		
		return middle;
	}
		
}
