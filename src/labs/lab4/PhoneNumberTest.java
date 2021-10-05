//Mohamed Trigui CS201-L04
package labs.lab4;

public class PhoneNumberTest {

	public static void main(String[] args) {

//Default
		PhoneNumber ph1 = new PhoneNumber();
//Non-Default
		PhoneNumber ph2 = new PhoneNumber("216","312","584 0001");

		
//Display values
		System.out.println(ph1.toString());
		System.out.println(ph2.toString());
		
		
		
		
	}

}
