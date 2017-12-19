package tree.array;

import java.util.Scanner;

public class Determinant {

	public static void main(String[] args) {

		System.out.println("Enter the size of the matrix");
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		
		int matrix[][] = new int[size][size];
		System.out.println("Enter " + size + " X " + size + " matrix");
		System.out.println("Enter " + size + " numbers separated by space");
		for (int i=0;i<size;i++){
			String inputStr = sc.nextLine();
			int j=0;
			for (String s : inputStr.split(" ")){
				matrix[i][j++] = Integer.parseInt(s);
			}
		}
		
		
		System.out.println("Determinant of ");
		printMatrix(matrix);
		System.out.println(determinant(matrix));
	}

	private static void printMatrix(int[][] matrix) {
		
		for (int i=0;i<matrix.length;i++){
			System.out.print("|");
			for (int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("|");
		}
	}

	private static int determinant(int[][] matrix) {
		
		int n = matrix.length;
		
		if (2 == n){
			
			return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
		}
		
		int determinant = 0;
		for (int i=0;i<n;i++){
			
			if (i % 2 == 0)
			{
				determinant += matrix[0][i] * determinant(getSubMatrix(matrix, getColumns(i, n)));
			}
			else
			{
				determinant -= matrix[0][i] * determinant(getSubMatrix(matrix, getColumns(i, n)));
			}
		}
		
		
		return determinant;
	}

	private static int[] getColumns(int i, int n) {

		int []columnArray = new int[n-1];
		
		int k=0;
		for (int j=0;j<n ;j++){
			
			if (j == i) continue;
			
			columnArray[k++] = j;
		}
		return columnArray;
	}

	private static int[][] getSubMatrix(int[][] matrix, int[] columnList) {

		int [][]subMatrix = new int[columnList.length][columnList.length];
		
		for (int i=1;i<=columnList.length;i++){
			int k=0;
			for (int j : columnList){
				subMatrix[i-1][k++] = matrix[i][j];
			}
		}
		
		return subMatrix;
	}

}
