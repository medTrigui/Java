package labs.lab5;

//abstract class: Trip
public abstract class Trip {

//Instance variables
	private double duration;
	protected String origin;
	protected String destination;

//Default constructor
	public Trip() {
	this.duration = 0.0;
	this.origin = "North Pole";
	this.destination = "South Pole";
	}

//Non default constructor 
	public Trip(double duration, String origin, String destination) {
		this.duration = duration;
		this.origin = origin;
		this.destination = destination;
	}

//getters and setters	
	public double getDuration() {
		return duration;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDuration(double duration) {
		if (duration > 0.0) {
		this.duration = duration;
		}
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

//equals method
	public boolean equals(Object obj) {
		if (!(obj instanceof Trip)) {
			return false;
		}
		Trip t = (Trip)obj;
		if (duration!= t.getDuration()) {
			return false;
		} else if (!origin.equals(t.getOrigin())) {
			return false;
		} else if (!destination.equals(t.getDestination())) {
			return false;
		}
		
		
		return true;
	}
//to string method
	@Override
	public String toString() {
		return "Trip [duration=" + duration + ", origin=" + origin + ", destination=" + destination + "]";
	}
	
	public abstract String travel();
	
	
	
	
	
	
	
}
