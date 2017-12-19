package thread;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i=0;i<10;i++){
					System.out.println(Thread.currentThread().getName() + "  " + (i+1));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		},"Thread 1");
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i=10;i<20;i++){
					System.out.println(Thread.currentThread().getName() + "  " + (i+1));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}, "Thread 1");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		System.out.println("t2 started");
		
		t2.join();
		
		System.out.println("End of main.");
		
	}

}
