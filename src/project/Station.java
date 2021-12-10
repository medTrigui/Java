/*Mohamed Trigui 12/09/2021
 * Station class is the abstract class that represents a station
 * A station has a name, latitude, longitude, description and availability of wheelchair
 */

package project;

import java.util.Objects;

public abstract class Station {
	
	//Instance variables:
	protected String name;
	protected double latitude;
	protected double longitude;
	protected String description;
	protected boolean wheelchair;
	
	//Default constructor:
	public Station() {
		this.name = "Chicago";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.description = "elevated";
		this.wheelchair = true;
	}
	//Non default constructor
	public Station(String name, double latitude, double longitude, String description, boolean wheelchair) {
		setName(name);
		setLatitude(latitude);
		setLongitude(longitude);
		setDescription(description);
		setWheelchair(wheelchair);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		if(this.latitude >=0.0) {
		this.latitude = latitude;
		}
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		if(this.longitude >=0.0) {
		this.longitude = longitude;
		}
	}
	public String getDescription() {
		return description;
	}
	//need to verify later
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isWheelchair() {
		return wheelchair;
	}
	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
				&& Objects.equals(name, other.name) && wheelchair == other.wheelchair;
	}
	@Override
	public String toString() {
		return "Station [name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", description="
				+ description + ", wheelchair=" + wheelchair + "]";
	}

	
	public abstract String station() ;
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
