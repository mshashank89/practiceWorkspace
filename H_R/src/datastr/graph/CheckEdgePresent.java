package datastr.graph;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;


class Graph{
    LinkedList<Integer> arr[];
    int v;
    
    public Graph(int v){
        this.v = v;
        arr = new LinkedList[v];
        for (int i=0;i<v;i++){
            arr[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int v1, int v2){
        arr[v1].add(v2);
        arr[v2].add(v1);
    }
    
    public boolean isEdge(int v1, int v2){
        boolean isedge = false;
        
        Iterator<Integer> it = arr[v1].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if (n == v2) {
                isedge = true;
                break;
            }
        }
        return isedge;
    }
    
    public void DFSIter(int s){
    	boolean visited[] = new boolean[v];
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	visited[s] = true;
    	stack.push(s);
    	while(stack.size() != 0){
    		s = stack.pop();
    		System.out.print(s + "  ");
    		
    		Iterator<Integer> it = arr[s].listIterator();
    		while (it.hasNext()){
    			int n = it.next();
    			if (!visited[n]){
    				visited[n] = true;
    				stack.push(n);
    			}
    		}
    	}
    }
    
    public void DFS(int s){
    	boolean visited[] = new boolean[v];
    	
    	DFSUtil(s, visited);
    }

	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + "  ");
		
		Iterator<Integer> it = arr[s].listIterator();
		
		while (it.hasNext()){
			int n = it.next();
			if (!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}
	
	
	public void checkCycle(){
    	boolean visited[] = new boolean[v];
    	System.out.println();
    	checkCycleUtil(0, visited);
    }

	private void checkCycleUtil(int s, boolean[] visited) {
		visited[s] = true;
//		System.out.print(s + " ");
		
		Iterator<Integer> it = arr[s].listIterator();
		
		while (it.hasNext()){
			int n = it.next();
			if (visited[n] && n!= s) {
				System.out.println("Cycle detected");
				break;
			}
			
			if (!visited[n]){
				checkCycleUtil(n, visited);
			}
		}
	}
}

class CheckEdgePresent {
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
        int n = s.nextInt();
        int m = s.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            
            graph.add(v1, v2);
            // System.out.println(v1 + " " + v2);
        }
//        int q = s.nextInt();
        int q = 0;
        for (int i=0;i<q;i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            
            if (graph.isEdge(v1, v2)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        
        
        graph.DFS(0);
        System.out.println("\niter: ");
        graph.DFSIter(0);
//        graph.checkCycle();

        // System.out.println("Hello World!");
    }
}
