import java.util.*;
public class Orders {

	public static void main(String[] args) {
		ArrayList<Truck> tList = new ArrayList<Truck>();// Holds Collection of Trucks
		ArrayList<Car> cList = new ArrayList<Car>();	// Holds Collection of Cars
		Scanner Scan = new Scanner(System.in);	
		String choice = "y";
		//Print Opening Statement
		System.out.println("Aurko's Ordering System 200-HW3");
		while(choice.equalsIgnoreCase("y")){

			System.out.println("Do you want to order a Truck(T/t) or Car (C/c)?");
			String vehicleChoice = Scan.nextLine();
			
			switch(vehicleChoice.toLowerCase()){			
				// Case Car
				case "c":
					System.out.println("Entering Car order:");
					// Care Model Name
					System.out.println("Model: ");
						String cmodel = Scan.nextLine();
					// Car Color Name
					System.out.println("Color: ");
						String ccolor = Scan.nextLine();
					// Car Cost Value	
					System.out.println("Cost:");
						double ccost = Scan.nextDouble();
					// Car Type Choice	
					System.out.println("What type of car is it?"
							+ "\n1. Sedan"
							+ "\n2. Coupe"
							+ "\n3. Wagon");
						int typeInp = Scan.nextInt();
						String type = "";
						switch(typeInp){
						case 1: type = "Sedan";
							break;
						case 2: type = "Coupe";
							break;
						case 3: type = "Wagon";
							break;
						default: type = "Invalid selection";
							break;
						}
					System.out.println("Does this car have a towing package?"
							+ "\n1. Yes"
							+ "\n2. No");
						int towing = (Scan.nextInt()-1);
					// Create a Car object and add it to list
						cList.add(new Car(cmodel, ccolor, ccost, type, towing));	
					System.out.println();
				break;
				
				// Case Truck
				case "t":		
					System.out.println("Entering Truck order:");
					System.out.println("Model: ");
						String tmodel = Scan.nextLine();
					System.out.println("Color: ");
						String tcolor = Scan.nextLine();
					System.out.println("Cost:");
						double tcost = Scan.nextDouble();
					System.out.println("What size truck is this?"
							+ "\n1. Half-Ton"
							+ "\n2. Full-Ton");
						int load = (Scan.nextInt()-1);
					System.out.println("What is the engine size of the truck?"
							+ "\n1. Small"
							+ "\n2. Medium"
							+ "\n3. Large");
						int size = (Scan.nextInt()-1);	
	
					// Create a Car object and add it to list
					tList.add(new Truck(tmodel, tcolor, tcost, load, size));
					System.out.println();
				break;
				
				default: 
					System.out.println("Please enter a proper value");
					break;
				}
			System.out.println("Do you want to order another vehicle?");
			choice = Scan.next();	
			if (choice.equalsIgnoreCase("n")){
				// Print all cars
				for(int i = 0; i < cList.size(); i ++) {
					System.out.println(cList.get(i).toString());
					System.out.println();
				}
				// Print all cars
				for(int i = 0; i < tList.size(); i++){
					System.out.println(tList.get(i).toString());
					System.out.println();
				}
				System.out.println("Thank you for using Aurko's Ordering System.");

			}
			Scan.nextLine(); // Clear Scanner Buffer
		}
		

		
	}// End Main
}// End Orders
	
