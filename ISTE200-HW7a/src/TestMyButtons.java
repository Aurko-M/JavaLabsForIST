import java.awt.*;

import javax.swing.*;

import java.util.*;

public class TestMyButtons {
	public static void main( String [] args) {
		MyButtons test1 = new MyButtons();		// Test MyButtons
		MyComponents test2 = new MyComponents();// Test MyComponents
		// Set The Size of My GUI field by 200 Width and 75 Height
		test1.setSize(200,75);
		// Set Starting Location on Upper Left hand corner to 200, 300
		test1.setLocation(200, 300);
		// Allow JFrame to be resizable
		test1.setResizable(true);
		// Set Frame To close upon Exit
		test1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Set the frame to be visible
		test1.setVisible(true);
		
		// Set The Size of My GUI field by 500 Width and 300 Height
		test2.setSize(400,150);
		// Set Starting Location on Upper Left hand corner to 200, 300
		test2.setLocation(500, 300);
		// Allow JFrame to be resizable
		test2.setResizable(true);
		// Set Frame To close upon Exit
		test2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Set the frame to be visible
		test2.setVisible(true);
	}
}
