/*Mohamed Trigui 12/09/2021
 * UniqueStation  is a sub class that represents a unique station: A station that is unique i.e, there is only one latitude and one longitude of that station
 * UniqueStation inherits from the Station abstract class and has a specific variable which is the number of lines that share that station
 */

package project;

public class UniqueStation extends Station {

	//Instance variable
			private int numberOfLines;

	//Default constructor: 
			public UniqueStation() {
				super();
				numberOfLines = 1;
			}
	//Non default constructor
			public UniqueStation(String name, double latitude, double longitude, String description, boolean wheelchair, int numberOfLines ) {
				super(name, latitude, longitude, description, wheelchair);
				this.numberOfLines = numberOfLines;
			}
			
	//Getters and setters		
			public int getNumberOfLines() {
				return numberOfLines;
			}
			public void setNumberOfLines(int numberOfLines) {
				this.numberOfLines = numberOfLines;
			}
	//equals method		
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!super.equals(obj))
					return false;
				if (getClass() != obj.getClass())
					return false;
				UniqueStation other = (UniqueStation) obj;
				return numberOfLines == other.numberOfLines;
			}
	//To string
			@Override
			public String toString() {
				return this.name + " UniqueStation [numberOfLines=" + numberOfLines + "]";
			}
	
	//@override specific
			@Override
			public String station() {
				return "Station: " + name + " - Latitude: " + latitude+ "- Longitude: "+ longitude+" - Description: "+description+" - Wheelchair: "+wheelchair;
			}
	
	
	
	
	
	
	
	
}
