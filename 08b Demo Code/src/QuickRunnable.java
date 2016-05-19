import java.util.*;
/**  QuickRunnable - demo use of Runnable using a MyRun constructor 
  */
public class QuickRunnable{
	public static void main(String [] args) {
		Thread t1 = new Thread(new MyRun());
		Thread t2 = new Thread(new MyRun());
		t1.start();
		t2.start();
		System.out.println("Main is Done");
	}
}

class MyRun implements Runnable {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println( (new Date())+" "+ i );
			Thread.yield();
		}	
	}
}