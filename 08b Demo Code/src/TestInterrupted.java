// TestInterrupted - Demo the interrupt() and interrupted() methods
//
// Main program starts a thread, then uses the interrupt() to
// terminate it.  The loop's termination condition is the 
// interrupted() method
//
// Michael Floeser

public class TestInterrupted {
    public static void main(String [] args) {
      Thread t1 = new TestInter2();
      t1.start();
		try{	Thread.sleep(1); }	// How many times 'for' loops in 1ms?
		catch(InterruptedException e){
			e.printStackTrace(); }
		
      t1.interrupt();
   }
}

class TestInter2 extends Thread {
	public void run() {
		for (int i=1; !interrupted(); i++) {
			System.out.println("Test #"+i);		// How many loops in 1ms?
		}

		System.out.println("Interrupted the loop, but can still do work." );   
	}
}
	
