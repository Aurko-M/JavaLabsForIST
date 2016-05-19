import java.text.DecimalFormat;



/**
 * 
 */

/**
 * @author Aurko
 *
 */
public class GetInterest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
	if(args.length != 2){
		System.out.println("Usage: java GetInterest [totalMealCost] [tipAmount]");
		System.exit(0);
	}
		
	
	// Get total meal cost
    String totalMeal = args[0];
    // Get tip amount
    String tipAmount = args[1];
    
    double total = 0;
    double tip = 0;
    // Convert total meal to a double
    try {
    	total = (Double.parseDouble(totalMeal));
    }
    catch (NumberFormatException e) {
    	System.out.println("Please enter a numeric value for meal cost!");
    	System.exit(0);
    }
    // Convert tip to a double
    try {
    	tip = (Integer.parseInt(tipAmount) * .01);
    }
    catch (NumberFormatException e) {
    	System.out.println("Please enter a numeric value for tip amount!");
    	System.exit(0);
    }
    double payAmnt = (total * tip) + total;
    DecimalFormat numFormat = new DecimalFormat( "#,###,###,##0.00" );
    payAmnt = new Double(numFormat.format(payAmnt)).doubleValue();
    System.out.println("You pay: " + payAmnt);

	  
	}

}
