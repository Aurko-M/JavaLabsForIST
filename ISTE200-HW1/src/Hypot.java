/**	This program will compute the hypotenuse of a right triangle
*	using the Pythagorean theorem: 
*	(a*a) + (b*b) = (c*c)
*	where a, b are the two shorter sides of the triangle and c is 
*	the longest side.
*
*	@usage: java Hypot
*	@author: Aurko Mallik
*	
*/

// Import Scanner class
import java.util.Scanner;

public class Hypot {
   public static void main(String [] args) {
	double hypotenuse;
	String side1 = "";
	String side2 = "";
	double a = 0;
	double b = 0;
	// Initialize Scanner
	Scanner scan = new Scanner(System.in);


	// Ask for the second side
	System.out.println("Enter the first side:\t");
	side1 = scan.nextLine();
	// assuming the two string values entered are really numbers, 
	// try to convert them to doubles.
	try {
		a = Double.parseDouble(side1);
	} // Non numbers entered, catch the error and gracefully exit.
	catch(NumberFormatException nfe) {
		System.out.println("input needs to be numbers.");
		System.exit(2);
	}
	// Ask for the second side
	System.out.println("Enter the second side:\t");
	side2 = scan.nextLine();
	try {
		b = Double.parseDouble(side2);
	} // Non numbers entered, catch the error and gracefully exit.
	catch(NumberFormatException nfe) {
		System.out.println("input needs to be numbers.");
		System.exit(2);
	}

	//// Above replaced for using Scanner in Hypot1.java

	// calculate the hypotenuse length
	hypotenuse = Math.sqrt(((a*a)+(b*b)));
	System.out.println("The hypotenuse of a right triangle with sides of ");
	System.out.print(a + " and " + b);
    System.out.println(" is " + hypotenuse);
      
   }//end main
}// end class


/*
//// Following replaced for using Scanner in Hypot1.java
// verify that two arguments were entered on the command line.
if (args.length != 2) {
   System.out.println("You need to enter two arguments.");
   System.exit(1);
}

// assuming the two string values entered are really numbers, 
// try to convert them to doubles.
try {
	side1 = Double.parseDouble(args[0]);
	side2 = Double.parseDouble(args[1]);
} // Non numbers entered, catch the error and gracefully exit.
catch(NumberFormatException nfe) {
	System.out.println("Arguments need to be numbers.");
	System.exit(2);
}*/