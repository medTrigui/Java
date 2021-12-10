/*Mohamed Trigui 12/09/2021
 * Application class contains the main method which has all the instances of the actual lines, and the menu.
 * Application class contains all methods (add, remove, and modify are here as well but they are being called from line class)
 */


package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationCTA {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Line> lines = new ArrayList<>();
		
		lines.add(new Line(new ArrayList<>(), "red"));
		lines.add(new Line(new ArrayList<>(), "purple"));
		lines.add(new Line(new ArrayList<>(), "brown"));
		lines.add(new Line(new ArrayList<>(), "blue"));
		lines.add(new Line(new ArrayList<>(), "green"));
		lines.add(new Line(new ArrayList<>(), "pink"));
		lines.add(new Line(new ArrayList<>(), "orange"));
		
		lines = readExistingFile(lines);
	
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
				String line = verifLine(input);
				
				System.out.println("Type of station:(UniqueStation/ MultipleStation): ");
				String type = input.nextLine();
				
				System.out.println("Name of the station: ");
				String name = input.nextLine();
				
				System.out.println("Latitude of the station: ");
				double latitude = verifDouble(input);
				
				
				System.out.println("Longitude of the station: ");
				double longitude = verifDouble(input);
				
				
				System.out.println("Description of the station: ");
				String description = input.nextLine();
				
				System.out.println("Wheelchair (true/false): ");
				boolean wheelchair = verifBoolean(input);
				
				
				int	numberOfLines = 0;
				int numberOfStations = 0;
				
				if (type.equalsIgnoreCase("UniqueStation")) {
					System.out.println("Number of lines that share this station: ");
					numberOfLines = verifInt(input);
					
				}
				else if (type.equalsIgnoreCase("MultipleStation")) {
					System.out.println("Number of stations that share this name: ");
					numberOfStations = verifInt(input);
					
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
				String line1 = verifLine(input);
				
				System.out.println("Name of the station: ");
				String name1 = input.nextLine();
				
				for(int i=0; i<lines.size(); i++) {
					if (line1.equalsIgnoreCase(lines.get(i).getName())) {
						lines.get(i).modifyStation(name1);
						System.out.println("Station has been modified. " );
					}
				}
				break;
				
			case "3" : //Remove station: 
				System.out.println("Line to remove station from: ");
				String line2 = verifLine(input);
				
				System.out.println("Name of the station: ");
				String name2 = input.nextLine();
				
				for(int i=0; i<lines.size(); i++) {
					if (line2.equalsIgnoreCase(lines.get(i).getName())) {
						lines.get(i).deleteStation(name2);
						System.out.println("Station has been removed.");
					} 
				}
			    break;
			case "4": //Search station by name:
				System.out.println("Name of the station: ");
				String stat = input.nextLine();
				searchName(lines, stat);
				break;
				
			case "5": //search by requirement:  (add an additional feature or two for extra points)
				
				System.out.println("Options:" );
				System.out.println("1. Search for stations that have wheelchair access: ");
				System.out.println("2. Search for stations on a specific line: ");
				int choix = Integer.parseInt(input.nextLine());
				if (choix == 1) {
					for (int i=0; i< lines.size(); i++) {
						lines.get(i).searchWheel();  
					}
				} else if (choix == 2) {
					System.out.println("Line: ");
					String lineName = verifLine(input);
					for(int i = 0; i<lines.size(); i++) {
						if(lineName.equalsIgnoreCase(lines.get(i).getName())) {
						lines.get(i).printStations();
						}
					}
				} else {
					System.out.println("I did not understand that. ");
				}
				break;
			case "6": 
				FindStation(lines, input);
				break;
			case "7":
				generatePath(lines, input);
				break;
			case "8":
				done = true;
				break;
			default:
				System.out.println("I'm sorry, but I didn't understand that.");
			}
			
		} while  (!done);
		System.out.println("Goodbye!");
		input.close();	
	}	
	
			
//Method that reads from the file:
	
	public static ArrayList<Line> readExistingFile(ArrayList<Line> lines) {
	 try {
		 
		 File in = new File("src/project/CTAStops.csv");
		 Scanner input2 = new Scanner(in); // rename scanner
	
		 while (input2.hasNextLine()) { 
			 try {
				 String line = input2.nextLine();
				 String[] values = line.split(",");
				
				 
				if(values[0].compareTo("Name") != 0) {
					//System.out.println(values[0]);
					Station s = new UniqueStation(values[0], Double.parseDouble(values[1]) , Double.parseDouble(values[2]), values[3], Boolean.parseBoolean(values[4]), 1 );
				
					 for(int i = 5; i<=11 ; i++) {
						
						 if(values[i].compareTo("-1") != 0) {
							 if (i==5) {
								lines.get(0).addStation(s);
								//Added to the red line
								
							 }
							 if (i==6) {
								 lines.get(4).addStation(s);
								 //Added to the green line
							 }
							 if (i==7) {
								 lines.get(3).addStation(s);
								 //Added to the blue line
							 }
							 if (i==8) {
								 lines.get(2).addStation(s);
								 //Added to the brown line
							 }
							 if (i==9) {
								 lines.get(1).addStation(s);
								 //Added to the purple line
							 }
							 if (i==10) {
								 lines.get(5).addStation(s);
								//Added to the pink line
							 }
							 if (i==11) {
								 lines.get(6).addStation(s);
								 //Added to the orange
							 }
						 }
					 
					 }
				}else {
				}
				 
			  } catch(Exception e) {
				  System.out.println(e);
				 System.out.println("Error reading row.");
			 }
			
		 }
		 	input2.close();
		
	 } catch (FileNotFoundException e) {
		 System.out.println("Error reading file. ");
	 }
		return lines;
		
	}
		
	/*Method that searches for a station by Name:
	 * It loops through the array list of lines and returns (after calling the general search station from the line class):
	 * found if the station is found.
	 * Not found if the station is not found 
	 */
	public static void searchName(ArrayList<Line> lines, String name) {
		
		for (int i=0; i<lines.size(); i++) {

			System.out.println(lines.get(i).getName()+ ":");
			Station found = lines.get(i).searchStation(name);
			if (found == null) {
				System.out.println();
			} else {
			System.out.println(found.getName());
			System.out.println();
			}
		}
		
	}
	//Find nearest station method:
	public static void FindStation(ArrayList<Line> lines, Scanner input) {
		
		System.out.println("Enter your current latitude: ");
		double lat = verifDouble(input);
		
		System.out.println("Enter your current longitude: ");
		double lon = verifDouble(input);
		
		String nearLine = null;
		double Dist = 999999999;
		Station nearStation = null;
		
		for (int i = 0; i<lines.size(); i++) {
			Station found = lines.get(i).searchNear(lat, lon);
			
			double tempDist = Line.distance(lat,found.getLatitude(), lon, found.getLongitude());
			if (tempDist < Dist) {
				nearStation = found;
				Dist = tempDist;
				nearLine = lines.get(i).getName();
			}
		}
		System.out.println("The nearest station is found on "+ nearLine +": "+ nearStation.getName());
	}
	
//this method is being called by the actual generate path method. It verifies the existence of stations and returns the line color of the station entered
	public static String prepareGenerate(ArrayList<Line> lines, Scanner input, String name) {
	
	ArrayList<Station> stations = new ArrayList<Station>();
	ArrayList<String> line = new ArrayList<String>();
	
	String theLine = null;
	
	
	int counter= 0;
	for(int i=0; i<lines.size();i++) {
		Station found = lines.get(i).searchStationG(name);
		if(found != null) {
			counter++;
			stations.add(found);
			line.add(lines.get(i).getName());
			//System.out.println(found.getName()+ " on the "+lines.get(i).getName()+ " line");
		} 
	}
	if(counter == 0) {
		System.out.println("Station not found!");
		return null;
	}
	
	if(stations.size() > 1 ) {
		for(int i =0; i<stations.size(); i++) {
		String phrase = (i+1)+". " + stations.get(i).getName() + " at " + line.get(i) + " line";
		System.out.println(phrase);
		}
		Integer choice = Integer.parseInt(input.nextLine());
		for(int i=0; i<line.size(); i++) {
			if ((choice-1) == i) {
				theLine = line.get(i);
			}
		}
	} else {
		theLine = line.get(0);
	} 
	return theLine;
	
}
	
//Generate path method compares the line color of the stations entered and returns a simple message if the color is the same
//or a message with an appropriate transfer station if the color is not the same.	 
	public static void generatePath(ArrayList<Line> lines , Scanner input) {
		
		ArrayList<Station> transfers = new ArrayList<Station>();
		System.out.print("Departure: ");
		System.out.print("Station name: ");
		String name1 = input.nextLine();
		String fromLine = prepareGenerate(lines,input,name1);
		if (fromLine == null) {
			
		}
		System.out.println();
		
		
		System.out.print("Destination: ");
		System.out.print("Station name: ");
		String name2 = input.nextLine();
		String toLine = prepareGenerate(lines,input, name2);
		System.out.println();
		
		if ((fromLine ==null) || (toLine ==null)) {
			System.out.println("Station was not found so path cannot be generated.");
			System.out.println("Returning to the main menu...");
		}
		
		else if( fromLine.equalsIgnoreCase(toLine)) {
			String out1 = "To go from " + name1+ " to " + name2 +" take the " + toLine + " line";
			System.out.println(out1);
			
			System.out.println("Do you want to save the path to file? ");
			String answer = input.nextLine();
			if (answer.equalsIgnoreCase("yes")) {
				fileWriter(out1, input);
			} else {
				
			}
			
			
		} else {
			//find all transfers:
			//loop through all stations in the departure line
				//loop through all the stations in the destination line
					//if a station is equal then store it
		
			Line fl = null; 
			for (int i=0; i<lines.size(); i++) {
				if (lines.get(i).getName().equalsIgnoreCase(fromLine)) {
					 fl = lines.get(i);
				}
			}
			
			Line tl = null;
			for (int i=0; i<lines.size(); i++) {
				if (lines.get(i).getName().equalsIgnoreCase(toLine)) {
					 tl = lines.get(i);
				}
			} 
			
			for (int i=0; i< fl.getStations().size(); i++) {
				
				for(int j=0; j<tl.getStations().size(); j++) {
					
					if (fl.getStations().get(i).equals(tl.getStations().get(j))) {
						
						Station transfer = fl.getStations().get(i);
						transfers.add(transfer);
					}
				}
			}
			String out2 = "To go from "+ name1 + " to " + name2 + ", take the " + fromLine + " line and transfer at " + transfers.get(0).getName()+ " to the " + toLine + " line";
			System.out.println(out2);
			System.out.println();
			
			System.out.println("Do you want to save the path to a file? ");
			String answer = input.nextLine();
			if (answer.equalsIgnoreCase("yes")) {
				fileWriter(out2, input);
			} else {
				
			}
		}
	}
	//filewriter method writes to a file after prompting the user for a name. It is called by the generate path to save the path if the user desires to do so.
	public static void fileWriter(String out, Scanner input) {
		try 
		{	
			//prompting the user for a file name 
			System.out.println("Enter your file's name: ");
			String name = input.nextLine();
			FileWriter file = new FileWriter("src/project/"+name);
			
			//Saving path to the file
			
				file.write( out + " \n");
				
			file.flush();
			file.close();
		}
		catch(IOException e) {
		System.out.println("Error writing to file.");
		}
}	
//verifInt checks whether input is an integer and keeps prompting if it is not	
	public static int verifInt(Scanner input) {
		boolean good = false;
		while (!good) {
		try {
			System.out.println("Enter an integer:  ");
		  int x = Integer.parseInt(input.nextLine());
		  good = true;	
		  return x;
		  
		} catch (NumberFormatException e){
			System.out.println("Input has to be an integer");
		}
			
		}
		return -1;
	}
	
//verifDouble checks whether input is a double and keeps prompting if it is not
	public static double verifDouble(Scanner input) {
		boolean good = false;
		while(!good) {
		try {
			System.out.println("Enter a double: ");
			double x = Double.parseDouble(input.nextLine());
			good = true;
		  return x;
		} catch (NumberFormatException e){
			System.out.println("Input has to be a double");
		 	}
		}
		return -1;
		
	}

	//verifBoolean checks whether input is 'true' or 'false' and keeps prompting if it is not	
	public static boolean verifBoolean(Scanner input) {
		
		boolean good = false;
		while(!good) {
			
			
				System.out.println("Enter'true' or 'false'");
				String boo = input.nextLine();
				if(boo.equalsIgnoreCase("true")) {
				good = true;
				return true;
			} else if(boo.equalsIgnoreCase("false")) {
				good = true;
				return false;
			} else {
				good = false;
			}
			
		}
		return false;
	}
	
//verifLine checks whether the line is valid and keeps prompting if it's not
	public static String verifLine(Scanner input) {
		
			boolean good = false;
			while(!good) {
				System.out.println("Enter a line: ");
				String x = input.nextLine();
				String str = "red green blue brown purple pink orange";
				boolean verif = str.contains(x.toLowerCase());
				
				if(verif == true) {
					return x;
				} else {
					System.out.println("The line must be accurate");
				}
			}
			return null;
		
	}

}
