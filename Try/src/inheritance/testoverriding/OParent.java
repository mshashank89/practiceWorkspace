package inheritance.testoverriding;

public class OParent {
	
	private void privateVoidMethod(){
		System.out.println("parent private void method");
	}
	
	
	public void publicVoidMethod(){
		System.out.println("Parent public void method");
	}
	
	public static void publicStaticVoidMethod(){
		System.out.println("Parent public static void method");
	}
	
	public void publicnonStaticVoidMethod(){
		System.out.println("Parent public non static void method");
	}
	
	private static void privateStaticVoidMethod(){
		System.out.println("Parent private static void method");
	}

}
