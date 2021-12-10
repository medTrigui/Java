/*Mohamed Trigui 12/09/2021
 * MultipleStation  is a sub class that represents a unique station: A station that is multiple i.e, there is more than one latitude and more than one longitude of that station
 * MultipleStation inherits from the Station abstract class and has a specific variable which is the number of stations by the same name.
 */

package project;

public class MultipleStation extends Station {

	//Instance variable
	private int numberOfStations;

	//Default constructor
	public MultipleStation() {
		super();
		setNumberOfStations(1); 
	}

	//non default constructor
	public MultipleStation(String name, double latitude, double longitude, String description, boolean wheelchair, int numberOfStations) {
		super(name, latitude, longitude, description, wheelchair);
		this.setNumberOfStations(numberOfStations);
	}

	//Getters and setters 
	public int getNumberOfStations() {
		return numberOfStations;
	}

	public void setNumberOfStations(int numberOfStations) {
		this.numberOfStations = numberOfStations;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleStation other = (MultipleStation) obj;
		return numberOfStations == other.numberOfStations;
	}

	@Override
	public String toString() {
		return "MultipleStation [numberOfStations=" + numberOfStations + "]";
	}

	@Override
	public String station() {
		return "Station: " + name + " - Latitude: " + latitude+ "- Longitude: "+ longitude+  "- Description: "+description+" - Wheelchair: "+wheelchair;
	}
}
	
	
	
	
	
	
	
	

