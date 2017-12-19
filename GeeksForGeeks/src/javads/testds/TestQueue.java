package javads.testds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		/*
		 * Queue is an interface.
		 * Queue extends Collections interface
		 * LinkedList also extends collection interface.
		 * 
		 * FIFO - First In First Out
		 * add() - method to add
		 */
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		/*
		 * queue.peek() - retrieves but does not remove the head of the queue.
		 * queue.poll() - retrieves and removes the head of the queue.
		 */
		
		int head = queue.peek();
		System.out.println("Head of the queue : " + head);
		
		
		Iterator<Integer> it = queue.iterator();
		
		while(it.hasNext()){
			System.out.println(queue.poll());
			
		}
		
		
	}

}
