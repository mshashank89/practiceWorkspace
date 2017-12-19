package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DetectCycleInGraph {
	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	private static class Graph{
		LinkedList<Integer> arr[];
		int v;
		
		Graph(int v){
			this.v = v;
			arr = new LinkedList[v];
			for (int i=0;i<v;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}
		
		public void add(int src, int dest){
			arr[src].add(dest);
			arr[dest].add(src);
		}

		
		
		public boolean checkCycle(){
			boolean hasCycle = false;
			int[] visited = new int[v];
			for (int i=0;i<v;i++){
				visited[i] = WHITE;
			}
			checkCycleUtil(0, visited, hasCycle);
			return hasCycle;
		}
/*
 * 0 - unvisited
 * 1 - visiting
 * 2 - visited
 */
		private void checkCycleUtil(int i, int[] visited, boolean hasCycle) {
			visited[i] = BLACK;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.push(i);
			
			while(queue.size() != 0){
				int s = queue.poll();
//				System.out.println(s);
				Iterator<Integer> it = arr[s].listIterator();
				while(it.hasNext()){
					int n = it.next();
					if (visited[n] == BLACK){
						hasCycle = true;
						System.out.println("Cycle present");
					}
					if (visited[n] != WHITE){
						visited[n] = BLACK;
						queue.push(n);
					}
				}
			}
			
		}
		
		public void BFS(){
			boolean visited[] = new boolean[v];
			visited[0] = true;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.push(0);
			while(queue.size() != 0){
				int s = queue.poll();
				System.out.println(s);
				Iterator<Integer> it = arr[s].listIterator();
				while(it.hasNext()){
					int n = it.next();
					
					if (!visited[n]){
						visited[n] = true;
						queue.push(n);
					}
					
				}
			}
		}
		
		public boolean hasCycle(){
			int s = 0;
			boolean visited[] = new boolean[v];
			return hasCycleUtil(s, visited, -1);
		}

		private boolean hasCycleUtil(int s, boolean[] visited, int parent) {

			visited[s] = true;
			Iterator<Integer> it = arr[s].iterator();
			while(it.hasNext()){
				int n = it.next();
				
				if (!visited[n]){
					return hasCycleUtil(n, visited, s);
				}
				else if (n != parent){
					return true; //cycle detected -- n is already visited and is not a parent
				}
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.add(0, 1);
		g.add(0, 5);
		g.add(1, 2);
		g.add(1, 4);
		g.add(2, 3);
		g.add(3, 4);
//		g.add(5, 4);
		
		/*if(g.detectCycle()){
			System.out.println("cycle present");
		}
		else{
			System.out.println("no cycle");
		}*/
		g.BFS();
		System.out.println("end of bfs");
		/*if(g.checkCycle()){
			System.out.println("cycle present");
		}
		else{
			System.out.println("no cycle");
		}*/
		
		if(g.hasCycle()){
			System.out.println("cycle present");
		}
		else{
			System.out.println("no cycle");
		}
	}

}