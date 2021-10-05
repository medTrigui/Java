//Mohamed Trigui CS201-L04
package labs.lab4;


public class GeoLocationTest {

	public static void main(String[] args) {
		//Default		
		GeoLocation Geo1 = new GeoLocation();
	//Non-default
		GeoLocation Geo2 = new GeoLocation(80.7,100.5);

		
		
	//Display the values 
	System.out.println("(" + Geo1.getLat()+ "," + Geo1.getLng() + ")");	
	System.out.println("(" + Geo2.getLat()+ "," + Geo2.getLng() + ")");
			
		
			
			
			

	}

}
