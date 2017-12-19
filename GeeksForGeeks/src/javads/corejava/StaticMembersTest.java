package javads.corejava;

class StaticComponents{
	static int staticVariable;
	static{
		System.out.println("Static Initiation Block(SIB) of StaticComponents");
		staticVariable = 10;
	}
	
	static void staticMethod(){
        System.out.println("From StaticMethod");
        System.out.println(staticVariable);
	}
}
public class StaticMembersTest {

	static{
		System.out.println("StaticMembersTest static block");
	}
	public static void main(String[] args) {
		
		StaticComponents s = new StaticComponents();
		StaticComponents.staticVariable = 20;
		StaticComponents.staticMethod();
	}

}


//output
/*
1. StaticMembersTest static block
2. Static Initiation Block(SIB) of StaticComponents
3. From StaticMethod
4, 20  
 */