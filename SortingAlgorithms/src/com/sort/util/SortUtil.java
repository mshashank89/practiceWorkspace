package com.sort.util;

public class SortUtil {
	public static void print(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "   ");
		}
		System.out.println();
	}
	
	public static String isSorted(int array[]){
		boolean isSorted = true;
		int count = 0;
		
		if (array[0] < array[array.length - 1]){			
			for (int i=0;i<array.length - 1;i++){
				if (array[i] <= array[i+1]){
					count ++;
				}
			}
		}
		else {			
			for (int i=0;i<array.length - 1;i++){
				if (array[i] >= array[i+1]){
					count ++;
				}
			}
		}
		
		
		if (count != array.length - 1){
			isSorted = false;
		}
		
		return (isSorted) ? "Sorted Successfully !!" : "Sorting Failed..";
	}
}
