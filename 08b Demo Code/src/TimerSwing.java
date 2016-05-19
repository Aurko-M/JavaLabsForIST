import javax.swing.*;		// for javax.swing.Timer class
import java.awt.*;
import java.awt.event.*;

/** 
	TimerSwing - Shows use of javax.swing.Timer
	Executes an actionPerformed after with an initial and a between-event delay. 
	Need to END this program manually. It shows that the timer can run forever.
	/ mf
*/

public class TimerSwing
{
	private int swingCount=0;
	
	public static void main(String [] args)
	{
		new TimerSwing();
	}
	
	public TimerSwing()
	{
		final int DELAY = 500;		// Waits half second
		
		// Create an action-object to execute on a specific time interval
		ActionListener  swingAction = new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Swing time count = "+ ++swingCount );
			}
		};
		
		System.out.println("Swing started here-----------------");
		
		// Start and execute the timer at a specific interval
		// Every 500ms, execute action, start the timer running
		new javax.swing.Timer( DELAY, swingAction ).start();		// .restart();

		try{ Thread.sleep(2000);}		// Wait 2 seconds
		catch(Exception e){				// Without this, the program exits before
			e.printStackTrace(); }		// the timer can start.
		
		System.out.println("TimerSwing main ended--------------");
	}
}
