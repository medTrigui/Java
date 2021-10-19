package labs.lab5;

public class Train extends Trip {
//Instance variable
	private String[] stops;

//Default constructor
	public Train() {
		super();
		stops = null;	
	}
//Non default constructor
	public Train(double duration, String origin, String destination, String[] stops) {
		super(duration, origin, destination);
		this.stops = stops;
	}

//Getters and Setters 
	public String[] getStops() {
		return stops;
	}

	public void setStops(String[] stops) {
		this.stops = stops;
	}
//equals method
	public boolean equals(Object obj) {
		if (!(obj instanceof Train)) {
			return false;
		}
		
		Train t = (Train)obj;
		if (!super.equals(t)) {
			return false;
		} else if (stops != t.getStops()) {
			return false;
		}
		
		return true;
	}
//to string method
	@Override
	public String toString() {
		return "Train [stops=" + stops + "]";
	}
	
//travel method	
	public String travel() {
		String s = "";
		for (int i=0; i<stops.length; i++) {
			s = s + "," + stops[i];
		}
		return "Train from " + origin + " to " + destination + "-" + this.getDuration() + s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
