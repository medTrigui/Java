package labs.lab5;

public class Flight extends Trip {
//Instance variable
	private boolean meals;

//Default constructor
	public Flight() {
		super();
		meals = false;
	}
	
//Non default constructor
	public Flight(double duration, String origin, String destination, boolean meals) {
		super(duration, origin, destination);
		this.meals = meals;
	}
//Getters and setters
	public boolean hasMeals() {
		return meals;
	}

	public void setMeals(boolean meals) {
		this.meals = meals;
	}
//to string method
	@Override
	public String toString() {
		return "Flight [meals=" + meals + "]";
	}
//equals method	
	public boolean equals(Object obj) {
		if (!(obj instanceof Flight)) {
			return false;
		}
		
		Flight f = (Flight)obj;
		if (!super.equals(f)) {
			return false;
		} else if (meals != f.hasMeals()) {
			return false;
		}
		
		return true;
	}
	
//travel method	
	public String travel() {
		return "Flight from " + origin + " to " + destination + " - " + this.getDuration();
	}
	
	
	
	
	
	
}
