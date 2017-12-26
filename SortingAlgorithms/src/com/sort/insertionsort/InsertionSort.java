package com.sort.insertionsort;

import com.sort.util.SortUtil;

public class InsertionSort {

	/*
	 * *******************************************************************************************************
	 * 
* Algorithm:
---------------- 
* Divide the array into sorted and Unsorted parts.
* 		The first element is sorted and the remaining array is unsorted array.
* The first element in the unsorted array is the 'index'.
* This 'index' is inserted into the sorted array at the appropriate index.

* 		Finding the position in the sorted array where the 'index' element is inserted:
        --------------------------------------------------------------------------------
        1. Starting from the right most end of the sorted array, compare the element with the 'index'
        2. If the element in the sorted array is greater than the 'index', move the element to the right 
           by 1 place.
        3. Repeat the step-2 until you reach an element in the sorted array which is less than the 'index'.
        4. Insert the 'index' next to the element found in step-3.  
* 
	 */

	public static void sort(int array[]) {

		SortUtil.print(array);
		//i=1 indicates array[0] is sorted. array[1 - 9] is unsorted.
		
		for (int i = 1; i < array.length; i++) {    // i loops through the unsorted array.
			int index = array[i];				// 'index' is the first element in the unsorted array. 
			int j = i;

			while (j > 0 && array[j - 1] > index) {   // Step - 2, 3
				array[j] = array[j - 1];
				j--;
			}

			array[j] = index;						// Step - 4
		}
		
		SortUtil.print(array);

	}

}
