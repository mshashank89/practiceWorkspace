package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class PathFromAToB {

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

		public void findPath(int src, int dest) {}
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
		// g.add(0, 5);
		g.add(1, 2);
		g.add(1, 4);
		g.add(2, 3);
		g.add(3, 4);
		g.add(5, 4);
		
		g.findPath(0, 5);
		g.findPath(2, 0);
	}

}
