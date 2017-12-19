package graphs;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalMinSpanningTreeTest {

	public static class Edge{
		int weight;
		//nodes at either ends
		int i;
		int j;
		
		public Edge(int i, int j, int weight) {
			this.i = i;
			this.j = j;
			this.weight = weight;
		}

		static void foo(){
			
		}
		
		public String toString(){
			return "[ " + weight + " , i:" + i + " , j:" + j + " ]"; 
		}
	}
	// graph with a cycle
/*	private static int[][] adjacencyMatrix = { 
			{ 0, 4, 0, 0, 0, 0, 0, 1, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
			{ 0, 8, 0, 7, 0, 40, 0, 0, 2 },
			{ 0, 0, 7, 0, 90, 14, 0, 0, 0 },
			{ 0, 0, 0, 90, 0, 1, 0, 0, 0 },
			{ 0, 0, 40, 0, 1, 0, 2, 0, 0 },
			{ 0, 0, 0, 14, 0, 2, 0, 1, 6 },
			{ 1, 11, 0, 0, 0, 0, 1, 0, 7 }, 
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };*/
	
	private static int[][] adjacencyMatrix = {
		   {0, 4, 0, 0, 0, 0, 0, 8, 0},
		   {4, 0, 8, 0, 0, 0, 0, 11, 0},
		   {0, 8, 0, 7, 0, 4, 0, 0, 2},
		   {0, 0, 7, 0, 9, 14, 0, 0, 0},
		   {0, 0, 0, 9, 0, 10, 0, 0, 0},
		   {0, 0, 4, 0, 10, 0, 2, 0, 0},
		   {0, 0, 0, 14, 0, 2, 0, 1, 6},
		   {8, 11, 0, 0, 0, 0, 1, 0, 7},
		   {0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		
	private static int[][]MST = { 
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
	
	Edge []edgeArray = new Edge[adjacencyMatrix.length*adjacencyMatrix.length/2];
	
	
	/**
	 * this is required to keep track of all the edges to check if the newly added edge forms a cycle or not in the current MST
	 */
	static int []parent = new int[adjacencyMatrix.length];
	
	static{
		for (int i=0;i<adjacencyMatrix.length;i++){
			parent[i] = -1;
		}
	}
		
	public static void main(String[] args) {
		
		KruskalMinSpanningTreeTest k = new KruskalMinSpanningTreeTest();
		
		k.findMST();
	}



	private void findMST() {

		readAllEdges();

		//sort all the edges based on weight
		sortEdges();
		
		//for each edge in the sorted edgeList, check if the edge forms a cycle with the currently formed MST
		for (Edge e : edgeArray){
			if (null == e) {
				continue;
			}
			
			if (!isCycle(e)){
				MST[e.i][e.j] = e.weight;
				MST[e.j][e.i] = e.weight;
			}
		}
		
		//print the MST
		
		for (int i=0;i<MST.length;i++){
			for(int j=0;j<MST.length;j++){
				System.out.print(MST[i][j] + " ");
			}
			System.out.println();
		}
	}



	/**
	 * This method checks if a cycle is formed when a new edge is added into the MST.
	 * 
	 * This is done by keeping track of all the edges in a 1D array
	 * 
	 * http://www.geeksforgeeks.org/union-find/
	 *
	 *
		We can keep track of the subsets in a 1D array, lets call it parent[].
		
		Let us consider the following graph:
		
		        0
		        | \
		        |  \
		        1---2
		For each edge, make subsets using both the vertices of the edge. If both the vertices are in the same subset, a cycle is found.
		
		Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).
		
		0   1   2
		-1 -1  -1 
		Now process all edges one by one.
		
		Edge 0-1: Find the subsets in which vertices 0 and 1 are. Since they are in different subsets, we take the union of them. For taking the union, either make node 0 as parent of node 1 or vice-versa.
		
		0   1   2    <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})
		1  -1  -1
		Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.
		
		0   1   2    <----- 2 is made parent of 1 (2 is now representative of subset {0, 1, 2})
		1   2  -1
		Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this edge forms a cycle.
	 * @param e
	 * @return
	 */
	private boolean isCycle(Edge e) {

		if (parent[e.i] != -1 && parent[e.j] != -1){
			//if both the nodes are already a parent to some other node, 
			//then adding an edge joining these 2 nodes will form a cycle.
			return true;
		}
		if (parent[e.i] == -1){
			
			//always make j as the parent of node i. (Read "parent of i is j") 
			parent[e.i]= e.j;
			return false;
		}
		
		return false;
	}



	/**
	 * Sort edges based on the weights
	 */
	private void sortEdges() {
		
		
		Comparator<Edge> c = new Comparator<KruskalMinSpanningTreeTest.Edge>() {
			
			@Override
			public int compare(Edge o1, Edge o2) {
				
				if (null == o2 && null != o1) return 1;
				if (null == o1 && null != o2) return -1;
				if (null == o1 && null == o2) return 0;
				if (o1.weight > o2.weight){
					return 1;
				}
				if (o1.weight < o2.weight){
					return -1;
				}
				return 0;
			}
		};
		
		
		Arrays.sort(edgeArray, c);

		System.out.println("**********list*********");
		for (Edge e : edgeArray){
			if (null == e) continue;
			System.out.println(e);
		}
		
	}



	/**
	 * read just the upper triangle in the matrix to get all the edges.
	 */
	private void readAllEdges() {
		int k=0;
		//read the upper triangle of the matrix into an array
		for (int i=0;i<adjacencyMatrix.length;i++){
			for (int j=0;j<i;j++){
				if (0 != adjacencyMatrix[i][j]){
					Edge e = new Edge(i,j,adjacencyMatrix[i][j]);
					edgeArray[k++] = e;
				}
			}
		}
	}

}
