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
				return "UniqueStation [numberOfLines=" + numberOfLines + "]";
			}
			
			
	
	//@override specific
			@Override
			public String station() {
				// TODO Auto-generated method stub
				return null;
			}
	
	
	
	
	
	
	
	
}
