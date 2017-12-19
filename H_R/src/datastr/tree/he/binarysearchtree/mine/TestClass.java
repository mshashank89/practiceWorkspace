package datastr.tree.he.binarysearchtree.mine;
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

//import for Scanner and other utility  classes
import java.util.*;
class Node {
    int key;
    Node left, right;
    public Node (int item){
        key = item;
        left = right = null;
    }
}
    
class BST{
    Node root;
    public BST(){
        root = null;
    }
    
    public int findMax(int x, int y){
        //find LCA

    	
    	Integer[] xPath = findPathFromXtoRoot(x);
        Integer[] yPath = findPathFromXtoRoot(y);
        
        Integer[] lca = findLCA(xPath, yPath);
        
        System.out.println("LCA : " + lca[0]);
        int max = 0;
        for (int i = lca[1];i<xPath.length;i++){
            max = (max > xPath[i]) ? max : xPath[i];
        }
        
        for (int i = lca[1];i<yPath.length;i++){
            max = (max > yPath[i]) ? max : yPath[i];
        }
        
        return max;
    }
    
    private Integer[] findPathFromXtoRoot(int x){
        List<Integer> list = new ArrayList<Integer>();
        
        Node focusNode = root;
        while(focusNode != null){
            list.add(focusNode.key);
            if (focusNode.key >= x){
                focusNode = focusNode.left;
            }
            else if (focusNode.key < x){
                focusNode = focusNode.right;
            }
        }
        list.add(x);
        return list.toArray(new Integer[list.size()]);
        
    }
    
    private Integer[] findLCA(Integer[] xPath, Integer[] yPath){
        Integer[] lca = {0, 0};
        
        int i=0;
        while (xPath[i] == (yPath[i])){
            lca[0] = xPath[i];
            lca[1] = i;
            i++;
        }
        /*int minPath = Math.min(xPath.length,yPath.length);
		for(i = 0; i < minPath; i++){
			if(!xPath[i].equals(yPath[i])){
				break;
			}
			lca[0] = xPath[i];
			lca[1] = i;
		}*/
        System.out.println("I = " + i);
        return lca;
    }
    
    public long[] findLCA(Long[] xPath, Long[] yPath){
		long result[] = {0,0};
		int minPath = Math.min(xPath.length,yPath.length);
		for(int i = 0; i < minPath; i++){
			if(!xPath[i].equals(yPath[i])){
				break;
			}
			result[0] = xPath[i];
			result[1] = i;
		}
		System.out.println("LCA : " + result[0]);
		return result;
	}
    
    public void createTree(int[] a){
        for (int i : a){
            root = add(root, i);
        }
    }
    
    private Node add(Node root, int item){
        if (root == null){
            Node node = new Node(item);
            return node;
        }
        
        if (root.key > item){
            root.left = add(root.left, item);
            
        }
        if (root.key < item){
            root.right = add(root.right, item);
        }
        
        return root;
    }
    
    /*public int findMax(int from1, int to1){
        int from = (from1 <= to1) ? from1 : to1;
        int to = (from1 > to1) ? from1: to1;
        return findMax(root, from, to, from);
    }*/
    
    
}
	

class TestClass {
    

	private static Print p = new Print();
	
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] a = new int[t];
        BST bst = new BST();
    
        for (int i = 0; i < t; i++) {
            int item = s.nextInt();
            // bst.add(item);
            a[i] = item;
        }
        
        bst.createTree(a);
        
        int x = s.nextInt();
        int y = s.nextInt();
        
        int max = bst.findMax(x, y);
        // int max = y;
        
        p.println(max);
        
        
        p.close();
    }
    
    
    static class Print {
 
        private final BufferedWriter bw;
 
        public Print() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
 
        public void print(String str) throws IOException {
            bw.append(str);
        }
        
        public void print(int val) throws IOException {
            bw.append(String.valueOf(val));
        }
        
        public void println(int val) throws IOException {
            print(val);
            bw.append("\n");
        }
        public void println(String str) throws IOException {
            print(str);
            bw.append("\n");
        }
        
        public void println() throws IOException {
            bw.append("\n");
        }
 
        public void close() throws IOException {
            bw.close();
        }
    }
}
