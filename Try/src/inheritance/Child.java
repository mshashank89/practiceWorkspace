package inheritance;

import inheritance.testoverriding.TestInterface;

public class Child extends Parent implements TestInterface{
	
	public Child(){
		System.out.println("Child constructor");
	}
	public void method1(){
		System.out.println("Child method");
	}
	
	protected void privateMethod(){
		System.out.println("child private method");
	}

	protected void printIntVal(){
		//Cannot assign value to the interface variable
//		TestInterface.integerVariable = 200;
		System.out.println("Interface variable value :" + integerVariable);
	}

}
