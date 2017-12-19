package datastr.tree.he.binarysearchtree;
import java.util.*;
import java.io.*;
 
//Finds the max value that lie in the path between any two node X and Y
//Does this by first finding the LCA(Lowest Common Ancestor)
public class TestClass{
	public static void main(String[] args) throws IOException{
		Reader r = new Reader();	
		int n = r.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++){
			arr[i] = r.nextLong();
		}
 
		BST myTree = new BST();
		myTree.createTree(arr);
		//BST.inOrderTraversal(myTree.root);
		//System.out.println();
 
		long x = r.nextLong();
		long y = r.nextLong();
 
		Long[] xPath = (Long[])myTree.pathToXFromRoot(x);
		Long[] yPath = (Long[])myTree.pathToXFromRoot(y);
		//for(int i = 0; i < xPath.length; i++) System.out.print(xPath[i]+" ");
		//System.out.println();
		//for(int i = 0; i < yPath.length; i++) System.out.print(yPath[i]+" ");
//from the two paths found above, the following method calculates the LowestCommonAncestor
		long[] lca = myTree.findLCA(xPath,yPath);
 
		long max = lca[0];
		for(int i = (int)lca[1]+1; i < xPath.length; i++){
			if(xPath[i] > max) max = xPath[i];
		}
		for(int i = (int)lca[1]+1; i < yPath.length; i++){
			if(yPath[i] > max) max = yPath[i];
		}
		System.out.println(max);
	}
	static class BST{
		Node root;
 		//from the two paths found above, the following method calculates the LowestCommonAncestor
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
		public Long[] pathToXFromRoot(long x){
			ArrayList<Long> arr = new ArrayList<Long>();
			Node focusNode = root;
			while(focusNode.val != x){
				arr.add(focusNode.val);
				if(x >= focusNode.val){
					focusNode = focusNode.rChild;
				}
				else{
					focusNode = focusNode.lChild;
				}		
			}
			arr.add(x);
			return arr.toArray(new Long[arr.size()]);
		}
		private static void inOrderTraversal(Node focusNode){
			if(focusNode != null){
				inOrderTraversal(focusNode.lChild);
				System.out.print(focusNode.val+" ");
				inOrderTraversal(focusNode.rChild);
			}
		}
		public void addNode(long val){
			Node newNode = new Node(val);
			Node focusNode = root;
			Node parent;
			if(focusNode == null){
				root = newNode;
				return;
			}
			while(true){
				parent = focusNode;
				if(val >= focusNode.val){
					focusNode = focusNode.rChild;
					if(focusNode == null){
						parent.rChild = newNode;
						return;
					}
				}
				else{
					focusNode = focusNode.lChild;
					if(focusNode == null){
						parent.lChild = newNode;
						return;
					}
				}
			}
 
		}
		public void createTree(long[] arr){
			for(int i = 0; i < arr.length; i++){
				addNode(arr[i]);
			}
		}
	}
	static class Node{
		long val;
		Node lChild;
		Node rChild;
		public Node(long val){
			this.val = val;
		}
	}
	static class Reader{
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
