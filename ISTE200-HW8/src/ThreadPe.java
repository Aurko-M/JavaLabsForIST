
public class ThreadPe {
static int count = 0;
	public static void main(String[] args) {
		String name1 = "First Inner Thread"; 
		String name2 = "Last Inner Thread";
		
		new ThreadPe(name1, name2);
		//testThread.start();

		
	}
	ThreadPe(String name1, String name2){
		ThreadPeInner myThread1 = new ThreadPeInner(name1);
		ThreadPeInner myThread2 = new ThreadPeInner(name2);
		myThread1.start();
		synchronized(myThread1){
			try{
	            myThread1.wait();
	        }catch(InterruptedException e){
	            e.printStackTrace();
	        }
		}
		myThread2.start();
		synchronized(myThread2){
			try{
	            myThread2.wait();
	        }catch(InterruptedException e){
	            e.printStackTrace();
	        }
		}
		System.out.println("Program Finished count = " + count);
	}
	
	class ThreadPeInner extends Thread {
		String name;
		ThreadPeInner(String name) {
			this.name = name;
		}
		@Override
		public void run() {	
			synchronized(this){
				System.out.println("This ran thread " + name);
				count++;
				notify();
			}
			
		}
	}
}
