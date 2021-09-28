//Mohamed Trigui CS201-01
package labs.lab3;

public class Question3 {

	public static void main(String[] args) {
	
//Declaring a given array 
		int[] values= {72, 101, 108, 108, 111, 32, 101, 118, 101, 114, 121, 111, 110, 101, 33, 32, 76, 111, 111, 107, 32, 97, 116, 32, 116, 104, 101, 115, 101, 115, 101, 32, 99, 111, 111, 108, 32, 115, 121, 109, 98, 111, 108, 115, 58, 32, 63264, 32, 945, 32, 8747, 32, 8899, 32, 62421};
	
//Finding the minimum: "min" takes the next value if it's less than the previous one
		int min = values[0];
		for (int i=0; i< values.length; i++) {
			
			if (values[i]<min) {
				min = values[i];
			
			}
		}		
		
		
//Printing the minimum out to the console	
		System.out.println("Minimum is: " +min);

	}

}
