package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSum {

	public static void main(String[] args) {
		Node tree = populateTree();
		
		printSum(tree, 22);
	}

	/**
	 * Method to print the path whose weight is equal to the given sum
	 * @param tree
	 * @param i
	 */
	private static void printSum(Node tree, int sum) {
		
		if (null == tree){
			return;
		}
		tree.sum += tree.num;
		tree.nodeList.add(tree.num);
		
		if (sum == tree.sum && tree.isLeaf()){
			printPath(tree);
			return;
		}
		
		if (tree.isLeaf()){
			System.out.println(tree.sum + " : Sum does not match");
		}
		tree.populateChild();
		
		printSum(tree.left, sum);
		printSum(tree.right, sum);
		
	}
	
	private static void printPath(Node tree) {
		System.out.print(tree.sum + " : ");
		for (int num : tree.nodeList){
			System.out.print(num + " ");
		}
		System.out.println();
	}


	private static Node populateTree() {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		
		root.left.left.left = new Node(6);
		root.left.left.left.right = new Node(9);
		
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		
		root.right.left.right.left = new Node(10);
		root.right.left.right.right = new Node(11);
		return root;
	}

}

class Node{
	public int num;
	public int sum;
	public Node left;
	public Node right;
	public List<Integer> nodeList = new ArrayList<Integer>();
	
	public Node(int num){
		this.num = num;
	}
	
	public boolean isLeaf(){
		return ((null == this.right) && (null == this.left));
	}
	
	public void populateChild(){
		if (null != this.right){
			this.right.nodeList = new ArrayList<Integer>(this.nodeList);
			this.right.sum = this.sum;
		}
		if (null != this.left){
			this.left.nodeList = new ArrayList<Integer>(this.nodeList);
			this.left.sum = this.sum;
		}
	}
}
