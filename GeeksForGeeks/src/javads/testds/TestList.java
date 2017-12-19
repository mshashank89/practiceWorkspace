package javads.testds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		//list of lists
		
		ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>();
		
		for (int i=0;i<5;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j=0;j<5;j++){
				list.add(j);
			}
			listOfList.add(list);
		}
		
		
		System.out.println("Print List:");
		
		for (int i=0;i<5;i++){
			ArrayList<Integer> list = listOfList.get(i);
			for (int j=0;j<5;j++){
				System.out.print(list.get(j) + "  ");
			}
			System.out.println();
		}
		
		

	}
	
	
	public static void main1(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i=1;i<6;i++){
			arrayList.add(i);
		}
		
		/*
		 * BEhaviour of arrayList.listIterator() 
		 * 		and 	arrayList.iterator() 
		 * is the same.
		 * Both iterate over the arrayList
		 */
		
		
		
		System.out.println("Test ListIterator");
		Iterator<Integer> iterator = arrayList.listIterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + "  ");    //prints from 1 - 5
		}
		
		System.out.println("\nTest remove in listIterator");
		Iterator<Integer> i2 = arrayList.listIterator();
		while(i2.hasNext()){
			int i = i2.next();
			i2.remove();
			System.out.print(i + "  ");    //prints from 1 - 5
		}
		
		
		System.out.println("\n\nTest Iterator");
		Iterator<Integer> it = arrayList.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + "  ");    //prints from 1 - 5
		}
		
		System.out.println("\nTest remove in iterator");
		Iterator<Integer> i3 = arrayList.iterator();
		while(i3.hasNext()){
			int i = i3.next();
			i3.remove();
			System.out.print(i + "  ");    //prints from 1 - 5
		}
	}

}
