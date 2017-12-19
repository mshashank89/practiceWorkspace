package ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/*
 * 
3
6
1 0
2 1
3 1
4 1
5 1
6 0
5
1 1
2 0
3 1
1 1
2 1
4
1 1
2 1
2 1
3 1



output 
4
2
3
 */

public class TestArray {
	static String v = "abc";
	static int v1 = 25;
	
	static 
	{
		String s = "hello";
		Character sd = s.charAt(0);
		char c = new Character('c');
		v1=50;
		System.out.println(v);
		System.out.println(v1);
	}
	public void someMethod(){
	}
	public static void main(String[] args) {
		
		List<Long> list = new ArrayList<Long>();
		for (long i = 1000000;i<200000000;i++){
			list.add(i);
		}
		
		Long[] arr = list.toArray(new Long[list.size()]);
	}

    public void run(){
    	
    	Map<Character, Integer> map  =new HashMap<Character, Integer>();
    	String s = "hi";
    	map.put(s.charAt(0), 1);
    	
    	if (map.get(0) == null){

    	}
    	
        System.out.println("Run executed");
    }
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t1 = sc.nextInt();
		
		for (int k=0;k<t1;k++){
			int t = sc.nextInt();
			int maxCons = 0;
			
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i=0;i<t;i++){
				int s = sc.nextInt();
				int r = sc.nextInt();
				
				if (map.containsKey(s)){
					
				}
				else {
					map.put(s, r);
					
					if (r==1){
						maxCons++;
						
					}
					else {
						maxCons=0;
					}
				}
			}
			System.out.println(maxCons);
		}
	}

	public static void main1(String[] args) {

		//2 numbers are swapped in a sorted array. find the 2 numbers
		
//		int[] array = {1, 2, 3, 30, 5, 10, 4};
		int[] array = {1, 2, 3, 4, 5, 30, 10};
		
		int prev = -1, next = -1, index1 = -1, index2 = -1;
		
		for (int i=0; i<array.length ; i++){
			prev = i -1;
			if (prev >= 0 && index1 == -1){
				if (array[prev] > array[i]){
					index1 = prev;
					next = i;
				}
			}
			if (next > 0 && i > next && next < array.length && (array[next] > array[i]) && (array[i] > array[index1-1])){
				index2 = i;
			}
		}
		index2 = (index2 == -1)?next:index2;
//		System.out.println(array[index1] + "  " + array[index2]);
		
		int r = 2, c=3;
		int oddCount = 1;
		int evenCount = 0;
		for (int i=0;i<r;i++){
			int newOddCount = (oddCount > c) ? c : oddCount + 2;
			oddCount += newOddCount;
		}
		
		for (int i=0;i<r;i++){
			int newEvenCount = (evenCount> c) ? c : evenCount + 2;
			oddCount += newEvenCount;
		}
		
		System.out.println(evenCount + "  " + oddCount);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer s = map.get(2);
	}

}
