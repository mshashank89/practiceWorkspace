package inheritance;

public class Child2 extends Child {
	
	public Child2(){
		System.out.println("Child 2 constructor");
	}

	public void method1(int x){
		System.out.println("Child 2 method int x");
	}
	
	public void privateMethod(){
		System.out.println("Child2 private method");
	}

}
