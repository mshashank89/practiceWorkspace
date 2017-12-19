package ds.graph;

import java.util.LinkedList;
import java.util.ListIterator;


public class DirectedGraphIsReachable {
	
	private static class Graph{
		LinkedList<Integer> arr[];
		int v;
		
		public Graph(int v){
			this.v = v;
			arr = new LinkedList[v];
			for (int i=0;i<v;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}
		
		/**
		 * Directed graph
		 * @param s
		 * @param d
		 */
		public void add(int s, int d){
			arr[s].add(d);
		}
		
		public boolean isReachable(int s, int d){
			boolean visited[] = new boolean[v];
			visited[s] = true;
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.push(s);
			while(queue.size() != 0){
				s = queue.poll();
				ListIterator<Integer> it = arr[s].listIterator();
				while(it.hasNext()){
					int n = it.next();
					if (n == d){
						return true;
					}
					if (!visited[n]){
						visited[n] = true;
						queue.push(n);
					}
				}
			}
			
			return false;
		}
	}

	public static void main(String[] args) {
		
		/*
			0------->1--------->2
					 |         |
					 |         |
					 V		   V
			5<-------4-------->3


		 */
		
		Graph g = new Graph(6);
		g.add(0, 1);
//		g.add(0, 5);
		g.add(1, 2);
		g.add(2, 3);
		g.add(4, 3);
		g.add(4, 5);
		g.add(1, 4);
		
		boolean isReachable = g.isReachable(0, 5);
		System.out.println(isReachable?"Reachable" : "Not reachable");
		isReachable = g.isReachable(1, 0);
		System.out.println(isReachable?"Reachable" : "Not reachable");
		isReachable = g.isReachable(2, 3);
		System.out.println(isReachable?"Reachable" : "Not reachable");
	}

}
