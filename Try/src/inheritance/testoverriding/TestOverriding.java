package inheritance.testoverriding;

public class TestOverriding {
	
	/*
	 * - Child classes / Extended classes cannot reduce the visibility of the methods that they are overriding
	 * - A static method cannot be made non-static in the child class. and VICE-VERSA
	 * 
	 */

	public static void main(String[] args) {

		OParent op = new OChild2();
		
		op.publicVoidMethod();
		OParent.publicStaticVoidMethod();
		OChild2.publicStaticVoidMethod();
	}

}
