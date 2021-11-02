package labs.lab6;

import java.util.ArrayList;

public class Train extends Trip {
	//Instance variable
		private ArrayList<String> stops= new ArrayList<String>();

	//Default constructor
		public Train() {
			super();
			stops = null;	
		}
	//Non default constructor
		public Train(double duration, String origin, String destination, ArrayList<String> stops) {
			super(duration, origin, destination);
			this.stops = stops;
		}

	//Getters and Setters 
		public ArrayList<String> getStops() {
			return stops;
		}

		public void setStops(ArrayList<String> stops) {
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
			for (int i=0; i<stops.size(); i++) {
				s = s + "," + stops.get(i);
			}
			return "Train from " + origin + " to " + destination + "-" + this.getDuration() + s;
	
		
		}	
}	
		
		
		

