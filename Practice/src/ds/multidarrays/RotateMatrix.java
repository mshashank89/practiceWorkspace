package ds.multidarrays;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = populateMatrix(4, 4);
		printMatrix(matrix);

		System.out.println(" rotated ");
		matrix = rotateMatrixBy90Deg(matrix);
		printMatrix(matrix);
	}

	public static int[][] rotateMatrixBy90Deg(int[][] matrix) {
		System.out.println("##############   " + matrix.length + ", "
				+ matrix[0].length);
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i <= last; i++) {

				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return matrix;

	}

	private static int[][] populateMatrix(int x, int y) {
		int[][] matrix = new int[x][y];
		int count = 1;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[i][j] = count++;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {

		int x = matrix.length;
		int y = matrix[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(matrix[i][j] + "    ");
			}
			System.out.println();
		}

	}

}
