package ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {
	
	static class Graph{
		LinkedList<Integer>[] adjListArray;
		
		public Graph(int v){
			adjListArray = new LinkedList[v];

			
			for (int i=0;i<v;i++){
				adjListArray[i] = new LinkedList<Integer>();
			}
		}
		public void addEdge(int v1, int v2){
			adjListArray[v1].addFirst(v2);
			adjListArray[v2].addFirst(v1);
			
		}
	}

	public static void main(String[] args) {

	}

}
