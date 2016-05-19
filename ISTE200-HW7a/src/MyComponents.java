import java.awt.*;
import javax.swing.*;
import java.util.*;

public class MyComponents extends JFrame
{
	public MyComponents()
	{
		// Create new JPanel
		// Use this JPanel as a wrapper for other panels
		JPanel myPanel = new JPanel();	
		
		// Set Title of Frame to 'MyButtons'
		this.setTitle("My Components");
		
		// Set the layout of the JPanel to have 4 rows and 2 columns
		myPanel.setLayout(new GridLayout(4,2));
		
		// Establish the first Row with 2 columns
		JPanel row1 = new JPanel();
		row1.setLayout(new GridLayout(1,2));	
		
		// Establish the Second Row with 2 columns
		JPanel row2 = new JPanel();
		row2.setLayout(new GridLayout(1,2));	
		
		// Establish the Third Row with 2 columns
		JPanel row3 = new JPanel();
		row3.setLayout(new GridLayout(1,2));
		
		// Establish the Fourth Row with 2 columns
		JPanel row4 = new JPanel();
		row4.setLayout(new GridLayout(1,2));
		
		// Create Two Buttons
		JButton JButton1 = new JButton("Button 1");
		JButton JButton2 = new JButton("Button 2");
		
		// Create Two Labels for Each Button
		JLabel firstNum = new JLabel("Enter First Number");
		JLabel secondNum = new JLabel("Enter Second Number");
		
		// Create Two Text Fields
		JTextField firstNumText = new JTextField();
		JTextField secondNumText = new JTextField();
		

		// Insert Label 1 and Text 1 to first row
		row1.add(firstNum);	// Add Label
		row1.add(firstNumText);	// Add Text Field
		
		// Insert Label 2 and Text 2 to second row
		row2.add(secondNum);	// Add Label
		row2.add(secondNumText);// Add Text Field
		
		// Insert Buttons to the third row
		row3.add(JButton1);	// Add Button 1
		row3.add(JButton2);	// Add Button 2
		
		// Insert Each Panel to the wrapper panel
		myPanel.add(row1);	// Insert first row
		myPanel.add(row2);	// Insert second row
		myPanel.add(row3);	// Insert third row
		myPanel.add(row4);	// Insert fourth row

		// Add Wrapper JPanel to JFrame
		add(myPanel);
	}
}