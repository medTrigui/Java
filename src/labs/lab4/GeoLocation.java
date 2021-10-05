//Mohamed Trigui CS201-L04
package labs.lab4;

public class GeoLocation {

	private double lat;
	private double lng;
	
	
//Default constructor	
	public GeoLocation() {
		this.lat = 0;
		this.lng = 0;
	
	}

//Non-Default constructor
	public GeoLocation(double lat, double lng) {
		setLat(lat);
		setLng(lng);
	}

//Accessor methods
	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

//Mutator methods
	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

//toString	
	public String toString() {
		return "(" + this.lat + "," + this.lng + ")";
	}
	
//7.Method
	public boolean validLat() {
	if ((this.lat >=-90) && (this.lat <= 90)) {
		return true;
	} else {
	return false;
	}	
	}
//8.
	public boolean validLng() {
		if ((this.lat >=-180) && (this.lat <= 180)) {
			return true;
		} else {
		return false;
		}	
		}
	
 
	
	
}
