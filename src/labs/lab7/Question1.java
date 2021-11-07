package labs.lab7;

public class Question1 {
	
	public static void main(String[] args) {
		int[] lang = {10, 4, 7, 3, 8, 6, 1, 2, 5, 9};
		
		lang = sort(lang);
		
		for (int l : lang) {
			System.out.print(l + " ");
		}
		
	}
	
	public static int[] sort(int[] array) {
		boolean done = false;
		
		do {
			done = true;
			for (int i=0; i<array.length-1; i++) {
				if (array[i+1] < (array[i]) ) {
					int temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					done = false;
				}
			}
		} while (!done);
		
		
		
		
		
		return array;
		

	}
	

}
