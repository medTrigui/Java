package exams.second;

public class QuestionThree {

	public static void main(String[] args) {
		String[] lang = {"briefly" , "mugwump" , "articulation", "sync", "skein", "moire", "advisability", "varmint", "mandibular", "evergreen" };
		 lang = sort(lang);
		 
		 for(String l :lang) {
			 System.out.print(l + "- ");
		 }
		 
		
	}

	
	public static String[] sort(String[] array) {
		boolean done = false;
		
		do {
			done = true;
			for(int i =0; i<array.length -1; i++) {
				if(array[i+1].compareTo(array[i]) < 0) {
					String temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					done = false;
				}
			}
		
		} while (!done);
		
		return array;
	}
	
	
	
}