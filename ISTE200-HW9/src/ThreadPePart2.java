import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;



public class ThreadPePart2 extends JFrame {
	private final ReentrantLock lock = new ReentrantLock();
	private JProgressBar jprogBar1 = new JProgressBar();
	private JProgressBar jprogBar2 = new JProgressBar();
	private boolean keepGoing = true;
	public ThreadPePart2() {
		setLayout(new GridLayout(0,1));
		

		
		
		
		
		
		
		
		// Define Attributes for JProgressBar
		jprogBar1.setOrientation(JProgressBar.HORIZONTAL);	// ProgressBar's default is Horizontal
		jprogBar1.setMinimum(0);										// ProgressBar's default is 0
		jprogBar1.setMaximum(80);									//               default is 100
		jprogBar1.setValue(0);										//               default is 0
		jprogBar1.setStringPainted( true );				// Allows a string to be displayed
		jprogBar1.setString( "Progress 1" );
		jprogBar1.setIndeterminate(true);
		jprogBar2.setOrientation(JProgressBar.HORIZONTAL);	// ProgressBar's default is Horizontal
		jprogBar2.setMinimum(0);										// ProgressBar's default is 0
		jprogBar2.setMaximum(80);									//               default is 100
		jprogBar2.setValue(0);										//               default is 0
		jprogBar2.setStringPainted( true );				// Allows a string to be displayed
		jprogBar2.setString( "Progress 2" );
		jprogBar2.setIndeterminate(true);
		
		
		//Begin First Progress Bar
		JPanel jpBar = new JPanel();
			jpBar.add(new JLabel("Progres 1: "));
			
			jpBar.add(jprogBar1);

		//Begin Second Progress Bar	
		JPanel jpBar2 = new JPanel();
			jpBar2.add(new JLabel("Progres 2: "));

			jpBar2.add(jprogBar2);
			
			
			
			JButton jbClickMe = new JButton("Click Me!");
			jbClickMe.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					MyProgBar mpb1 = new MyProgBar(jprogBar1);
					MyProgBar mpb2 = new MyProgBar(jprogBar2);
					keepGoing = true;
					mpb1.start();			// Start the work and show progress bar movement
					mpb2.start();

				}
			});
			add(jbClickMe);
			add(jpBar);
			add(jpBar2);
		// setup for display
		setTitle("ThreadPePart2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		



	}
	/**
		Progress Bar movement
	*/
	protected class MyProgBar extends Thread {
		JProgressBar jprogbar;
		
		MyProgBar(JProgressBar jpb) {
			jprogbar = jpb;
		}
		public void run() {
			jprogbar.setString(null);				// Removes string, allows for auto updates
			jprogbar.setStringPainted( true );
			jprogbar.setIndeterminate(false);
			jprogbar.setValue(0);
			jprogBar1.setMaximum(80);
			int pct = jprogbar.getValue();
			
			while(pct <= jprogbar.getMaximum() && keepGoing == true){

				jprogbar.setValue(pct);				// Change the progress bar's value
				int randomSleep = (int) ((Math.random() * 100));
				try{ Thread.sleep(randomSleep); }
				catch(InterruptedException ie) {
					System.out.println("Sleep interruption exception: "+ie.getMessage());
				}
				pct++;
			}  // while loop
			keepGoing = false;
			jprogbar.setStringPainted( true );
			lock.lock();
			try {
				if(jprogbar.getValue() == 80 ){
				System.out.println(jprogbar.getString() + " You finished first");
				}
				else{
					System.out.println(jprogbar.getString() + " You didn't finish first");
				}
			}
			finally{
				lock.unlock();
			}
		} // end run()
	} // end MoveProgBar

	/** MAIN */
	public static void main(String [] args) {
		new ThreadPePart2();
	} // end main()
	
} // end ProgresBarDemo