package ds.tree.binarytree;


public class BinaryTree {
	
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
	public BinaryTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
/*
                    1
                 
             /             \  
           2                 3  
        /     \           /     \
      4        5        6         7
     / \     /   \    /   \     /   \
    8   9   10   11  12   13   14   15
    
    
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
	
	
	private void inOrder(Node root){
		if (null == root) return;
		
		inOrder(root.left);
		System.out.print(root.data + "  ");
		inOrder(root.right);
	}
	
	private void preOrder(Node root){
		if (null == root) return;
		
		System.out.print(root.data + "  ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private void postOrder(Node root){
		if (null == root) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + "  ");
	}

	public void orderLevelTraversal(){
		int height = height(root);
		
		for (int i=1;i<=height;i++){
			printGivenLevel(root, i);
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	public void inOrderTraversal(){
		inOrder(root);
		System.out.println();
	}
	
	public void preOrderTraversal(){
		preOrder(root);
		System.out.println();
	}
	
	public void postOrderTraversal(){
		postOrder(root);
		System.out.println();
	}
	
	
	public void printLeaves(){
		printLeaves(root);
		System.out.println();
	}
	
	public void printNonLeaves(){
		printNonLeaves(root);
		System.out.println();
	}
	
	private void printNonLeaves(Node root) {
		if (root == null) return;
		if (root.left == null && root.right == null) return;
		else{
			System.out.print(root.data + "  ");
			printNonLeaves(root.left);
			printNonLeaves(root.right);
		}
		
		
	}

	
	private void printLeaves(Node root){
		if (null == root) return;
		if (null == root.left && null == root.right){
			System.out.print(root.data + "  ");
		}
		
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	
	public void printSizeOfTree(){
		
		System.out.println(sizeOfTree(root));
	}
	
	private int sizeOfTree(Node root){
		if (root == null) return 0;
		
		return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
	}
	
	
}
