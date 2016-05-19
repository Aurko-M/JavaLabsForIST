import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
	ProgressBarDemo.java
	Shows use of ProgressBar. Demo that clicking button can happen at same time
	as the 'progress bar' code is running as a thread.
	Michael Floeser
*/

public class ProgressBarDemo extends JFrame {
	private JProgressBar jprogBar = new JProgressBar();

	public ProgressBarDemo() {
		JButton jbClickMe = new JButton("Click Me!");
		jbClickMe.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,"Good click!\nClick me again!");
			}
		});
		add(jbClickMe, BorderLayout.NORTH);

		JPanel jpBar = new JPanel();
			jpBar.add(new JLabel("Progres Bar: "));
			MyProgBar mpb = new MyProgBar();
			jpBar.add(jprogBar);
			jprogBar.setOrientation(JProgressBar.HORIZONTAL);	// ProgressBar's default is Horizontal
			jprogBar.setMinimum(0);										// ProgressBar's default is 0
			jprogBar.setMaximum(100);									//               default is 100
			jprogBar.setValue(0);										//               default is 0
			jprogBar.setStringPainted( true );				// Allows a string to be displayed
 			jprogBar.setIndeterminate(false);					// Barber pole (MAC) or Cylon (PC)

			add(jpBar, BorderLayout.SOUTH);

		// setup for display
		setTitle("Progress bar demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		jprogBar.setString( "3-sec before starting" );
		try{ Thread.sleep(3000); }
		catch(InterruptedException ie){ 	ie.printStackTrace();	}

		mpb.start();			// Start the work and show progress bar movement
	}
	/**
		Progress Bar movement
	*/
	protected class MyProgBar extends Thread {

		public void run() {

			jprogBar.setString(null);				// Removes string, allows for auto updates
			jprogBar.setStringPainted( true );
			jprogBar.setIndeterminate(false);
			int pct = 0;

			for( pct = 0; pct<=100; pct++ ) {
				jprogBar.setValue(pct);				// Change the progress bar's value
				
				try{ Thread.sleep(50); }
				catch(InterruptedException ie) {
					System.out.println("Sleep interruption exception: "+ie.getMessage());
				}
			}  // for loop

			jprogBar.setStringPainted( true );
			jprogBar.setString( "Cylons RULE !" );
			
			try{ 	Thread.sleep(3000); }
			catch(InterruptedException ie){
				System.out.println("Sleep interruption exception: "+ie.getMessage());
			}

 			jprogBar.setIndeterminate(true);

		} // end run()
	} // end MoveProgBar

	/** MAIN */
	public static void main(String [] args) {
		new ProgressBarDemo();
	} // end main()
	
} // end ProgresBarDemo