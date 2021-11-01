# Final Project

## Background

For the past few weeks, we have been learning about objects, inheritance, polymorphism, and lists and using them to model various systems. For this project, you will use these concepts to design and implement a program that models a simplified version of the CTA and allows users to create/remove stations, search for a station by name and by requirements, and navigate between stations.

**Note**: You are welcome to discuss the final project with other students, but the work you submit must be your own and may not use code written by others. This is an individual project, not a group project.

## The Problem

You must create a program that models the CTA and allows users to interact with the data it contains. How the system is designed is entirely up to you, but it must meet the following requirements.

### User Interface Requirements

1. Your program must allow a user to create a new station that is then added to the CTA.
2. Your program must allow a user to modify an existing station on the CTA.
3. Your program must allow a user to remove a station from the CTA.
4. Your program must allow a user to search for a station within the CTA when given a name supplied the user. This search should be able to return multiple stations if more than one has the same name.
5. Your program must allow a user to search for a station within the CTA when given requirements for the station; requirements such as that it have wheelchair access or be on certain lines. (*NOTE*: You are welcome to come up with additional features to search based on.)
6. Your program must be able to find the nearest station within the CTA when given a latitude and longitude by the user.
7. Your program must be able to generate a path between two stations, specified by the user (identified by their names). This means that your program may need to ask the user to clarify which station they mean when given a name that is shared by multiple stations. Your program should also be able to handle the situation where the stations are not on the same line and be able to indicate to the user where to switch from one line to another.
8. Your program should be able to exit when the user requests to finish.

The user should be continually prompted to choose between the above options and can exit the menu with the appropriate choice. The verification of each operation should be visible in the console. You may of course add additional menu options beyond the 8 specified here.

### Programming Requirements

- You should have at least 1 inheritance relationship.
- You should have at least 1 association relationship where the 'outer' class definition has an instance of another user-defined class.
- You should be able to have at least 1 over-ridden method that is **NOT** a usual instance method and **is unique** to your application (i.e. not `toString` or `equals`).
- You should be able to write data to the console _and_ write data to an output file when requested by the user. For example, the user may wish to 'save' their transit path.
- You should read and store an input file of data.
- Your data should be stored in an encapsulated list.
- You should be able to add, delete, modify, and search the data.
- Your user interface should be error-proof. (Your code should never quit with an error message!)

### Design Issues

- The entire project should be one package for ease of use. Specifically, it should be in the `project` package in your repository.
- Each class should be in a separate file named with unique names.
- Each class should have all usual instance methods, i.e. mutators, accessors, constructors, `toString`, and `equals`.
- Each class should **ONLY** have the necessary data members and the methods that manipulate these data members.
- Each method should have a specific task **NOT** multiple tasks.
- Use the object-oriented language features to make your code more efficient (inheritance, association).
- You should have **MINIMAL** code in your main method and use additional methods in the application class to make the code easier to read.
- You should **NOT** have large blocks of code. In this case, "large blocks" would be anything over 100 lines for a single method.

### Implementation Issues

- Use descriptive names for all variables and methods
- Use appropriate programming conventions, i.e. correct naming and capitalization
- Use methods to break up large pieces of code into smaller, single focused tasks
- No data handling in main method. Your file operations should be handled by other methods
- Your file I/O needs to implement try/catches

### Documentation

- Each class should have documentation at the top describing the role of that class in the project, the author's name (you), and the date.
- All identifiers should be commented
- Each method should have a brief (1 or 2 sentence) description of its tasks

### Data Description

A simplified map of the CTA has been provided in `CTAStops.csv`. While the actual map of the CTA (available [here](https://www.transitchicago.com/maps/system/)) will absolutely be useful for you to use, there are a few key differences that should make things easier to work with:

- The Yellow line has been removed. This allows you to avoid a situation where a path between stations requires more than a single transfer.
- There is only one Green line route. The avoids having to handle both the Cottage Grove and 63rd/Ashland paths.
- You do not need to worry about handling the single direction-ness of lines in the loop. This means that each line can be treated as a linear set of stations that can be traversed in both directions.

#### Specific Column Descriptions

There are 12 columns in the CSV file. They are named in the first line of the file (which should not be taken as a station itself). Here are some brief descriptions of what each column is:

- Name - The name of the station (String)
- Latitude - The latitude for the station (double)
- Longitude - the longitude for the station (double)
- Description - A description of the station, e.g. a subway stop or an elevated stop (String)
- Wheelchair - Whether the station has wheelchair access or not (boolean)
- {name:size} - All of the remaining columns are for the individual lines. The column header includes the name (color) of the line and the number of stations on it. The content for each station is a number. If the number is -1, then that station is not on that line. If the number is a non-negative number (0 or more), then that is the position of that station on that line. For example, Roosevelt has the following values `23,18,-1,-1,-1,-1,7`. This means that Roosevelt is at position 23 on the Red line, position 18 on the Green line, position 7 on the Orange line, and it is not on the Blue, Brown, Purple, or Pink lines.

## Phase I: Project Design

### 11/15/2021

1. Describe the user interface. What are the menu options and how will the user use the application?
2. Describe the programmers' tasks:

    - Describe how you will read the input file.
    - Describe how you will process the data from the input file.
    - Describe how you will store the data (what objects will you store?)
    - How will you add/delete/modify data?
    - How will you search the data?
    - List the classes you will need to implement your application.

3. Draw a UML diagram that shows all classes in the program and their relationships. This can be done however you want. If you want a specific application, [StarUML](http://staruml.io/download) and [Draw.io](https://draw.io) are both good. But you are welcome to use any graphics program or just draw them by hand and scan them.
4. Think how you will determine if your code functions are expected. Develop a test plan based on the above description; how will you test that the expected outputs have been achieved for every menu option? **Be sure this test plan is complete.** Your test plan should minimally test each option in the menu-driven user interface for expected behavior as well as error-handling. Your test plan should be in a spreadsheet format (preferably Excel, CSV, or TSV).

**NOTE**: You can use any format to write your design, but it must be in your repository in the project folder by the due date to be graded. This means it can not be a link to a Google Doc.

## Phase II: Project Implementation and Testing

### 12/10/2021

**Step 1**: Implement all of the classes for your program as well as the application class. Be sure to document your code. Each class should have the your name, date, and a description of the class in comments at the top of the file. **NOTE**: Your final program does not need to be identical to the design you submitted. Your design should be a guide to how you implement your solution, not a strick set of requirements.

**Step 2**: Test each of the classes according to your proposed test plan. Be sure to work with small pieces of the whole before trying to put the entire project together. Nothing is more discouraging than a large project with numerous errors that compound one another to the point where it is impossible to know where to begin the debugging process.

**Step 3**: Test your application. Run through your application to see if everything works as expected.

**Step 4**: Carefully check your results with the expected results and debug the project if any errors do come up.

**Step 5**: Before submission, ask a few friends or family members to test your application to see if your user interface is user-friendly and 'unbreakable'. Correct any problems you identify.

**NOTE**: You *must* submit a project design in order for your code to be graded. Even if the design is so late that it is no longer eligible for points, it still must be submitted.
