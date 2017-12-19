package inheritance.testoverriding;

public class OChild extends OParent{

	private void privateVoidMethod(){
		System.out.println("child private void method");
	}
	
	public static void privateStaticVoidMethod(){
		System.out.println("child private static void method");
		
	}
	
	public synchronized void publicVoidMethod(){
		
		synchronized(new Object()){
			
		}
		System.out.println("child public void method");
	}
	
	public static void publicStaticVoidMethod(){
		System.out.println("child public static void method");
	}
	

}
