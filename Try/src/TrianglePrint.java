
public class TrianglePrint {

	public static void main(String[] args) {

		int n=5;
		
		int[][] adjacencyMatrix = { 
			{ 0, 4, 0, 0, 0, 0, 0, 1, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
			{ 0, 8, 0, 7, 0, 40, 0, 0, 2 },
			{ 0, 0, 7, 0, 90, 14, 0, 0, 0 },
			{ 0, 0, 0, 90, 0, 1, 0, 0, 0 },
			{ 0, 0, 40, 0, 1, 0, 2, 0, 0 },
			{ 0, 0, 0, 14, 0, 2, 0, 1, 6 },
			{ 1, 11, 0, 0, 0, 0, 1, 0, 7 }, 
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		
		
		System.out.println("*******Upper Triangle*******");
		//upper triangle
		for (int i=0;i<adjacencyMatrix.length;i++){
			for (int j=0;j<adjacencyMatrix.length;j++){
				if(j<i){
					System.out.print("  ");
				}
				else{
					System.out.print(adjacencyMatrix[j][i] + " ");
				}
			}
			System.out.println();
		}
		
		//lower triangle
		for (int i=0;i<adjacencyMatrix.length;i++){
			for (int j=0;j<i;j++){
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("*******Upper Triangle*******");
		for (int i=0;i<adjacencyMatrix.length;i++){
			for (int j=0;j<adjacencyMatrix.length;j++){
				if(adjacencyMatrix.length-j-1<i){
					System.out.print("  ");
				}
				else{
					System.out.print(adjacencyMatrix[j][i] + " ");
				}
			}
			System.out.println();
		}
		
		System.out.println("*******Upper Triangle*******");
		for (int i=0;i<adjacencyMatrix.length;i++){
			for (int j=0;j<adjacencyMatrix.length;j++){
				if(adjacencyMatrix.length-j-1>i){
					System.out.print("  ");
				}
				else{
					System.out.print(adjacencyMatrix[j][i] + " ");
				}
			}
			System.out.println();
		}
	}

}
