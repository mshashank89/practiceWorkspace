package collections.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {

		//Test add heterogeneous elements to set
		
		try{
			Set set = new TreeSet();
			set.add(1);
			set.add("2");   ///ClassCastException: java.lang.Integer cannot be cast to java.lang.String
			set.add(3);
			
			for (Object o : set){
				System.out.println(o);
			}

			Iterator it = set.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		List list = new LinkedList();
		list.add(1);
		list.add("2");
		list.add(3);
		
		for (Object o : list){
			System.out.println(o);
		}
		
		System.out.println("List Iterator");
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
