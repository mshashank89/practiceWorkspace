package com.sort.selectionsort;

import com.sort.util.SortUtil;

public class SelectionSort {
	
	/*
	 * 
*************************************************************************************************************
- Algorithm works by selecting the smallest unsorted element and swapping with the element 
  in the next position to be filled
  
- The selection sort works as follows: you look through the entire array for the smallest 
  element, once you find it you swap it (the smallest element) with the first element of the array. 
  Then you look for the smallest element in the remaining array (an array without the first element) 
  and swap it with the second element. Then you look for the smallest element in the remaining array 
  (an array without first and second elements) and swap it with the third element, and so on. 
  
************************************************************************************************************   
	 */
	
	public static void sort(int array[]){
		
		int min = 0;
		for (int i=0;i<array.length-1;i++){
			//this loop finds the min and swaps with the element at pos i
			min = i;
			for(int j=i+1;j<array.length;j++){
				if (array[j] < array[min]){
					min = j;
				}
			}
			swap(array, i, min);
		}
	}

	private static void swap(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	public static void main(String[] args) {
		int array[] = {90, 23,34, 24,456,234,6456,67863,34564,7875};
		
		SortUtil.print(array);
		sort(array);
		System.out.println("\n\nsorted array:");
		SortUtil.print(array);
		
	}
	
	

}
