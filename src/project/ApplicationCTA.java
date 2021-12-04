package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationCTA {

	public static void main(String[] args) {
		
		
		/*boolean done = false;
		Line red = new Line();
		Line purple = new Line ();
		Line brown = new Line();
		Line blue = new Line();
		Line green = new Line();
		Line pink = new Line();
		Line orange = new Line();*/
		
		
		//ArrayList<Station> Stations = readExistingFile();
		Scanner input = new Scanner(System.in);
		
		ArrayList<Line> lines = new ArrayList<>();
		ArrayList<Station> sts = new ArrayList<>();
		
		
		lines.add(new Line(sts, "red"));
		lines.add(new Line(sts, "purple"));
		lines.add(new Line(sts, "brown"));
		lines.add(new Line(sts, "blue"));
		lines.add(new Line(sts, "green"));
		lines.add(new Line(sts, "pink"));
		lines.add(new Line(sts, "orange"));
		
		/*for(int i=0 ;i<lines.size(); i++) {
			System.out.println(lines.get(i));
		}*/
	
	/*	blue.addStation(new UniqueStation("p",42.0,43, "elevated", true, 2));
		blue.printStations();
		
		blue.modifyStation("p");
		blue.printStations();*/
		
		boolean done = false;
		 
		do {
			System.out.println();
			System.out.println("1. Create a new station: ");
			System.out.println("2. Modify station: ");
			System.out.println("3. Remove station: ");
			System.out.println("4. Search for a station by name: ");
			System.out.println("5. Search for a station by requirements: ");
			System.out.println("6. Find station: ");
			System.out.println("7. Generate path between two stations: ");
			System.out.println("8. Exit:");
			
			String choice = input.nextLine();
			System.out.println();
			switch (choice) {
			case "1" : // Create new station
				System.out.println("Line to add a station on:  ");
				String line = input.nextLine();
				
				System.out.println("Type of station:(UniqueStation/ MultipleStation): ");
				String type = input.nextLine();
				
				System.out.println("Name of the station: ");
				String name = input.nextLine();
				
				System.out.println("Latitude of the station: ");
				double latitude = Double.parseDouble(input.nextLine());
				
				System.out.println("Longitude of the station: ");
				double longitude = Double.parseDouble(input.nextLine());
				
				System.out.println("Description of the station: ");
				String description = input.nextLine();
				
				System.out.println("Wheelchair (true/false): ");
				boolean wheelchair = Boolean.parseBoolean(input.nextLine());
				
				int	numberOfLines = 0;
				int numberOfStations = 0;
				
				if (type.equalsIgnoreCase("UniqueStation")) {
					System.out.println("Number of lines that share this station: ");
					numberOfLines = Integer.parseInt(input.nextLine());
				}
				else if (type.equalsIgnoreCase("MultipleStation")) {
					System.out.println("Number of stations that share this name: ");
					numberOfStations = Integer.parseInt(input.nextLine());
				}
				
				for(int i=0; i<lines.size(); i++) {
					if (line.equalsIgnoreCase(lines.get(i).getName())) {
						if(type.equalsIgnoreCase("UniqueStation")) {
							lines.get(i).addStation(new UniqueStation(name,latitude,longitude,description,wheelchair, numberOfLines));
						} else
							 if (type.equalsIgnoreCase("MultipleStation")) {
								 lines.get(i).addStation(new MultipleStation(name, latitude,longitude,description, wheelchair, numberOfStations));
							 }
					}
				
				}
				break;
			case "2" : //Modify Station:
				System.out.println("Line to modify a station on:  ");
				String line1 = input.nextLine();
				
				System.out.println("Name of the station: ");
				String name1 = input.nextLine();
				
				for(int i=0; i<lines.size(); i++) {
					if (line1.equalsIgnoreCase(lines.get(i).getName())) {
						lines.get(i).modifyStation(name1);
					}
				}
				break;
				
			case "3" : //Remove station: 
				System.out.println("Line to remove station from: ");
				String line2 = input.nextLine();
				
				System.out.println("Name of the station: ");
				String name2 = input.nextLine();
				
				for(int i=0; i<lines.size(); i++) {
					if (line2.equalsIgnoreCase(lines.get(i).getName())) {
						lines.get(i).deleteStation(name2);
					}
				}
			
				
			//case.....	
			}
			
		} while  (!done);
		System.out.println("Goodbye!");
		input.close();	
	}	
	
			
//Method that reads from the file:
	
	public static ArrayList<Station> readExistingFile(ArrayList<Line> lines) {
	 ArrayList<Station> Stations = new ArrayList<Station>();
	 
	 try {
		 
		 File in = new File("src/project/CTAStops.csv");
		 Scanner input = new Scanner(in);
		 while (input.hasNextLine()) {
			 try {
				 String line = input.nextLine();
				 
				 String[] values = line.split(",");
				
				Station s = new UniqueStation(values[0], Double.parseDouble(values[1]) , Double.parseDouble(values[2]), values[3], Boolean.parseBoolean(values[4]), 1 );
				
				
				/*for(int i=0 ; i<values.length; i++) {
					System.out.print(values[i]);
					System.out.println();
				}*/
				 
				 
				 for(int i = 5; i<=11 ; i++) {
					 if(values[i] != "-1") {
						 if (i==5) {
							lines.get(0).addStation(s) ;
						 }
						 if (i==6) {
							 lines.get(4).addStation(s);
						 }
						 if (i==7) {
							 lines.get(3).addStation(s);
						 }
						 if (i==8) {
							 lines.get(2).addStation(s);
						 }
						 if (i==9) {
							 lines.get(1).addStation(s);
						 }
						 if (i==10) {
							 lines.get(5).addStation(s);
						 }
						 if (i==11) {
							 lines.get(6).addStation(s);
						 }
					 }
				 }
				 
				 for(int i=0; i<lines.size(); i++) {
					 System.out.println(lines.get(i));
				 }
				 
			 } catch(Exception e) {
				 System.out.println("Error reading row.");
			 }
		 }
			 
	 } catch (Exception e) {
		 System.out.println("Error reading file. ");
	 }
 
		return Stations;
	}

}
