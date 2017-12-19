package ds.tree.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		System.out.println("InOrder Traversal : ");
		bt.inOrderTraversal();
		System.out.println("PreOrder Traversal : ");
		bt.preOrderTraversal();
		System.out.println("PostOrder Traversal : ");
		bt.postOrderTraversal();
		
		System.out.println("Order Level Traversal : ");
		bt.orderLevelTraversal();

		System.out.println("Print only the leaf nodes");
		bt.printLeaves();
		
		System.out.println("Print non leaf nodes");
		bt.printNonLeaves();
		
		System.out.println("Size of Tree: ");
		bt.printSizeOfTree();
		
		
		BinaryTree2 bt2 = new BinaryTree2();
		
		System.out.println("Left View of the tree");
		bt2.printLeftView();
		
		System.out.println("Right View of the tree");
		bt2.printRightView();
	}

}
