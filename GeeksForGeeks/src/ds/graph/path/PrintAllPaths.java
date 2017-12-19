package ds.graph.path;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class PrintAllPaths {

	private static class Graph{
		LinkedList<Integer> arr[];
		int v;
		
		public Graph(int v){
			this.v = v;
			arr = new LinkedList[v];
			for(int i=0;i<v;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}
		
		public void add(int s, int d){
			arr[s].add(d);
			arr[d].add(s);
		}
		
		public void printAllPaths(int s, int d){
			boolean visited[] = new boolean[v];
//			ArrayList<Integer> path = new ArrayList<Integer>();
			Stack<Integer> path = new Stack<Integer>();
			int pathIndex = 0;
			printAllPathsUtil(s, d, visited, path, pathIndex);
		}

		private void printAllPathsUtil(int s, int d, boolean[] visited,
				Stack<Integer> path, int pathIndex) {
			visited[s] = true;
//			path.add(pathIndex, s);
			path.push(s);
			pathIndex++;
			
			if (s == d){
				for (int i : path){
					System.out.print(i + "  ");
				}
				System.out.println();
			}
			else {
				Iterator<Integer> it = arr[s].iterator();
				while(it.hasNext()){
					int n = it.next();
					if (!visited[n]){
						visited[n] = true;
						printAllPathsUtil(n, d, visited, path, pathIndex);
					}
				}
			}
			
//			path.remove(--pathIndex);
			path.pop();
			visited[s] = false;
			
		}
	}
	public static void main(String[] args) {
		
		/*
		 *           +------------------+
					 ^                  |
					 |        			|
					 |         			|
			0------->1-------->2		|			 
					 |         |		|			
					 |         |        |
					 |         |        |
					 V		   V        |
			5<-------4<--------3<-------+


		 */
		
		Graph g = new Graph(6);
		g.add(0, 1);
		g.add(0, 5);
		g.add(1, 2);
		g.add(1, 3);
		g.add(2, 3);
		g.add(3, 4);
		g.add(4, 5);
		g.add(1, 4);
		
		g.printAllPaths(0, 5);
		System.out.println();
		g.printAllPaths(2, 5);
		System.out.println();
		g.printAllPaths(3, 4);
		System.out.println();
		
		/*
		
		+-------
		+------->2
		||       |
		V|       V 
		0------->1
		|        |
		|        V
		+------->3
				 


	 */
		g = null;
		g = new Graph(6);
		g.add(0, 1);
	    g.add(0, 2);
	    g.add(0, 3);
	    g.add(2, 0);
	    g.add(2, 1);
	    g.add(1, 3);
	    g.printAllPaths(2, 3);
	}

}
