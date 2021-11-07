package labs.lab7;

public class Question2 {

	public static void main(String[] args) {

String[] lang = {"cat", "fat", "dog", "apple", "bat", "egg"};
		
		lang = sort(lang);
		
		for (String l : lang) {
			System.out.print(l + " ");
		}
}
	public static String[] sort(String[] array) {
		for (int j = 1; j<array.length; j++) {
			int i = j;
			while (i > 0 && array[i].compareTo(array[i-1]) <= 0) {
				swap(array, i, i-1);
				i--;
			}
		}
		return array;
	}
	
	public static void swap(String[] array, int i, int j) {
		String temp = array[i]; 
		array[i] = array[j];
		array[j] = temp;
	}
		
}
