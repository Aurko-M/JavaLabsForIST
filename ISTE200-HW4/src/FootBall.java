
public class FootBall extends Ball {

	public FootBall(double d) {
		super(d);
		this.color = "Brown";
		this.location = 0;
	}

	@Override
	public void move(){
		int x = randomGenerator.nextInt(10);
		System.out.println("The ball is thrown... " + x + " feet.");
        this.location += x;
	}
	@Override
    public void whatAmI() {
    	System.out.println("I'm a  Football!");
    }
	
	@Override
    public void myRadius() {
        System.out.println("The X-axis radius is> " + (diameter/2)
        		+ "\nThe Y-axis radius is> " + (diameter/4));
    }
}
