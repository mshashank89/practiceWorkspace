package inheritance;

public class Parent {
	public Parent(){
		System.out.println("Parent constructor");
	}
	
	public void method1(){
		System.out.println("Parent method");
	}
	
	public void method1(int x){
		System.out.println("Parent int x");
	}
	
	private void privateMethod(){
		System.out.println("Parent private method");
	}

}
