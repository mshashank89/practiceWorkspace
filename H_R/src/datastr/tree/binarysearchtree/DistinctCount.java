package datastr.tree.binarysearchtree;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;

class Node{
    int key;
    Node left;
    Node right;
    
    Node(int item){
        key = item;
        left = right = null;
    }
}

class BST{
    private Node root;
    private int count;
    
    public BST(){
        root = null;
        count = 0;
    }
    
    public void add(int item){
        root = add(root, item, true);
    }
    
    private Node add(Node root, int item, boolean flag){
        
        if (root == null){
            Node node = new Node(item);
            if (flag) count++;
            return node;
        }
        if (root.key < item){
            root.left = add(root.left, item, true);
        } 
        else if(root.key > item){
        	
            root.right = add(root.right, item, true);
        } 
            
        else if (root.key == item) {
            root.left = add(root.left, item, false);
        }
        
        return root;
    }
    
    public int getCount(){
        return count;
    }
    
}

class DistinctCount {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int x = s.nextInt();
            BST bst = new BST();
            for (int j=0;j<n;j++){
                int num = s.nextInt(); 
                bst.add(num);
                // System.out.println("here " + num);
            }
            String output = "";
            if (bst.getCount() < x){
                output = "Bad";
            }
            else if (bst.getCount() > x){
                output = "Average";
            }
            else {
                output = "Good";
            }
            System.out.println(bst.getCount() + " " + x + " " + output);
            // System.out.println(output);
            
        }
        

        // System.out.println("Hello World!");
    }
}

