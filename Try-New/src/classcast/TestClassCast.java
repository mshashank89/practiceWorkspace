package classcast;

public class TestClassCast {

	public static void main(String[] args) {

		SuperClass s = (SuperClass)getChClassInstance();
		
		s.sayHello();
		
	}
	
	private static ChildClass getChClassInstance(){
		return new ChildClass();
	}

}
