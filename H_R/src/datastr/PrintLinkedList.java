package datastr;

public class PrintLinkedList {

	public static void main(String[] args) {

		Node root = new Node(0);
		
		populateList(root);
		
		System.out.println(print(root));
		
		printReverse(root);
	}

	private static void populateList(Node root) {

		Node cur = root;
		for (int i=1;i<10;i++){
			Node temp = new Node(i);
			
			cur.next = temp;
			cur = temp;
		}
		
	}
	
	private static String print(Node node)
	{
		if (null==node.next){
			return String.valueOf(node.num);
		}
		else
		{
			return node.num + " " + print(node.next);
		}
	}
	
	private static void printReverse(Node node){
		if (null == node){
			return;
		}
		
		printReverse(node.next);
		
		System.out.print(node.num + " ");
		
	}

}

class Node
{
	public int num;
	public Node next;
	
	public Node(int num){
		this.num = num;
	}
}
