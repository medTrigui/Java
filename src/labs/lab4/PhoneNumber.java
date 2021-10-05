//Mohamed Trigui CS201-L04
package labs.lab4;

public class PhoneNumber {

	//instance variables
  private String countryCode;	
  private String areaCode;
  private String number;


	
	//Default constructor
	
  public PhoneNumber() {
	this.countryCode = "0";
	this.areaCode = "000";
	this.number = "000 0000";
	}


  //non-default constructor
	public PhoneNumber(String countryCode, String areaCode, String number) {
	
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

//accessor and mutator
	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}

//toString method
	
	public String toString() {
		return "PhoneNumber: +" + countryCode + "("+ areaCode+")"  + " " + number ;
	}	

//areaCode valid	

	public boolean areaCodeValid( ) {
		
		if (this.areaCode.length() == 3) {
			return true;
			
		} else {
			return false;
		}
		
		
	}

//Number valid

	public boolean numberValid( ) {
		
		if (this.number.length() == 7) {
			return true;
			
		} else {
			return false;
		}
		
		
	}










}
