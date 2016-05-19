import java.util.Random;

public class Ball {
	double diameter; 
	int location;
	String color;
	String[] colorList = new String[]{"Blue","Red","Yellow", "Green"};
	Random randomGenerator = new Random();
	
    public Ball( double d) {
    	this.location = 0;
    	this.diameter= d;
    	color = colorList[randomGenerator.nextInt(4)];
    }
     
    public void move() {
		int x = randomGenerator.nextInt(10);
		System.out.println("The ball moves... " + x + " feet.");
        this.location += x;
    }
    
	public String myColor() {
		return color;
	}

    public void myRadius() {
        System.out.println("Your radius is>" + (diameter/2));
    }
    
    public int myLocation(){
    	return location;
    }
    
    public void whatAmI() {
    	System.out.println("I'm a Ball!");
    }
}


