package javads.corejava;

public abstract class AbstractMyClass {
	transient int j;
	//synchronized int k; //illegal modifier for 'k'. 
						//Only public, private, protected, static, final, transient and volatile are allowed.
	final void AbstractMyClass(){}
	static void f(){}
	
}
