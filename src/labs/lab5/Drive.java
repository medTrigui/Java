package labs.lab5;

public class Drive extends Trip {
//Instance variable
	private double gallonsOfGas;

//Default constructor
	public Drive() {
		super();
		gallonsOfGas = 0;
	}
//Non default constructor

	public Drive(double duration, String origin, String destination, double gallonsOfGas) {
		super(duration, origin, destination);
		this.gallonsOfGas = gallonsOfGas;
	}
//Getters and setters

	public double getGallonsOfGas() {
		return gallonsOfGas;
	}

	public void setGallonsOfGas(double gallonsOfGas) {
		if (gallonsOfGas > 0) {
		this.gallonsOfGas = gallonsOfGas;
		}
	}
//to string method
	@Override
	public String toString() {
		return "Drive [gallonsOfGas=" + gallonsOfGas + "]";
	}
//equals method	
	public boolean equals(Object obj) {
		if (!(obj instanceof Drive)) {
			return false;
		}
		
		Drive d = (Drive)obj;
		if (!super.equals(d)) {
			return false;
		} else if (gallonsOfGas != d.getGallonsOfGas()) {
			return false;
		}
		
		return true;
	}
//travel method	
	public String travel() {
		return "Road trip from " + origin + " to " + destination + "-" + this.getDuration();
	}
	
}
