import java.util.*;		// for java.util.Timer class
import java.awt.*;
import java.awt.event.*;
/**
	TimerUtil - Demos the Timer() class from java.util package
	This also uses the TimerTask() executes a run() after a delay, then on a set time interval.
*/
public class TimerUtil
{
	private int utilCount=0;		// Show the number of times through Timer
	
	public static void main(String [] args)
	{
		new TimerUtil();
	}
	
	public TimerUtil()
	{
		final int START_AFTER = 2000;
		final int DELAY = 500;

		TimerTask utilAction = new TimerTask(){
			public void run()
			{
				System.out.println("Util time count = "+ ++utilCount );
			}
		};
		
		System.out.println("Main: Util started");
		
		java.util.Timer utilTimer  = new java.util.Timer();

		utilTimer.scheduleAtFixedRate( utilAction, START_AFTER, DELAY );
		
// 		try{ Thread.sleep(4000);}
// 		catch(Exception e){}
		
		System.out.println("TimerUtil main ended");
	}
}
