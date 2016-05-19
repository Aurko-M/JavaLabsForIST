import java.awt.*;
import javax.swing.*;
import java.util.*;

public class MyButtons extends JFrame
{
	public MyButtons()
	{
		// Create new JPanel
		JPanel myPanel = new JPanel();	
		
		// Set Title of Frame to 'MyButtons'
		this.setTitle("MyButtons");
		
		// Set the layout of the JPanel to have 1 row and 2 columns
		myPanel.setLayout(new GridLayout(1,2));

		// Create Two Buttons
		JButton JButton1 = new JButton("Button 1");
		JButton JButton2 = new JButton("Button 2");
		
		// Insert Buttons inside JPanel
		myPanel.add(JButton1);
		myPanel.add(JButton2);
		

		// Add JPanel to JFrame
		add(myPanel);
	}
}