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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
