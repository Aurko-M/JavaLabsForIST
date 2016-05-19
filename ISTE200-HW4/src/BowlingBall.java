
public class BowlingBall extends Ball {
	int numOfHoles;
	int weight;
	
	public BowlingBall(double d, int h, int w) {
		super(d);
		numOfHoles = h;
		this.weight = w;
		this.color = "Black";
		this.location = 0;
	}
	@Override
	public void move(){
		int x = randomGenerator.nextInt(10);
		System.out.println("The ball rolls... " + x + " feet.");
        this.location += x;
	}
	
	@Override
    public void whatAmI() {
    	System.out.println("I'm a Bowling Ball!");
    }
	public void numOfHoles(){
		System.out.println("I have " + numOfHoles + " holes.");
	}
}
