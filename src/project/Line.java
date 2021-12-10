/*Mohamed Trigui 12/09/2021
 * Line class represents a line in general:
 * A line has a name and a list of stations
 * The line class holds the methods that have direct access to the list of stations.
 */


package project;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Line {

//Instance variable
	private ArrayList<Station> stations = new ArrayList<Station>();
	private String name;
	Scanner input = new Scanner(System.in);
	
//Constructors
	public Line() {
		super();
		stations.set(0, new UniqueStation());
	}

	public Line(ArrayList<Station> stations , String name) {
		super();
		setStations(stations);
		setName(name);
	}
	
//Getters and setters
	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

//equals method		

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(name, other.name) && Objects.equals(stations, other.stations);
	}
	
	
//toString

	@Override
	public String toString() {
		return "Line [stations=" + stations + ", name=" + name + "]";
	}


//search station
	public Station searchStation(String name) {
		
	for(Station current: stations) {
		if (current.getName().equalsIgnoreCase(name)) {
			System.out.println("Found");
			return current;
		}	
	}
	System.out.println("Not found");
	return null;
}
	

	
//add station (called in the main method of application class if the user wants to add)	
		public void  addStation(Station s) {
		stations.add(s);
		
	}
	
//delete station (called in the main method of application class if the user wants to delete)	
	public void deleteStation(String name) {
		//ArrayList<Station> possible = searchStation(name);
		Station possible = searchStation(name);
		
		if (possible  == null) {
			System.out.println("Station not found");
		} 
		else  {
			stations.remove(possible) ;
			System.out.println("Station "+ possible.getName() +" has been removed. ");
		} 
	
	}
//Modify Station (called in the main method of application class if the user wants to modify)	
	public void modifyStation(String name) {
		//ArrayList<Station> possible = searchStation(name);
		Station possible = searchStation(name);

		
		if (possible == null) {
			System.out.println("Station not found");
		}
		else  {
			boolean done = false;
			
			do {
				System.out.println("1. Modify name: ");
				System.out.println("2. Modify latitue: ");
				System.out.println("3. Modify longitude: ");
				System.out.println("4. Modify description: ");
				System.out.println("5. Modify wheelchair: ");
				System.out.println("6. Exit: ");
				System.out.println();

				String choice = input.nextLine();
				int index = stations.indexOf(possible);
				switch (choice) {
				case "1":
					System.out.println("New name: ");
					stations.get(index).name = input.nextLine();
					break;
				
				case "2" :
					System.out.println("New latitude: ");
					stations.get(index).latitude = Double.parseDouble(input.nextLine());
					break;
					
				case "3" :
					System.out.println("New longitude: ");
					stations.get(index).longitude = Double.parseDouble(input.nextLine());
					break;
					
				case "4" :
					System.out.println("New description: ");
					stations.get(index).description = input.nextLine();
					break;
				
				case "5" : 
					System.out.println("New wheelchair: ");
					stations.get(index).wheelchair = Boolean.parseBoolean(input.nextLine());
					break;	
					
				case "6" :
					done = true;
					break;
					
				default:
					System.out.println("I'm sorry, but I didn't understand that.");
				}
				
			} while (!done);
		}
	}
	
	//print details of the station
	public void printStations() {
		for (int i=0; i<this.stations.size();i++) {
			System.out.println(this.stations.get(i).station());
		}
	}
	
  //search for a station that has a wheel chair:
	
	public ArrayList<Station> searchWheel() {
		ArrayList<Station> stat = new ArrayList<Station>();
		for(Station current: stations) {
			if (current.isWheelchair() == true) {
				stat.add(current);
				System.out.print(current.getName() + " , ");
			}
				
		}
		return stat;
		
	}
	//Distance formula method:
	public static double distance(double lat1 , double lat2, double lon1, double lon2) {
		double distance = Math.sqrt((lat2-lat1)*(lat2-lat1) + (lon2-lon1)*(lon2-lon1));
		return distance;
	}
	
	//search for the nearest station:
	
	public Station searchNear(double lat, double lon) {
		double NearestD = 999999999;
		Station nearest = null;
		for(Station current: stations) {
			double d  = distance(lat, current.getLatitude(), lon, current.getLongitude());
			if (d < NearestD) {
				NearestD = d;
				nearest = current;
			}
		}
		
		return nearest;
	}
	
	//search Station for the generate path:
		public Station searchStationG(String name) {
			for(Station current: stations) {
				if(current.getName().equalsIgnoreCase(name)) {
					return current;
				}
			}
			return null;
		}
}

