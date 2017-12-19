package ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

import ds.stack.Stack;

public class LinkedList {
	
	private Node head;

	public static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	public void addFront(int key){
		Node node = new Node(key);
		node.next = head;
		head = node;
	}
	
	/**
	 * Returns index of the key if found; else returns -1
	 * @param key
	 * @return
	 */
	public int iterativeFind(int key){
		int index = 0;
		
		Node temp = head;
		while (temp != null){
			if (temp.data == key) break;
			temp = temp.next;
			index++;
		}
		
		if (temp == null){
			return -1;
		}
		
		return index;
	}
	
	public int recursiveFind(int key){
		if (head == null) return -1;
		int index = recFind(head, key);
		
		if (index < 0) return -1;
		
		return index;
	}
	
	
	private int recFind(Node node, int key){
		if (node == null) return Integer.MIN_VALUE;
		
		if (node.data == key) return 0;
		
		else return 1 + recFind(node.next,key);
	}
	
	public int findLengthIterative(){
		int count = 0;
		
		Node temp = head;
		while (temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}

	public int findLengthRec(){
		return findLengthRecursive(head);
	}
	private int findLengthRecursive(Node node){
		if (node == null) return 0;
		
		else return 1 + findLengthRecursive(node.next);
	}
	
	
	 // prints content of double linked list
    void printList() {
    	Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println();
    }
    
    public int getNthNode(int n){
    	Node temp = head;
    	int i=0;
    	int data = -1;
    	int size = findLengthIterative();
    	if (n > size){
    		return -1;
    	}
    	while (temp != null){
    		if (i == n){
    			return temp.data;
    		}
    		data = temp.data;
    		temp = temp.next;
    		i++;
    	}
    	
    	assert(false);
    	return 0;
    }
    
    public void findReverseNth(int index){
    	int size = findLengthIterative();
    	int reverseIndex = size - index;
    	int count = 0;
    	
    	Node cur = head;
    	
    	if (index <= 0 || index > size){
			System.out.println("No element at that index");
		}
    	
    	while (cur != null){
    		if (count == reverseIndex){
    			System.out.println("Element at the index " + index + " from the end: " + cur.data);
    		}
    		count++;
    		cur = cur.next;
    	}
    }
    
    
    public void printMiddle(){
    	Node cur1 = head, cur2 = head;
    	int index = 0;
    	if (cur2 == null){
    		System.out.println("Empty LL");
    	}
    	
    	while (cur2 != null){
    		cur1 = cur1.next;
    		index++;
    		if (cur2.next != null){
    			cur2 = cur2.next.next;
    		}
    		else cur2 = cur2.next;
    	}
    	
    	System.out.println("Middle data : " + cur1.data + " Index: " + index);
    }
    
    public void reverseLL(){
    	
    	Node prev = null;
    	Node cur = head;
    	Node next = null;
    	
    	while (cur != null){
    		next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	
    	head = prev;
    }
    
    
    public void recursiveReverse(){
    	recReverse(head, null);
    }
    
    private void recReverse(Node cur, Node prev){
    	
    	if (cur == null){
    		head = prev;
    		return;
    	}
    	Node next = cur.next;
    	cur.next = prev;
    	recReverse(next, cur);
    }
    
    public void swapNodes(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    
    public void swapNodes1(int x, int y){
    	if (head == null) System.out.println("empty Linked List");
    	
    	Node temp = head;
    	Node xPrev = null, xNode = null, yPrev = null, yNode = null;
    	
    	while (temp != null){
    		if (temp.next != null && temp.next.data == x) xPrev = temp;
    		
    		if (temp.data == x) xNode = temp;

    		if (temp.next != null && temp.next.data == y) yPrev = temp;
    		
    		if (temp.data == y) yNode = temp;
    		
    		temp = temp.next;
    	}
    	
    	//swap data
    	yPrev.next = xNode;
    	xPrev.next = yNode;
    	
    	Node tempNode = xNode.next;
    	xNode.next = yNode.next;
    	yNode.next = tempNode;
    	
    	
    	
    	
    }
    
    public static void mergeSortedBIntoA(LinkedList a, LinkedList b){
    	Node aCur = a.head, bCur = b.head;
    	Node aPrev = null;
    	
    	while (aCur != null && bCur != null){
    		while ((aCur != null && bCur != null) && (aCur.data > bCur.data)){
    			//insert bCur before aCur
    			Node temp = bCur;
    			bCur = bCur.next;
    			if (aPrev == null){
    				temp.next = aCur;
    				a.head = temp;
    			}
    			else{
	    			aPrev.next = temp;
	    			temp.next = aCur;
    			}
    			aPrev = temp;
    		}
    		while ((aCur != null && bCur != null) && (aCur.data < bCur.data)){
    			//move aCur, aPrev to the right
    			aPrev = aCur;
    			aCur = aCur.next;
    		}
    		
    	}
    	if (bCur != null && aCur == null){
    		//add the remaining part of b into a
    		aPrev.next = bCur;
    	}
    }
    
    
    public boolean isPalindrome(){
    	boolean isPalindrome = false;
    	
    	int length = findLengthIterative();
    	Node cur = head;

		Stack stk = new Stack(length/2);
		for (int i = 0;i<length/2 ;i++){
			stk.push(cur.data);
			cur = cur.next;
		}
		if (length % 2 != 0){
	    	// odd case
			//skip the middle element
    		cur = cur.next;
		}
		
		while (cur != null){
			if (cur.data != stk.pop()){
				return false;
			}
			cur = cur.next;
		}
		
		if (stk.getNoOfElements() == 0){
			isPalindrome = true;
		}
    	
    	return isPalindrome;
    }
    
    
    public void printRecursive(){
    	printRec(head);
    	System.out.println();
    }
    
    public void printReverseRecursive(){
    	printRevRec(head);
    	System.out.println();
    }
    
    private void printRec(Node cur){
    	if (null== cur){
    		return;
    	}
    	System.out.print(cur.data + " -> ");
    	printRec(cur.next);
    }
    
    private void printRevRec(Node cur){
    	if (null== cur){
    		return;
    	}
    	
    	printRevRec(cur.next);
    	System.out.print(cur.data + " -> ");
    	
    }
    
    
    public void removeDuplicateNodesFromSortedLL(){
    	Node prev = head;
    	Node cur = head.next;
    	
    	while (cur != null){
    		if (prev.data == cur.data){
    			//remove cur if prev data and cur data are same
    			
    			//if cur is the last node
    			if (cur.next == null){
    				prev.next = null;
    				break;
    			}
    			//if cur is not the last node
    			prev.next = cur.next;
    			cur = cur.next;
    		}
    		else{
    			prev = cur;
    			cur = cur.next;
    		}
    		
    	}
    }

    public void removeDuplicateNodes(){
    	Node prev = head;
    	Node cur = head.next;
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	while (cur != null){
//    		if ((null != map.get(cur.data)) && (map.get(cur.data) == cur.data)){
    		if (map.get(cur.data) == Integer.valueOf(cur.data)){
    			//remove cur if prev data and cur data are same
    			
    			//if cur is the last node
    			if (cur.next == null){
    				prev.next = null;
    				break;
    			}
    			//if cur is not the last node
    			prev.next = cur.next;
    			cur = cur.next;
    		}
    		else{
    			map.put(cur.data, cur.data);
    			prev = cur;
    			cur = cur.next;
    		}
    		
    	}
    }
    
    
    public void deleteAlternate(){
    	Node prev = head;
    	Node cur = head.next;
    	
    	while (cur != null){
    		//delete node cur
    		prev.next = cur.next;
    		cur = cur.next;
    		//move to the next node to be deleted.
    		if (null != cur){
    			prev = cur;
    			cur = cur.next;
    		}
    	}
    	
    	System.out.println("After deleting alternate nodes: ");
    	printList();
    }
    
    
    public void splitAlternate(){
    	LinkedList a = new LinkedList();
    	LinkedList b = new LinkedList();
    	
    	Node cur = head, aCur = null, bCur = null;
    	boolean flag = false;
    	
    	while (cur != null){
    		if (flag){
    			if (a.head == null){
    				a.head = cur;
    				aCur = cur;
    			}
    			else {
    				aCur.next = cur;
    				aCur = aCur.next;
    			}
    			flag = !flag;
    			cur = cur.next;
    		}
    		else {
    			if (b.head == null){
    				b.head = cur;
    				bCur = cur;
    			}
    			else {
    				bCur.next = cur;
    				bCur = bCur.next;
    			}
    			flag = !flag;
    			cur = cur.next;
    		}
    	}
    	
    	System.out.print("A list : ");
    	a.printList();
    	System.out.print("B list : ");
    	b.printList();
    }
}
 