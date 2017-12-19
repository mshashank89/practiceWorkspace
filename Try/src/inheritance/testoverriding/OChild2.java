package inheritance.testoverriding;

public class OChild2 extends OChild {
	private void privateVoidMethod(){
		System.out.println("child 2 private void method");
	}
	
	
	public static void privateStaticVoidMethod(){
		System.out.println("child 2 private static void method");
		
	}
	
	public void publicVoidMethod(){
		System.out.println("child 2 public void method");
	}
	
	public static void publicStaticVoidMethod(){
		System.out.println("child 2 public static void method");
	}
}
