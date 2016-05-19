
public class BallTest {

	public static void main(String[] args) {
	Ball ball = new Ball(5);
	BowlingBall bowlingball = new BowlingBall(5,3,15);
	FootBall football = new FootBall(8);
	Ball fBall = new FootBall(10);
	Ball bBall = new BowlingBall(6,7,8);
	
	ball.whatAmI();
	bowlingball.whatAmI();
	football.whatAmI();
	
	System.out.println("Ball is "+ball.myColor());
	System.out.println("Bowling Ball is "+bowlingball.myColor());
	System.out.println("Football is "+football.myColor());
	
	System.out.println("Test Ball method for Football assigned to Ball");
	fBall.whatAmI();
	System.out.println("Test Ball method for BowlingBall assigned to Ball");
	bBall.whatAmI();
	//System.out.println("Test Bowling Ball method for bowlingball assigned to Ball");
	//bBall.numOfHoles();
	}

}
