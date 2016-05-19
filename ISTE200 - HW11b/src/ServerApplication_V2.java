import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

public class ServerApplication_V2 extends JFrame {
   public TextArea output;
   //private JTextField txtWrite;
   
   ArrayList<ClientThread> clients = new ArrayList<>();
   
   public static void main(String [] args) {
      new ServerApplication_V2();
   }
   
   public ServerApplication_V2() {
      JFrame frame = new JFrame("Clinet/Server Chat");
      output = new TextArea();
      //txtWrite = new JTextField();
   
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      output.setEditable(false);
      frame.add(output);
      frame.pack();
      frame.setVisible(true);
      frame.setLocation(400,400);
      
      ServerSocket ss = null;
      try {
         output.append("getLocalHost: "+InetAddress.getLocalHost() );
         output.append("\ngetByName:    "+InetAddress.getByName("localhost") );
      
         ss = new ServerSocket(16789);
         Socket cs = null;
         int userCount = 1;
        
         while(true){
           
            cs = ss.accept(); 
            ClientThread ths = new ClientThread( cs, "User " + userCount++ );	// Pass socket to thread
            clients.add(ths);
            ths.start();
           
         }// end while
      }
      catch( BindException be ) {
         System.out.println("Server already running on this computer, stopping.");
      }
      catch( IOException ioe ) {
         System.out.println("IO Error");
         ioe.printStackTrace();
      }
             
   }

    
    
   class ClientThread extends Thread {
      private BufferedReader br;
      private PrintWriter opw;
      private String clientMsg;
      private String name;
   
      public ClientThread(Socket cs, String name) {
      	
         this.name = name;
         output.append("\nNew client: " + name);
      	
         try {
            br = new BufferedReader(new InputStreamReader(
               	cs.getInputStream()));
            opw = new PrintWriter(new OutputStreamWriter(
               	cs.getOutputStream()));
         } 
         catch (IOException e) {
            e.printStackTrace();
         }
      	
         sendMsg( "\nWelcome, " + name + ", you joined the chat!");
         sendToAllElse(name + " has joined the chat.");
      }
   
   	//Broadcast all messages sent by this client until "stop" is received
      public void run() {
         try {
            do {
            
               clientMsg = br.readLine(); // from client
               output.append("\nServer read: " + name + ": " + clientMsg);
            	
            	//Send this message to all clients
               for (ClientThread threadServer : clients) {
                  threadServer.sendMsg(name + ": " + clientMsg );
               }
            
            } while (!clientMsg.equalsIgnoreCase("STOP"));
         
         } 
         catch (Exception e) {}
         finally {
            leave();
         }
      }
   	
   	//Send a message to this client only
      public void sendMsg(String msg) {
         opw.println(msg);
         opw.flush();
      }
   	
   	//Send to all users EXCEPT this one
      public void sendToAllElse(String msg) {
         for (ClientThread clientThread : clients) {
            if (!clientThread.equals(this)) {
               clientThread.sendMsg(msg);
            }
         }
      }
   	
   	//Client leaves
      public void leave() {
         String leaveMsg = "\n" + name + " has left the chat.";
         output.append(leaveMsg);
         sendToAllElse(leaveMsg);
         clients.remove(this);
      }
        
   }

}
   
