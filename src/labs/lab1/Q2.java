package labs.lab1;
//Mohamed Trigui CS201-01

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {

	   //creating a new scanner
		Scanner input = new Scanner(System.in);	
       //Your age subtracted from your father's age	
       //Asking for my age,input my age 
		System.out.println("Enter your age:");
	    int x = Integer.parseInt(input.nextLine());
	    
	   //Asking for father's age, input father's age
	    System.out.println("Enter father's age");
        int y = Integer.parseInt(input.nextLine());
       // subtracting my age from father's age
        
        System.out.println("difference is " + (y-x));
        
       //Your birth year multiplied by 2
         
       //Asking for birth year, input birth year,printing it out
        System.out.println("Enter your birth year");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Result is "	+ year*2);
        
   //Convert your height in inches to centimeters 
        
        //Asking for height in inches, input height in inches,printing it out in centimeters
        System.out.println("Enter your height in inches");
        double height1 = Double.parseDouble(input.nextLine());
        System.out.println("your height in centimeters is "+ height1*2.54);
       
    //Convert your height in inches to feet and inches where inches is an integer (mode operator)
        
        System.out.println("your height is "+ (int)height1/12 +"ft and " + (int)height1 % 12 + "inches");
		
		
		

	}

}
