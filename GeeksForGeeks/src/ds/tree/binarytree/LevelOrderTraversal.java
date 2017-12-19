package ds.tree.binarytree;


public class LevelOrderTraversal {

	private static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value){
			this.value = value;
			left = right = null;
		}
	}
	
	private static class BinaryTree{
		Node root;
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
		
		public int findHeight(){
			return findHeight(root);
		}
		
		private int findHeight(Node root){
			if (root == null){
				return 0;
			}
			int lh = findHeight(root.left) + 1;
			int rh = findHeight(root.right) + 1;
			
			return (lh > rh)?lh : rh;
		}
		
		public void levelOrderTraversal(){
			int height = findHeight();
			
			for(int i=1;i<=height;i++){
				printlevel(root, i);
				System.out.println();
			}
			
		}
		
		public void spiraltraversal(){
			int height = findHeight();
			boolean flag = false;
			for (int i=1;i<=height;i++){
				printlevel(root,i,flag);
				flag = !flag;
				System.out.println();
			}
		}

		private void printlevel(Node root, int level, boolean flag) {
			if (root == null) return;
			if (level == 1){
				System.out.print(root.value + "  ");
			}
			else if (flag){
				printlevel(root.left, level-1, flag);
				printlevel(root.right, level-1, flag);
			}
			else{
				printlevel(root.right, level-1, flag);
				printlevel(root.left, level-1, flag);
			}
		}

		private void printlevel(Node root, int level) {
			if (root == null){
				return;
			}
			if (level == 1){
				System.out.print(root.value + "  ");
			}
			else{
				printlevel(root.left, level-1);
				printlevel(root.right, level-1);
			}
		}
	}
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		System.out.println("Tree height: " + bt.findHeight());
		
		System.out.println("Level order traversal: ");
		bt.levelOrderTraversal();

		System.out.println("Spiral traversal: ");
		bt.spiraltraversal();
	}

}
