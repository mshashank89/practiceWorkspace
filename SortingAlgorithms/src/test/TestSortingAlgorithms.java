package test;

import java.util.Random;

import com.sort.bubblesort.BubbleSort;
import com.sort.insertionsort.InsertionSort;
import com.sort.selectionsort.SelectionSort;
import com.sort.util.SortUtil;

public class TestSortingAlgorithms {

	private static final int ARRAY_SIZE = (int) 1E1;

	public static void main(String[] args) {

		
		System.out.println("\n=======================================================================\n");

//		testBubbleSort();
		
//		testSelectionSort();
		
		testInsertionSort();
		
		

	}

	private static int[] generateRandomArray() {
		int array[] = new int[ARRAY_SIZE];
		Random random = new Random();

		for (int i = 0; i < ARRAY_SIZE - 1; i++) {
			array[i] = random.nextInt(100);
		}

		return array;
	}
	
	
	private static void testBubbleSort(){
		int array[] = generateRandomArray();
		long startTime, endTime = 0;
		
		System.out.println("Starting BubbleSort ..");
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array);
		endTime = System.currentTimeMillis();
		System.out.println("BubbleSort :" + SortUtil.isSorted(array));
		System.out.println("Time taken : " + (endTime - startTime) + " ms");

		System.out.println("\n=======================================================================\n");

	}
	
	public static void testSelectionSort(){
		int array[] = generateRandomArray();
		long startTime, endTime = 0;
		
		System.out.println("Starting Selectionsort ..");
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Sort :" + SortUtil.isSorted(array));
		System.out.println("Time taken : " + (endTime - startTime) + " ms");
		
		System.out.println("\n=======================================================================\n");
	}
	
	
	public static void testInsertionSort(){
		int array[] = generateRandomArray();
		long startTime, endTime = 0;
		
		System.out.println("Starting Insertionsort ..");
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array);
		endTime = System.currentTimeMillis();
		System.out.println("Insertion Sort :" + SortUtil.isSorted(array));
		System.out.println("Time taken : " + (endTime - startTime) + " ms");
		
		System.out.println("\n=======================================================================\n");
	}

}
