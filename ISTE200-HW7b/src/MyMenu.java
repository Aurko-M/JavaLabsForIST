import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyMenu extends JFrame {
	JMenuBar menuBar; 	// Create a menu bar
	JMenu count;		// Create a menu Option
	JMenuItem inc; 		// Increment
	JMenuItem dec; 		// Decrement
	JMenuItem reset;	// Reset
	JMenuItem exit;		// Exit
	JTextArea textArea; // Text Area
	private static int countNum = 0; // Number Counter
	private final static String NEWLINE = "\n";
	
	public static void main(String[] args) {
		MyMenu test1 = new MyMenu();		// Test MyEventA
		// Set The Size of My GUI field by 400 Width and 200 Height
		test1.setSize(350,500);
		// Set Starting Location on Upper Left hand corner to 200, 300
		test1.setLocation(200, 300);
		// Allow JFrame to be re-sizable
		test1.setResizable(true);
		// Set Frame To close upon Exit
		test1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		// Set the frame to be visible
		test1.setVisible(true);
		
	}
	public MyMenu() {
		//	Create TextArea with 20 rows and 15 columns 
		// 	with scrollable text.
		textArea = new JTextArea("",20,15);
		JScrollPane scroll = new JScrollPane (textArea, 
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		this.add(textArea);
		

		// Create Menu Bar
		menuBar = new JMenuBar();
		// Add the menubar to the frame
		setJMenuBar(menuBar);
        
		//Build First Menu.
		count = new JMenu("Count");

			// Create New Menu Item and it to menu
			inc = new JMenuItem("Inc");
			count.add(inc);
		
			// Create New Menu Item and it to menu
			dec = new JMenuItem("Dec");
			count.add(dec);
			
			// Create New Menu Item and it to menu
			reset = new JMenuItem("Rest");
			count.add(reset);
			
			// Create New Menu Item and it to menu
			exit = new JMenuItem("Exit");
			count.add(exit);
			
		// Add menu to menu bar
		menuBar.add(count);
		
		// Initialize click handler
		MyListenerCnt clickHandler = new MyListenerCnt( textArea );
		
		inc.addActionListener(clickHandler);	
		dec.addActionListener(clickHandler);
		reset.addActionListener(clickHandler);
		exit.addActionListener(clickHandler);
		
	}
	
	private class MyListenerCnt implements ActionListener {
		private JTextArea jtModify = null;
		// Method to take in text field from JFrame to modify
		private MyListenerCnt( JTextArea _jtf) {
			jtModify = _jtf;
		}
		
		// Method to perform button action based on button's values
		public void actionPerformed( ActionEvent ae ){
			//If button is inc
			if (ae.getSource() == inc) {
				countNum += 1;
			}
			
			//If button is dec
			else if (ae.getSource() == dec) {
				countNum -= 1;
			}
			
			//If button is reset
			else if (ae.getSource() == reset) {
				countNum = 0;
			}
			
			//If button is exit
			else if (ae.getSource() == exit) {
				System.exit(0);	// Exit the program
			}
			
			jtModify.append(countNum + NEWLINE);

		}
		
		
	}
}
