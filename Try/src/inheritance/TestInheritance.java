package inheritance;

public class TestInheritance {

	
	public static void main(String[] args) {

		Parent p = new Child2();
		p.method1(); // calls method in Child // runtime POLYMORPHISM
		p.method1(10); // calls method in Child2
		
//		Child method
//		Child 2 method int x
		
		
		Child c = new Child2();
		c.privateMethod();
		
		Child2 c2 = (Child2)p;
		c2.privateMethod();
		
		
/*		Parent p1 = new Child2();
		p1.method1();
		p1.method1(10);*/
		
		
	}

}
