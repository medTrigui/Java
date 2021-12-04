package exams.second;
import java.util.Scanner;
public class QuestionFour {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] data = new int[] {8, 13, 18, 24, 31, 64, 65, 71, 73, 87};
		
		System.out.println("Enter a number to search: ");
		int n = Integer.parseInt(input.nextLine());
		System.out.println(binary(data, n));
		
		input.close();
	}
	
	
	
	public static int binary(int[] data, int item) {
		
		int min = 0;
		int max = data.length;
		while(min < max) {
			int mid = (max + min) /2;
			if (data[mid] == item ) {
				return mid;
			} else if(data[mid] < item ) {
				min = mid +1;
			} else {
				max = mid -1;
			}
		}
		return -1;
	}

}
