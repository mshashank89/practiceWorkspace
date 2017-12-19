package graphs;

import graphs.ShortestPathTest.VisitState;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathTest {

	private static int vertexCount = 8;

	private static int source = 1;
	private static int dest = 5;

	// graph with a cycle
	private static int[][] adjacencyMatrix = { 
			{ 0, 4, 0, 0, 0, 0, 0, 1, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
			{ 0, 8, 0, 7, 0, 40, 0, 0, 2 },
			{ 0, 0, 7, 0, 90, 14, 0, 0, 0 },
			{ 0, 0, 0, 90, 0, 1, 0, 0, 0 },
			{ 0, 0, 40, 0, 1, 0, 2, 0, 0 },
			{ 0, 0, 0, 14, 0, 2, 0, 1, 6 },
			{ 1, 11, 0, 0, 0, 0, 1, 0, 7 }, 
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

	public enum VisitState {
		WHITE, GREY, BLACK;
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node.foo();

		ShortestPathTest test = new ShortestPathTest();
		test.dijikstra();
//		dijikstra();

	}

	private void dijikstra() {

		// make all the nodes as white initially
		Node[] nodeMatrix = initializeNodeMatrix(vertexCount);

		nodeMatrix[source].path.add(source);
		nodeMatrix[source].currentWeight = 0;
		runDFS(source, nodeMatrix);

		
		System.out.println("Shortest path : ");
		for (int nodePath : nodeMatrix[dest].path) {
			System.out.print(nodePath + " -> ");
		}
		System.out.println();
		for (int nodeWeight : nodeMatrix[dest].weightPath) {
			System.out.print(nodeWeight + " + ");
		}
	}

	private Node[] initializeNodeMatrix(int size) {

		Node[] nodeMatrix = new Node[size];
		
		for (int i=0;i<size;i++){
			nodeMatrix[i] = new Node();
		}
		return nodeMatrix;
	}

	public static void runDFS(int u, Node[] nodeMatrix) {

		nodeMatrix[u].visitState = VisitState.GREY;

		for (int v = 0; v < vertexCount; v++) {

			if (isEdge(u, v) && nodeMatrix[v].visitState != VisitState.GREY) {

				if ((nodeMatrix[u].currentWeight + adjacencyMatrix[u][v]) < nodeMatrix[v].currentWeight) {

					// if the distance to the node v from the source is less via
					// the node u, then update it's current weight
					nodeMatrix[v].currentWeight = nodeMatrix[u].currentWeight
							+ adjacencyMatrix[u][v];

					// add the path from the source till u
					nodeMatrix[v].path.clear();
					nodeMatrix[v].path.addAll(nodeMatrix[u].path);
					// add the node v into the path
					nodeMatrix[v].path.add(v);

					// add the weightlist into the weight path
					nodeMatrix[v].weightPath.clear();
					nodeMatrix[v].weightPath.addAll(nodeMatrix[u].weightPath);
					// add the current weight of node v into the path
//					nodeMatrix[v].weightPath.add(nodeMatrix[v].currentWeight);
					nodeMatrix[v].weightPath.add(adjacencyMatrix[u][v]);
				}
				runDFS(v, nodeMatrix);
			}
		}

		nodeMatrix[u].visitState = VisitState.BLACK;

	}

	private static boolean isEdge(int u, int v) {

		if (adjacencyMatrix[u][v] != 0 && u < vertexCount && v < vertexCount) {
			return true;
		}
		return false;
	}

}

//each node
class Node {
		int currentWeight = Integer.MAX_VALUE;
		VisitState visitState = VisitState.WHITE;
		List<Integer> path = new LinkedList<Integer>();
		List<Integer> weightPath = new LinkedList<Integer>();
		
		public static void foo(){
			
		}
		
		public Node(){
		}

	}