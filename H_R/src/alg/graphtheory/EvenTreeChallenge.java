/**

Problem Statement

You are given a tree (a simple connected graph with no cycles). 
You have to remove as many edges from the tree as possible to obtain a forest
with the condition that : Each connected component of the forest should contain an even number of vertices.

To accomplish this, you will remove some edges from the tree. Find out the number of removed edges. 

Input Format 
 The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges. 
 The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index) 

Output Format 
 Print the answer, a single integer.

Constraints 
 2 <= N <= 100. 

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes. 

Sample Input
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8


Sample Output
2


Explanation  
 On removing edges (1, 3) and (1, 6), we can get the desired result.

 */

package alg.graphtheory;

import java.util.Scanner;

public class EvenTreeChallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfNodes = sc.nextInt();
		int noOfEdges = sc.nextInt();
		
		int [][]tree = new int[noOfNodes][noOfNodes];
		
		for (int k=0;k<noOfEdges;k++){
			
			int i = sc.nextInt() -1;
			int j = sc.nextInt() -1;
			
			tree[i][j] = 1;
			tree[j][i] = 1;
		}
		
		printTree(tree);
		
	}

	private static void printTree(int[][] tree) {

		for (int i=0;i<tree.length;i++){
			for(int j=0;j<tree.length;j++){
				System.out.print(tree[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	

}
