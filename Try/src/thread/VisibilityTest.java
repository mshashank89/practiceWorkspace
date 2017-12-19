package thread;

public class VisibilityTest {

	static volatile boolean ready = false;
	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {

				while (true){
					if (ready){
						System.out.println("Read the boolean variable");
						break;
					}
				}
			}
			
		});
		
		Thread.sleep(10000);
		
		t.start();
		ready = true;
		System.out.println("Writer modified value");
		
		
	}

}
