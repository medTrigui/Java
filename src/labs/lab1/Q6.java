// Input in inch   |    Expected output    | Actual output
//      2          |       5.08            |     5.08
//     16.23       |       41.2242         |     41.2242
//     98.17       |       249.3518        |    249.3518

package labs.lab1;
//Mohamed Trigui CS201-L01
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		  //Asking for  inches, input  inches,printing it out in centimeters
        System.out.println("Enter  inches");
        double inches = Double.parseDouble(input.nextLine());
        System.out.println("Result in centimeters is "+ inches*2.54);
	}

}
