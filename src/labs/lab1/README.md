# Lab 1 - Selection

## 09/13/2021

## Objectives

1. Learn to prompt for input
2. Learn to use Java data types
3. Learn to declare a constant
4. Learn to use explicit casting
5. Observe the limitations of Java numeric data types

## Exercises

1. _Reading input and writing output:_ Writing a Java program that will prompt a user for a name; save the input and echo the name to the console.
2. _Performing arithmetic calculations:_ Output the result of the following calculations; be sure to write a descriptive comment for each output so the reader knows what is being calculated:

  - Your age subtracted from your father's age
  - Your birth year multiplied by 2
  - Convert your height in inches to cms
  - Convert your height in inches to feet and inches where inches is an integer (mode operator)

3. _Getting a char from keyboard input:_ Prompt a user for a first name; display the user's first initial to the screen. (Hint: Use the String method charAt(0)).
4. Write a program that will do the following:

  - Prompt the user for a temperature in Fahrenheit, convert the Fahrenheit to Celsius and display the result.
  - Prompt the user for a temperature in Celsius, convert the Celsius to Fahrenheit and display the result.
  - Test your program with various temperatures: low, high, middle. Use a test table with as many rows as needed to test your program. Are you satisfied that your program works as expected? Submit your test plan and its results.

5. Write a program that will do the following:

  - Prompt the user for the length, width, and depth in inches of a box.
  - Calculate the amount of wood (square feet) needed to make the box.
  - Display the result to the screen with a descriptive message.
  - Test your program with various inputs. Use a test table like above with as many rows as needed to test your program.

6. Write a program that will convert inches to centimeters:

  - Prompt the user for inches.
  - Convert inches to centimeters
  - Display the result to the console.
  - Test your program with various inputs. Use a test table like above with as many rows as needed to test your program.

## Helpful Hints

To prompt, store input, and write output to screen (console):

```java
Scanner in = new Scanner(System.in); //declare a Scanner object that will read from the keyboard
int numPennies;                      //declare a variable that will store the data from the keyboard
System.out.println("Enter a number of pennies:");//prompt user for a numbrer of pennies
numPennies = in.nextInt();
System.out.println("You have " + numPennies + " pennies"); //output info to the screen
```
