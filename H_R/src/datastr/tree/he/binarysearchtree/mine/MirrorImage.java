package datastr.tree.he.binarysearchtree.mine;
/* IMPORTANT: Multiple classes and nested static classes are supported */

//uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class MirrorImage {
	
	private static class Node {
	    int val;
	    Node left,right;
	    
	    public Node(int val){
	        this.val = val;
	        left = right= null;
	    }
	}

	private static class BinaryTree{
	    Node root;
	    Map<Integer, Integer> map;
	    public BinaryTree(){
	        root = new Node(1);
	        map = new HashMap<Integer, Integer>();
	    }
	    
	    public void printLevelOrder(){
	        int height = height(root);
	        for (int i=1;i<=height;i++){
	            print(root, i);
	            System.out.println();
	        }
	    }
	    private void print(Node root, int level){
	        if ( root == null ) return;
	        if (level == 1) System.out.print(root.val + "  ");
	        else{
	            print(root.left, level -1);
	            print(root.right, level -1);
	        }
	    }
	    //0 - left
	    //1 = right
	    public void add(int parent, int val, int pos){
	        root = add(root, parent, val, pos);
	    }
	    
	    private Node add(Node root, int parent, int val, int pos){
	        if (root == null){
	            
	            return null;
	        }
	        if (root.val == parent){
	            Node node = new Node(val);
	            if (pos == 0){
	                root.left = node;
	            }
	            else{
	                root.right = node;
	            }
	        }
	        else {
	            root.left = add(root.left, parent, val, pos);
	            root.right = add(root.right, parent, val, pos);
	        }
	        
	        return root;
	    }
	    
	    private int height(Node root){
	        if (root == null) return 0;
	        
	        int lh = height(root.left);
	        int rh = height(root.right);
	        
	        int height = Math.max(lh,rh);
	        return height + 1;
	    }
	    
	    public void prepareLevelMap(){
	        
	        int height = height(root);
	        
	        for (int i=1;i<=height;i++){
	            addLevelToMap(root, i, i);
	        }
	    }
	    
	    private void addLevelToMap(Node root, int level, int curLevel){
	        if (root == null) return;
	        
	        if (curLevel == 1) map.put(root.val, level);
	        else{
	            addLevelToMap(root.left, level, curLevel-1);
	            addLevelToMap(root.right, level, curLevel-1);
	        }
	    }
	    
	    public int findMirror(int val){
	        int level = map.get(val);
	        return findMirror(root, level, val);
	        
	    }
	    
	    private int findMirror(Node root, int level, int val){
	        List<Integer> list = new ArrayList<Integer>();
	        updateList(root, level, list);
	        
	        int i=0;
	        for (i=0;i<list.size();i++){
	            if (list.get(i) == val){
	                break;
	            }
	        }
	        int fullListSize = pow(2, level -1);
	        int[] arr = new int[fullListSize];
	        for (int j=1;j<=fullListSize;j++){
	        	
	        	if (j<=list.size()){
	        		arr[j-1] = list.get(j-1);
	        	}
	        	else {
	        		arr[j-1] = -1;
	        	}
	        }
	        int mirror = arr[arr.length - i -1];
	        /*if (list.contains(list.get(fullListSize - 1 - i ))){
	            mirror = list.get(fullListSize - 1 - i);
	        }
	        else{
	            mirror = -1;
	        }*/
	        
	        return mirror;
	    }
	    public int pow(int num, int pow){
			int sq = 1;
			
			for (int i=0;i<pow;i++){
				sq = sq * num;
			}
			return sq;
		}

	    
	    private void updateList(Node root, int level, List list){
	        if (null == root) return;
	        
	        if (level == 1){
	            list.add(root.val);
	        }
	        else {
	            updateList(root.left, level - 1, list);
	            updateList(root.right, level - 1, list);
	        }
	        
	        return;
	    }
	}

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
        int N = s.nextInt();
        int q = s.nextInt();
        String str = s.nextLine();
        BinaryTree bt = new BinaryTree();
        
        for (int i = 0; i < N-1; i++) {
            String input = s.nextLine();
            System.out.println("Input: " + input);
            String[] inputArr = input.split(" ");
            int parent = Integer.parseInt(inputArr[0]);
            int val = Integer.parseInt(inputArr[1]);
            int pos = ("L".equals(inputArr[2]) ? 0 : 1);
            
            bt.add(parent, val, pos);
        
        }
        System.out.println("Before : ");
        bt.printLevelOrder();
        bt.prepareLevelMap();
        System.out.println("After : ");
        bt.printLevelOrder();
        
        for (int i=0;i<q;i++){
            int val = s.nextInt();
            int mirror = bt.findMirror(val);
            
            System.out.println(mirror);
        }
        

    }
}
