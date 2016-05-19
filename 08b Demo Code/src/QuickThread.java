import java.util.*;
/** QuickThread - demo of Thread class running threads */
public class QuickThread{
	public static void main(String [] args) {
		MyTh t1 = new MyTh();
		MyTh t2 = new MyTh();
		t1.start();
		t2.start();
		System.out.println("Main is Done");
	} 
}

class MyTh extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println( (new Date())+" "+getName() );
		} 	
	}
}