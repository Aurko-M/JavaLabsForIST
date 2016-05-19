import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class ClientApplication_V2 extends JFrame {
   
   TextArea output = new TextArea();
   JPanel panel = new JPanel();
   JTextField txtwrite = new JTextField();
   JScrollPane scrollPane = new JScrollPane(output);

   
   BufferedReader bin;
   PrintWriter pout;
   Socket s;


   public static void main(String[] args) {
      new ClientApplication_V2();
   }
   public ClientApplication_V2() {
      setTitle("Clinet/Server Chat");
      output.setEditable(false);
      setSize(350,75);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(output);
      add(txtwrite, java.awt.BorderLayout.PAGE_END);
      txtwrite.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent evt) {
                  txtwriteActionPerformed(evt);
               }
            });
   
      try{																								
      	// These two lines show how to get the IP address of this client			
         output.append("getLocalHost: "+InetAddress.getLocalHost() + "\n");			
         output.append("getByName:    "+InetAddress.getByName("localhost"));
      																									
      	// Make a connection with the server
         s = new Socket( "192.168.1.5", 16789);
      
      	// Open input from server																
         bin = new BufferedReader(new InputStreamReader(s.getInputStream()));		
      																									
      	// open output to server																
         pout = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));			
      	
      } 
      catch(UnknownHostException uhe) {														
         System.out.println("no host");														
         uhe.printStackTrace();
         System.exit(ERROR);
      }																									
      catch(IOException ioe) {																	
         System.out.println("IO error");														
         System.exit(ERROR);																
      }
      setVisible(true);
      setLocation(400,400);
      pack();
      new areaThread().start();
      
   
   }  
   private void txtwriteActionPerformed(java.awt.event.ActionEvent evt) {
      try {
         if (!txtwrite.getText().equals("")) {
            pout.println(txtwrite.getText());
            pout.flush();
            txtwrite.setText("");
         }
      } 
      catch (Exception e) {
      }
   }  
   class areaThread extends Thread {
   	
      JScrollBar vertical = scrollPane.getVerticalScrollBar();
   	
      public void run() {
         while (true) {
            try {
               String line;
               while((line = bin.readLine()) != null){
                  output.append("\n");
                  output.append(line);
               	
               	//Auto-scroll
                  vertical.setValue( vertical.getMaximum() );
               }
            } 
            catch (Throwable x) {
               System.err.println("Catched "+x.getClass().getName());
               break;
            }
         }
      }
   	
   }	
	 	
}		      
       
       
   
