package labs.lab6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelApp {

//main method
	public static void main(String[] args) {
		
		//Trip[] Trips = readExistingFile();
		ArrayList<Trip> Trips = readExistingFile();
		Scanner input = new Scanner(System.in);
		boolean done = false;
		
		do { 
		// Menu 
			System.out.println();
			System.out.println("1. Add New Trip");
			System.out.println("2. Remove Trip");
			System.out.println("3. View trip");
			System.out.println("4. Take All Trip");
			System.out.println("5. Exit:");
			System.out.print("Choice: ");
			String choice = input.nextLine();
			System.out.println();
			switch (choice) {
				case "1":	// 1. Add trip
					System.out.println("What trip do you want to make? ");
					String type = input.nextLine();
					if (type.equalsIgnoreCase("flight")) {
						
						System.out.print("What's your Origin?");
						String origin = input.nextLine();
						System.out.print("What's your destination?");
						String destination = input.nextLine();
						System.out.print("What's your duration? ");
						double duration = Double.parseDouble(input.nextLine());
						System.out.print("Do you want a meal? (true/false) ");
						boolean meal = Boolean.parseBoolean(input.nextLine());
						Trips = addTrip(Trips, new Flight(duration, origin, destination, meal));
					
					} else if (type.equalsIgnoreCase("drive")) {
						
						System.out.print("What's your Origin?");
						String origin = input.nextLine();
						System.out.print("What's your destination?");
						String destination = input.nextLine();
						System.out.print("What's your duration? ");
						double duration = Double.parseDouble(input.nextLine());
						System.out.println("How many gallons of gas do you need? ");
						double gallonsOfGas = Double.parseDouble(input.nextLine());
						Trips = addTrip(Trips, new Drive(duration, origin, destination, gallonsOfGas));
					} else if (type.equalsIgnoreCase("train")) {
						
						System.out.print("What's your Origin?");
						String origin = input.nextLine();
						System.out.print("What's your destination?");
						String destination = input.nextLine();
						System.out.print("What's your duration? ");
						double duration = Double.parseDouble(input.nextLine());
						
						ArrayList<String> stops = new ArrayList<String>();
						boolean done1 = false;
						
						while (!done1) {	
							System.out.println("Enter a stop or done if no stops left: ");
							String text = input.nextLine();
							
							if (text.equalsIgnoreCase("done")) {
								done1 = true;
							} else {
								try {
									/*String[] temp = new String[stops.length+1];
									for (int i=0; i<stops.length; i++) {
										temp[i] = stops[i];
									}
									stops = temp;
									stops[stops.length-1] = text;
									*/
									stops.add(text);
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							}
						}				
			            	Trips = addTrip(Trips, new Train(duration, origin, destination, stops));
					}				
					break;
				case "2":	// 2. Take trips
					Trips = removeTrip(input, Trips);
					break;
				case "3":	
					viewTrip(input, Trips);
					break;
					
				case "4":
					Trips = takeTrips(Trips);
					break;
					
				case "5":
					done = true;
					break;
				default:
					System.out.println("I'm sorry, but I didn't understand that.");
			}
		} while (!done);
		System.out.println("Goodbye!");
		input.close();
	}

//read from file	
	public static ArrayList<Trip> readExistingFile() {
		ArrayList<Trip> Trips = new ArrayList<Trip>();
		
		try {
			File in = new File("src/labs/lab6/travel.csv");
			Scanner input = new Scanner(in);
			
			while (input.hasNextLine()) {
				try {
					String line = input.nextLine();
					Trip t = null;
					String[] values = line.split(",");
					if (values[0].equalsIgnoreCase("Flight")) {
						t = new Flight(Double.parseDouble(values[3]), values[1], values[2], Boolean.parseBoolean(values[4])); 
					} else if (values[0].equalsIgnoreCase("Drive")){
						t = new Drive(Double.parseDouble(values[3]), values[1], values[2], Double.parseDouble(values[4]));
					} else if (values[0].equalsIgnoreCase("Train")) {
						ArrayList<String> stops = new ArrayList<String>();
						for (int i=4; i<values.length; i++) {
							stops.add( values[i]);
							
						}
						
						t = new Train(Double.parseDouble(values[3]), values[1], values[2], stops);					
					
					}
					
					if (t != null) {
						Trips = addTrip(Trips, t);
					}
				} catch(Exception e) {
					System.out.println("Error reading row");
				}
			}
			
			input.close();
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		return Trips;
	}

//add trip method
	public static ArrayList<Trip> addTrip(ArrayList<Trip> trips, Trip t) {		
		trips.add(t);
		
		return trips;

	}
//take trips method	
	public static ArrayList<Trip> takeTrips(ArrayList<Trip> trips) {
		for (int i= 0; i<trips.size(); i++) {
			System.out.println((trips.get(i).travel()));	
		}
		trips = new ArrayList<Trip>();

		return trips;
	}

//search method
	public static ArrayList<Trip> search(Scanner input, ArrayList<Trip> trips) {
		ArrayList<Trip> searchResults = new ArrayList<Trip>();
		
		System.out.print("Trip type: ");
		String type = input.nextLine();
		
		for (Trip current : trips) {
			if (current.getClass().getSimpleName().equalsIgnoreCase(type)) {
			searchResults.add(current); 
			}
				} return searchResults;
	}
//Remove trip method

public static ArrayList<Trip> removeTrip(Scanner input, ArrayList<Trip> trips) {
	
	ArrayList<Trip> possible = search(input, trips);
	
	if (possible.size() == 0) {
		System.out.println("Trip not found.");
	} else if (possible.size() == 1) {
		trips.remove(possible.get(0));
		System.out.println(possible.get(0).travel() + " has been removed.");
	} else {
		for (int i=0; i<possible.size(); i++) {
			System.out.println((i+1)+". "+possible.get(i).details());
		}
		System.out.println((possible.size()+1) + ". Exit");
		System.out.print("Choice: ");
		int index = possible.size() + 1;
		try {
			index = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.print("Not a valid choice. ");
		}
		
		if (index > 0 && index <= possible.size()) {
			trips.remove(possible.get(index-1));
			System.out.println(possible.get(index-1).travel() + " has been removed.");
		} else if (index == (possible.size() + 1)) {
			System.out.println("Returning to main menu.");
		} else {
			System.out.println("Not a valid choice. Returning to main menu.");
		}
	}
	
		return trips;
	}



public static void  viewTrip(Scanner input, ArrayList<Trip> trips) {
	ArrayList<Trip> searchResults = search(input, trips);
	Boolean done = false;
	
	
	
	System.out.println("What's your orgin? ");
	String origin = input.nextLine();
	System.out.println("What's your destination? ");
	String destination = input.nextLine();
	System.out.println("What's your duration? ");
	double duration = Double.parseDouble(input.nextLine());
	
	for (Trip current : searchResults) {
		
		if ((origin.equalsIgnoreCase(current.getOrigin()) ) && (destination.equalsIgnoreCase(current.getDestination())) && (duration == current.getDuration())) {
			System.out.println(current.details());
			done = true;
		}	
	} 
	if (!done) {
		System.out.println("Trip not found!");
	}
}

}
























