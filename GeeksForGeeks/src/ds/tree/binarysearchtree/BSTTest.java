package ds.tree.binarysearchtree;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.printInOrder();
		
		bst.insert(5);
		bst.insert(3);
		bst.insert(1);
		bst.insert(2);
		bst.insert(4);
		bst.insert(10);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		bst.insert(11);
		bst.insert(13);
		bst.insert(12);
		bst.insert(15);
		bst.insert(16);
		bst.insert(14);
		
		
		bst.printInOrder();
		bst.printLevelOrder();
		
		
//		bst.delete(11);
		
		bst.mirror();
		System.out.println("After mirror: ");
		bst.printLevelOrder();
		bst.mirror();
		System.out.println("After re-mirror: ");
		bst.printLevelOrder();
		
		int kSmallest = bst.findkSmallest(3);
		System.out.println("Kth smallest number in the BST is : " + kSmallest);
		
		bst.inorderWithoutRecursion();
	}

}
