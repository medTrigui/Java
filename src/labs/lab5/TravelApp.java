package labs.lab5;

import java.io.File;
import java.util.Scanner;

public class TravelApp {

//main method
	public static void main(String[] args) {
		
		Trip[] Trips = readExistingFile();
		Scanner input = new Scanner(System.in);
		boolean done = false;
		
		do {
		// Menu 
			System.out.println();
			System.out.println("1. Add New Trip");
			System.out.println("2. Take All Trips");
			System.out.println("3. Exit");
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
						
						String[] stops = new String[0];
						boolean done1 = false;
						
						while (!done1) {	
							System.out.println("Enter a stop or done if no stops left: ");
							String text = input.nextLine();
							
							if (text.equalsIgnoreCase("done")) {
								done1 = true;
							} else {
								try {
									String[] temp = new String[stops.length+1];
									for (int i=0; i<stops.length; i++) {
										temp[i] = stops[i];
									}
									stops = temp;
									stops[stops.length-1] = text;
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							}
						}				
			            	Trips = addTrip(Trips, new Train(duration, origin, destination, stops));
					}				
					break;
				case "2":	// 2. Take trips
					Trips = takeTrips(Trips);
					break;
				case "3":	// 3. exit
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
	public static Trip[] readExistingFile() {
		Trip[] Trips = new Trip[0];
		
		try {
			File in = new File("src/labs/lab5/travel.csv");
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
						String[] stops = new String[values.length - 4];
						for (int i=4; i<values.length; i++) {
							stops[i-4] = values[i];
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
	public static Trip[] addTrip(Trip[] trips, Trip t) {
		
		Trip[] temp = new Trip[trips.length + 1];
		for (int i=0; i<trips.length; i++) {
			temp[i] = trips[i];
		}
		trips = temp;
		
		trips[trips.length - 1] = t;
		
		return trips;
		
	}
//take trips method	
	public static Trip[] takeTrips(Trip[] trips) {
		for (int i= 0; i<trips.length; i++) {
			System.out.println(trips[i].travel());	
		}
		trips = new Trip[0];

		return trips;
	}
	
}
	
		
		
		
		
		
		
		
		
		
		
		

