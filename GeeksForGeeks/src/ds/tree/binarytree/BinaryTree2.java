package ds.tree.binarytree;

import ds.tree.binarytree.BinaryTree.Node;

public class BinaryTree2 {

	
	private Node root;
	class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int item){
			this.data = item;
			left = right = null;
		}
	}	
	
	
	/**
	 * Constructor
	 */
	public BinaryTree2(){
		root = new Node(1);
//		root.left = new Node(2);
		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
//		root.right.right.right = new Node(15);
		
/*
                    1
                 
             /             \  
           2                 3  
          /    \           /     \
        4       5        6         7
      /   \   /   \    /   \     /   \
                 11  12   13   14   15
    
    
*/
	}
	
	
	
	
	public int height(Node root){
		if (null == root){
			return 0;
		}
		else{
			int lHeight = height(root.left);
			int rHeight = height(root.right);
			
			if (lHeight > rHeight){
				return lHeight + 1;
			}
			else{
				return rHeight + 1;
			}
		}
		
	}
	
	
	private void printGivenLevel(Node root, int level){
		if (root == null){
			return;
		}
		
		if  (level == 1){
			System.out.print(root.data + "  ");
		}
		else if (level > 1){
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	
	
	public void orderLevelTraversal(){
		int height = height(root);
		
		for (int i=1;i<=height;i++){
			printGivenLevel(root, i);
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void printLeftView(){
		printLeftView(root);
		System.out.println();
	}
	
	/**
	 * printGivenlevel() prints both the children of a node.
	 * 			printGivenLevel(root.left, level - 1);
	 *  		printGivenLevel(root.right, level - 1);
	 *  
	 * print only one child
	 * Since we need only the left View of a tree, We print only the child that is visible from the left side:
	 * 			if (left child is present)
	 * 				print(left child data)
	 * 			else
	 * 				print(right child data)
	 * 
	 * 
	 * 
	 */
	private void levelLeftViewPrint(Node root, int level){
		if (null == root) return;
		
		if (level == 1){ 
			System.out.print(root.data + "  ");
		}
		else if (level > 1){
			if (root.left != null){ // print only 1 child per level
				levelLeftViewPrint(root.left, level - 1);
			}
			else{
				levelLeftViewPrint(root.right, level - 1);
			}
		}
	}


	private void printLeftView(Node root) {
		
		int height = height(root);
		
		for (int i = 1 ; i <= height ; i++){
			levelLeftViewPrint(root, i);
		}
	}
	
	private void levelRightViewPrint(Node root, int level){
		if (null == root) return;
		
		if (level == 1){ 
			System.out.print(root.data + "  ");
		}
		else if (level > 1){
			if (root.right != null){
				levelRightViewPrint(root.right, level - 1);
			}
			else{
				levelRightViewPrint(root.left, level - 1);
			}
		}
	}

	public void printRightView(){
		printRightView(root);
		System.out.println();
	}

	private void printRightView(Node root) {
		
		int height = height(root);
		
		for (int i = 1 ; i <= height ; i++){
			levelRightViewPrint(root, i);
		}
	}
	
	
	
	

}
