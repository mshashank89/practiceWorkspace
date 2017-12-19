package graphs;

/**
 * class to check if the graph contains a cycle or not
 * @author smanjunath
 *
 */
public class GraphTest {

	private static int vertexCount = 5;
	
	private static boolean isCycle = false;
	//graph with a cycle
	private static int [][]adjacencyMatrix = {
									   {0,0,0,1,0},
									   {0,0,0,1,1},
									   {0,0,0,0,1},
									   {1,1,0,0,1},
									   {0,1,1,1,0}
									  };
	
	//graph without a cycle
	/*private static int [][]adjacencyMatrix = {
									   {0,0,0,1,0},
									   {0,0,0,1,1},
									   {0,0,0,0,1},
									   {1,1,0,0,0},
									   {0,1,1,0,0}
									  };*/
	
	enum VisitState {
		WHITE, GREY, BLACK;
	}
	
	//white - unvisited
	//grey - current node
	//black - visited node
			
	public static void main(String[] args) {

		//make all the nodes as white initially
		VisitState[] visitMatrix = new VisitState[vertexCount];
		for (int i=0;i<vertexCount;i++){
			visitMatrix[i] = VisitState.WHITE;
		}
		
//		runDFS(0,visitMatrix);
		DFS(0,visitMatrix);
		if (!isCycle){
			System.out.println("The graph does not contain a cycle");
		}
	}
	
	
	public static void DFS(int u, VisitState[] visitMatrix){
		
		visitMatrix[u] = VisitState.GREY;
		System.out.println(u);
		for (int v=0;v<vertexCount;v++){
			
			if (isEdge(u,v) && visitMatrix[v] == VisitState.WHITE){
				
				
				DFS(v, visitMatrix);
			}
		}
		
		visitMatrix[u] = VisitState.BLACK;
		
	}
	
	public static void runDFS(int u, VisitState[] visitMatrix){
		
		visitMatrix[u] = VisitState.GREY;
		
		for (int v=0;v<vertexCount;v++){
			
			if (isEdge(u,v) && visitMatrix[v] != VisitState.GREY){
				
				if (visitMatrix[v] == VisitState.BLACK){
					isCycle = true;
					System.out.println("The graph Contains a cycle : " + (u+1) + ", " + (v+1));
					return;
				}
				runDFS(v, visitMatrix);
			}
		}
		
		visitMatrix[u] = VisitState.BLACK;
		
	}

	private static boolean isEdge(int u, int v) {

		if (adjacencyMatrix[u][v] != 0 && u<vertexCount && v <vertexCount){
			return true;
		}
		return false;
	}
}


