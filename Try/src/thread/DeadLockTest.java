package thread;

public class DeadLockTest {

	public static void main(String[] args) {

		final Object a = new Object();
		final Object b = new Object();
		
		Runnable block1 = new Runnable(){

			@Override
			public void run() {

				synchronized(a){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(b){
						System.out.println("block1");
					}
				}
			}
			
		};
		
		Runnable block2 = new Runnable(){

			@Override
			public void run() {

				synchronized(b){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(a){
						System.out.println("block2");
					}
				}
			}
			
		};
		
		Thread t1 = new Thread(block1);
		Thread t2 = new Thread(block2);
		
		t1.start();
		t2.start();
		
		System.out.println("End");
		
	}

}


