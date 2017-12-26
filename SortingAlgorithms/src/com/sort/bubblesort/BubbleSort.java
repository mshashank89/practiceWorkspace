package com.sort.bubblesort;

public class BubbleSort {
	
	public static void sort(int array[]){
		
		boolean isSorted = false;
		int lastUnSorted = array.length - 1;
		while (!isSorted){
			isSorted = true;
			for (int i=0;i<lastUnSorted ; i++){
				if (array[i] < array[i+1]){
					swap(array, i, i+1);
					isSorted = false;
				}
			}
			lastUnSorted--;
		}
		
	}
	
	private static void swap(int array[], int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
