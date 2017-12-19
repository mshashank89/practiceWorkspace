import java.util.Scanner;

/**
 *
 */
public class ProdConsTest {

	private static Object _LOCK = new Object();
	
	private static boolean flag = true;
	
	private static int num = 0;
	public static void main(String[] args) {
		
		Thread prod = new Thread(new Runnable(){

			@Override
			public void run() {
				while (flag){
					synchronized(_LOCK)
					{
//						sleep(2);
						num++;
						
						_LOCK.notify();
						System.out.println("["+Thread.currentThread().getName()+ "] " + "Number: " + num);
						
						try
						{
							_LOCK.wait(10);
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
				System.out.println("Stopping prod. . .");
			}
		}, "Producer");
		
		
		Thread cons = new Thread(new Runnable(){

			@Override
			public void run() {
				while (flag){
					synchronized(_LOCK)
					{
						System.out.println("["+Thread.currentThread().getName()+ "] " + "                Number: " + num--);
						try 
						{
							_LOCK.wait(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						_LOCK.notify();
					}
				}
				System.out.println("Stopping cons. . .");
			}
			
		}, "Consumer");
		
		
		System.out.println("Starting. . . Press any key to stop");
		prod.start();
		cons.start();
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		
		flag = false;
		
	}
	
	private static void sleep(long millis){
		try 
		{
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
