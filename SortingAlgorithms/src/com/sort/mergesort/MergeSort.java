package com.sort.mergesort;

import com.sort.util.SortUtil;

public class MergeSort {
	
	
/* 
********************************************************************************
* The algorithm for MergeSort is recursive
* Time complexity is O(n log n)
* 
* Algorithm:
* 1. Divides the Array into 2 halves.
* 2. Compare the elements in the left and right halves.
* 3. Copy the contents of the 2 halves into a temp array
* 4. Once you reach the end of one of the halves, copy the remaining contents 
*    of the other half into the temp array.
* 5. copy the contents of the temp array into the main array.
*
********************************************************************************
 */
	
	public static void sort(int array[]){
		SortUtil.print(array);
		
		mergeSort(array, new int[array.length], 0, array.length - 1);
		
		SortUtil.print(array);
	}

	private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd){
			return;
		}
		
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(array, temp, leftStart, middle);				// Step 1
		mergeSort(array, temp, middle + 1, rightEnd);			// Step 1
		merge(array, temp, leftStart, rightEnd);
		
	}

	private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
		// more indeces for the array
		
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		
		int left = leftStart;
		int right = rightStart;
		
		//temp array index
		int index = leftStart;
		int size = rightEnd - leftStart + 1;
										
		while (left <= leftEnd && right <= rightEnd){					// Step - 2 and 3
			if (array[left] < array[right]){
				temp[index] = array[left];
				left++;
			}
			else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		//copy the remaining elements in the array to the temp array	-- Step 4
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		
		
		System.arraycopy(temp, leftStart, array, leftStart, size);			// Step 5
	}

}
