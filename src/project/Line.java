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

//add station
	public void  addStation(Station s) {
		
	if (stations.size()==0) {
		stations.add(s);
	}
		
		
	else {
		for (int i=0; i<stations.size(); i++) {
			
			if ((stations.get(i-1).latitude < s.latitude) && (stations.get(i+1).latitude > s.latitude) && (stations.get(i-1).longitude < s.longitude) && (stations.get(i+1).longitude> s.longitude)) {
				stations.add(i , s);
				System.out.println("Station"+ s + "has been added.");
			}
			else if ((stations.get(0).latitude > s.latitude) && (stations.get(0).longitude> s.longitude)) {
				stations.add(0, s);
			}
			else if((stations.get(stations.size()).latitude < s.latitude) && (stations.get(stations.size()).longitude < s.longitude))  {
				stations.add(stations.size(), s);
			}
				//break;
		}
	}
}

//search station
	public ArrayList<Station> searchStation( String name) {
	ArrayList<Station> searchResults = new ArrayList<Station>();
		
	for(Station current: stations) {
		if (current.getName().equalsIgnoreCase(name)) {
			searchResults.add(current);
		}
	}
	return searchResults;
	}
	

//delete station
	public void deleteStation(String name) {
		ArrayList<Station> possible = searchStation(name);
		
		if (possible.size() == 0) {
			System.out.println("Station not found");
		} 
		else if (possible.size() == 1) {
			stations.remove(possible.get(0)) ;
		} 
	
	}
//Modify Station	
	public void modifyStation(String name) {
		ArrayList<Station> possible = searchStation(name);
		
		if (possible.size() == 0) {
			System.out.println("Station not found");
		}
		else if (possible.size() == 1) {
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
				int index = stations.indexOf(possible.get(0));
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
		input.close();
	}
	
	//print for the testing
	public void printStations() {
		for (int i=0; i<stations.size();i++) {
			System.out.println(stations.get(i));
		}
	}
	
	
	
	
	
	
	
}
