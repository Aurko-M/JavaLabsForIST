/**	
*	This program will ask the uesr for a zip code and print the proper bar code.
*	@usage: java PostalCode
*	@author: Aurko Mallik
*	
*/

// Import Scanner class
import java.util.Scanner;

public class PostalCode {
	public final static String[] BARCODE = new String[]{
			"||:::",	// Barcode Value of 0
			":::||",	// Barcode Value of 1
			"::|:|",	// Barcode Value of 2
			":|||:",	// Barcode Value of 3
			":|::|",	// Barcode Value of 4
			":|:|:",	// Barcode Value of 5
			":||::",	// Barcode Value of 6
			"|:::|",	// Barcode Value of 7
			"|::|:",	// Barcode Value of 8
			"|:|::" };	// Barcode Value of 9		
	public final static String QUIT = "Quit";
	private static int[] _zipArrayVal;		// Array to hold zipcode values
	private static int _checkDigit = 0;		// Value of check digit
	private static String _barcodeVal = "|";	// Barcode value
	
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);	// Instantiate Scanner to take input
		String inputZip = ""; 					// User input
		do {
				// Request zipcode
				System.out.println("Enter your zip code: >");	
				
				// Store Input
				inputZip = scan.nextLine();	
				
				// Perform task for 5 or 9 character zip codes
				if( inputZip.length() == 5 || inputZip.length() == 9 ) {
					// Check if string is numeric value
					if(isNumeric(inputZip) == true) {
		
						PostalCode.turnToInt(inputZip.length(), inputZip);	// turn string to an int array
						PostalCode.checkDigit();	// calculate check digit
						PostalCode.toBarCode(); 	// calculate barcode value 
						System.out.println(_barcodeVal);		// Print barcode
						
					}
					// User input error
					else {
						System.out.println("Please enter a proper zip code!");
					}
					
				}
				else if(inputZip.equalsIgnoreCase(QUIT)) {				
					System.out.println("Exiting Program...");
				}
				// User input error
				else {
					System.out.println("Please enter a 5 digit or 9 digit zip code!");
				}


		}while (!inputZip.equalsIgnoreCase(QUIT));		
      
   }//end main
	
/*
 * 	Method calculates value of checkdigit
 */
private static void checkDigit(){
	int zipTotal = 0; // summation value of zipcode digits
	// Add all values of zipcode
	for (int i = 0; i < _zipArrayVal.length; i++){
		zipTotal += _zipArrayVal[i];
	}
	_checkDigit = 10 - ((zipTotal) % 10); // get value of check digit	
}

/*
 * 	Method takes char array and returns int array
 * @param x = size of array
 * @param zip = array of char
 */
private static void turnToInt (int x, String zipcode) {
	_zipArrayVal = new int[x];	// Create an array size 5 to hold the 5 int values

	// Convert Char values to int and store in array
	for( int i = 0; i < x; i++ ){
		char temp = zipcode.charAt(i);
		_zipArrayVal[i] = Character.getNumericValue(temp);
	}
}

 /*
  *  Method to check if string is numeric type
  */
private static boolean isNumeric (String str){
	try {
		int check = Integer.parseInt(str);
	}
	catch (NumberFormatException nfe) {
		return false;
	}
	return true;
}// end isNumeric()

/*
 * Method computes barcode value
 */
private static void toBarCode(){
	// Loop through array and compare each integer value to find correct barcode representation
	for (int i = 0; i < _zipArrayVal.length; i++){
		_barcodeVal += BARCODE[_zipArrayVal[i]];
	}
	// Add check value and end "|"
	_barcodeVal += BARCODE[_checkDigit] + "|";
}// end toBarCode()
	
}// end class


