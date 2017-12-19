package collections.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.Vector;

class SomeClass{
	public SomeClass(){
		
	}
}
public class TestArrayList extends SomeClass implements Cloneable, RandomAccess, Serializable{

	public static void main(String[] args) {

		if (new ArrayList() instanceof RandomAccess){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		
		TestArrayList obj = new TestArrayList();
		if (obj instanceof Cloneable){
			System.out.println("yes");
		}
		if (obj instanceof SomeClass){
			System.out.println("someclass yes");
		}
		
		Vector v = new Vector();
		
		LinkedList l = new LinkedList();
	}

}
