import java.util.*;
import java.io.*;

public class Copy
{
	public static void main (String []args){
		if(args.length != 2){
			System.out.println("Usage: java Copy [inputFileName] [outputFileName]");
			System.exit(0);
		}
		Scanner scan = new Scanner(System.in);
	    
		// Read in arguments
		String inputFile = args[0];
		String outputFile = args[1];
		// Boolean check to see if outputfile exists or not
		boolean outExists = false;
		
		File in_file = new File(inputFile); //input file
		File out_file = new File(outputFile); //output file
		
		//Check if Inputfile doesn't exist
		if(!in_file.exists()) {
			
			System.out.println("File "+ inputFile + " doesn't exist, exiting program...");
			System.exit(0);
		}// End If 
		
		//Check if Output file exists or not
		if(!out_file.exists()) {
			System.out.println("File "+ outputFile + " doesn't exist...");
			System.out.println("Create this file? y/n");
			String outputChoice = scan.next();
			// If user chooses yes
			if(outputChoice.equalsIgnoreCase("y")){
				System.out.println("Creating file " + outputFile +".");
				Copy.writeFile(in_file, out_file, false);	// Write to file
				System.out.println("File was written, exiting program...");
				System.exit(0);
			}
			// If user chooses no
			else if (outputChoice.equalsIgnoreCase("n")) {
				System.out.println("Exiting program...");
				System.exit(0);
			}
			else {// If anyother option was give
				System.out.println("Invalid choice, exiting program...");
				System.exit(0);
			}
		}// End If
		System.out.println("The file " + outputFile + " was found, do you wish to"
				+"\n write to file - r"
				+"\n append to file - a"
				+"\n exit program - x");
		String outputChoice = scan.next();
		// Write to file
		if(outputChoice.equalsIgnoreCase("r")){
			System.out.println("Writing to file " + outputFile +".");
			Copy.writeFile(in_file, out_file, false);	// Write to file
			System.out.println("Exiting program...");
			System.exit(0);
		}
		//Append to File
		else if (outputChoice.equalsIgnoreCase("a")) {
			System.out.println("Appending to file " + outputFile +".");
			Copy.writeFile(in_file, out_file, true);	// Write to file
			System.out.println("Exiting program...");
			System.exit(0);
		}
		// Exit Program
		else if (outputChoice.equalsIgnoreCase("x")) {
			System.out.println("Exiting program...");
			System.exit(0);
		}
		//System.out.println(new File(".").getAbsoluteFile());
		//Copy.writeFile(in_file, out_file);
	}
	
	private static void writeFile(File in_file, File out_file, boolean overwrite ) {
		try
		{
			FileReader in = new FileReader(in_file);	// designate inputfile
			FileWriter out = new FileWriter(out_file, overwrite);	// designate outputfile
	
			// Begin loop to write content into output file
			int i;
			while((i = in.read()) != -1) {
				out.write(i);
			}// End Loop
			out.flush();	// Print to document
			in.close();		// Close Inputstream 
			out.close(); 	// Close outputstream
	
		}
		catch(FileNotFoundException e) {
			System.err.println("Error"+ e.getMessage());
			System.exit(0);
		} 
		catch(IOException e)
		{
			System.err.println("Error"+ e.getMessage());
			System.exit(0);
		}
	}

}