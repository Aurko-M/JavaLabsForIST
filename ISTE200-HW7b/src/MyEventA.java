/** MyEventA.java
 * 	creates a JFrame that will perform an action based on the button clicked.
 * 	This program is to demonstrate understanding of Event Handling using getSource() command
 * 	@author Aurko
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyEventA extends JFrame
{
	// Create the buttons
	public final JButton ADDBUTTON = new JButton("+"); // Add Button
	public final JButton SUBTRACTBUTTON = new JButton("-"); // Subtract Button
	public final JButton RESETBUTTON = new JButton("Reset"); // Rest Button
	public final JButton QUITBUTTON = new JButton("Quit"); // Quit Button
	public final JLabel CURRENTVALLABEL = new JLabel("Current Value: ");// Create the JLabel
	private JTextField textField = new JTextField("0", 10);// Create the Text Field
	
	/* Test The Frame
	 * 
	 */
	public static void main( String [] args) {
		MyEventA test1 = new MyEventA();		// Test MyEventA
		// Set The Size of My GUI field by 400 Width and 200 Height
		test1.setSize(350,150);
		// Set Starting Location on Upper Left hand corner to 200, 300
		test1.setLocation(200, 300);
		// Allow JFrame to be re-sizable
		test1.setResizable(true);
		// Set Frame To close upon Exit
		test1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Set the frame to be visible
		test1.setVisible(true);
	}
	/*
	 *  MyEventA()
	 *  Creates the JFrame
	 */
	public MyEventA() {
		// Create a new Panel
		// Use this Panel as a wrapper for other Panels
		JPanel myPanel = new JPanel();
		// Set Title of Frame
		this.setTitle("Part 2 Using getSource");
		// Set Layout of JPanel to have 2 rows and one column
		myPanel.setLayout(new GridLayout(2,1));
		myPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));	// add spacing	
		// Establish the first row with 2 columns with 5px gap
		JPanel row1 = new JPanel();
		row1.setLayout(new GridLayout(1,2, 5, 5));
		// Establish the second row with 4 columns with 5px gap
		JPanel row2 = new JPanel();
		row2.setLayout(new GridLayout(1,4, 5, 5));
		
		// Initialize click handler
		ClickButtonHandler clickHandler = new ClickButtonHandler( textField );
		
		// Add ClickHandler Functionality to all buttons
		ADDBUTTON.addActionListener(clickHandler);	
		SUBTRACTBUTTON.addActionListener(clickHandler);
		RESETBUTTON.addActionListener(clickHandler);
		QUITBUTTON.addActionListener(clickHandler);
		
		// Add Jlabel and Text Field to first row
		row1.add(CURRENTVALLABEL); // Add Label
		row1.add(textField); // Add Text Field
		// Add Buttons to row 2
		row2.add(ADDBUTTON);
		row2.add(SUBTRACTBUTTON);
		row2.add(RESETBUTTON);
		row2.add(QUITBUTTON);
		// Insert Each Panel into the wrapper panel
		myPanel.add(row1);
		myPanel.add(row2);
		// Add Wrapper JPanel to JFrame
		this.add(myPanel);
	}	
	/*	
	 * Click Button Handler manages the function of each button
	 * uses getSource()
	 */
	private class ClickButtonHandler implements ActionListener {
		private JTextField jtfModify = null;	// Text Field to modify
		private int counter = 0;				// Number Counter
		// Method to take in text field from JFrame to modify
		private ClickButtonHandler( JTextField _jtf ){
			jtfModify = _jtf;
		}

		//Method to perform button action based on button's value
		public void actionPerformed( ActionEvent ae ){
			// If the button is ADDBUTTON
			if (ae.getSource() == ADDBUTTON) {
				counter++;// Increment counter by 1
			}
			// If the button is SUBTRACTBUTTON
			else if (ae.getSource() == SUBTRACTBUTTON) {
				counter--;// Decrement counter by 1
			}
			// If the button is RESETBUTTON
			else if (ae.getSource() == RESETBUTTON) {
				counter = 0; // Reset the counter to 0
			}
			// If the button is QUITBUTTON
			else if (ae.getSource() == QUITBUTTON) {
				System.exit(0);	// Exit the program
			}
			
			// Set Textfield to counter's value
			jtfModify.setText( "" + counter );
		}// End actionPerformed()
	}// End ClickButtonHandlerClass
}// End MyEventA