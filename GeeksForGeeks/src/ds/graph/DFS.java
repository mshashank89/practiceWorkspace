package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;


public class DFS {
	private static class Graph {
		LinkedList<Integer> arr[];
		int v;

		public Graph(int v) {
			this.v = v;
			arr = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				arr[i] = new LinkedList<Integer>();
			}
		}

		public void add(int src, int dest) {
			arr[src].add(dest);
			arr[dest].add(src);
		}
		
		public void DFS(int s){
			boolean visited[] = new boolean[v];
			visited[s] = true;
			Stack<Integer> stack = new Stack<Integer>();
			
			stack.push(s);
			while(stack.size() != 0){
				s = stack.pop();
				Iterator<Integer> it = arr[s].listIterator();
				System.out.print(s + "  ");
				while(it.hasNext()){
					int n = it.next();
					if (!visited[n]){
						visited[n] = true;
						stack.push(n);
					}
				}
			}
		}
		
		public void DFS2(int s){
			boolean visited[] = new boolean[v];
			
			System.out.println("DFS recursive: ");
			DFSRec(s, visited);
		}

		private void DFSRec(int s, boolean[] visited) {
			visited[s] = true;
			System.out.print(s + "  ");
			ListIterator<Integer> it = arr[s].listIterator();
			while(it.hasNext()){
				int n = it.next();
				if (!visited[n]){
					DFSRec(n, visited);
				}
			}
		}

		public static void main(String[] args) {
			
			/*
				0--------1---------2
						 |         |
						 |         |
				5--------4---------3


			 */
			
			Graph g = new Graph(6);
			g.add(0, 1);
//			g.add(0, 5);
			g.add(1, 2);
			g.add(2, 3);
			g.add(3, 4);
			g.add(5, 4);
			g.add(1, 4);
			
			g.DFS(0);
			g.DFS2(0);

		}

	}
}
