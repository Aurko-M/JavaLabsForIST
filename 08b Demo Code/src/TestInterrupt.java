// TestInterrupt - Demo the interrupt() method and InterruptedException
//
// Main program starts a thread, then uses the interrupt() to
// send an interrupt, causing the thread to cause an InterruptedException.
// Program does not exit, it only receives and handles the InterruptedException
//
// Michael Floeser


public class TestInterrupt {
    public static void main(String [] args) {
      Thread t1 = new TestInter();
      t1.start();
// 		for( int i=1; i<4; i++){
			try{	Thread.sleep(2000); }		// Wait 2 seconds, or 1000*i
			catch(InterruptedException e){ }
			System.out.print("Sending interrupt....");
	      t1.interrupt();
// 		}									// end for
		
   }
}

class TestInter extends Thread {
    public void run() {
	 	for(int k=1; k<=2; k++) {						// Loops forever
	      try {
	         for (int i = 1; i<=	10 ; i++) {
	            System.out.println("Test # "+i);
	            Thread.sleep(500);		// how many 1/2 seconds 
	         }									// before interruption?
	      }
	      catch (InterruptedException exception) {
	      	System.out.println("Interrupted!");    
	      }
		} // end while
   }
}
	
