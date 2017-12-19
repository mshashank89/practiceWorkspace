/**
 * 
 */
package ds.linkedlist;


/**
 * @author shamanju
 *
 */
public class TestLinkedList {
	
	public static LinkedList initialzeLL(){
		LinkedList list = new LinkedList();
		
		list.addFront(8);
		list.addFront(7);
		list.addFront(6);
		list.addFront(5);
		list.addFront(4);
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);	
		list.addFront(3);
		list.addFront(2);
		list.addFront(1);	
		list.addFront(2);
		list.addFront(1);
        
        
        return list;
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		
		LinkedList ll = initialzeLL();
		
		int key = 7;
		ll.printList();
		System.out.println("Index of the element(Iterative) " + key + ": " + ll.iterativeFind(key));
		
		System.out.println("Index of the element (Recursive) " + key + ": " + ll.recursiveFind(key));
		
		ll.swapNodes1(2, 3);
		ll.printList();
		
		System.out.println(ll.getNthNode(89));
		
		System.out.println("Iterative length : " + ll.findLengthIterative());
		System.out.println("Recursive length : " + ll.findLengthRec());
		ll.printMiddle();
		
		ll.findReverseNth(10);
		
		System.out.println("Reversing the LL:");
		ll.reverseLL();
		ll.printList();
		ll.recursiveReverse();
		ll.printList();
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		LinkedList b = new LinkedList();
		b.addFront(10);
		b.addFront(9);
		b.addFront(8);
		b.addFront(6);
		b.addFront(5);
		
		b.printList();
		
		LinkedList a = new LinkedList();
		a.addFront(7);
		a.addFront(4);
		a.addFront(3);
		a.addFront(2);
		a.addFront(1);
		a.printList();
		
		LinkedList.mergeSortedBIntoA(b,a);
		
		a.printList();
		
		
		LinkedList c = new LinkedList();
		c.addFront(1);
		c.addFront(28);
		c.addFront(2979797);
		c.addFront(2);
		c.addFront(1);
		c.printList();
		
		String output = c.isPalindrome() ? "Palindrome" : "Not palindrome";
		System.out.println(output);
		
		
		c.printRecursive();
		c.printReverseRecursive();
		
		
		LinkedList d = new LinkedList();
		d.addFront(143433);
		d.addFront(143);
		d.addFront(28);
		d.addFront(28);
//		d.addFront(28);
//		d.addFront(28);
		d.addFront(4);
		d.addFront(4);
		d.addFront(1);
		d.printList();
		
//		d.removeDuplicateNodesFromSortedLL();
//		d.removeDuplicateNodes();
//		d.printList();
		
		d.deleteAlternate();
		
		LinkedList e = new LinkedList();
		e.addFront(0);
		e.addFront(1);
		e.addFront(0);
		e.addFront(1);
//		e.addFront(0);
//		e.addFront(1);
//		e.addFront(0);
//		e.addFront(1);
//		e.addFront(0);
//		e.addFront(1);
//		e.addFront(0);
////		e.addFront(1);
		
		e.splitAlternate();
		
	}
	
	

}
