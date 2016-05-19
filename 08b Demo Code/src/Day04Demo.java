// Demo shows the construct and use of these items:
// start() and join() are used with a Thread object
// thObj.start() - begins a thread running
// thObj.join()  - waits for this thread object to terminate
// InterruptedException - Wait of join() can be interrupted
//
// Don't need Thread before these methods, if its class extends Thread
// Thread.sleep( # )    - Sleeps # of milliseconds
// Thread.yield()- gives up the CPU allowing another thread in it
// /mf

public class Day04Demo {
	public static void main(String [] args){
		Day04Threads t1 = new Day04Threads(1);	// Create thread objects
		Day04Threads t2 = new Day04Threads(2);
		t1.start();		// Start the threads
		t2.start();
		
		// Wait for threads to end
		try {
			System.out.println("MAIN: all started, waiting at join");
			t1.join();
			System.out.println("MAIN: finished t1");
			t2.join();
			System.out.println("MAIN: finished t2");
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}	
}

class Day04Threads extends Thread{
	private int num;
	public Day04Threads(int _num ){
		num = _num;
	}
	
	public void run() {
		System.out.println("Sleeping "+num);
		try{ sleep(2000); }		// sleeps 2 seconds
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Start yielding "+num);
		yield();
		System.out.println("Ending "+num);
	}
}