package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTypeTest {

	public static void main1(String[] args) {
		MapTypeTest m = new MapTypeTest();
//		m.mapTypeTest();
	}
	
	
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        Map<Integer, String> treeMap = new TreeMap<Integer, String>();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            
            int noOfSetBits = findSetBits(n);
            add(treeMap, noOfSetBits, String.valueOf(n));
        }
        
        print(treeMap);
    }
    
    private static void print(Map<Integer, String> map) {
		
		for(int i: map.keySet()){
			System.out.print(map.get(i) + " ");
		}
		
	}
    
    private static int findSetBits(int num){
    	int count = 0;
    	while (num > 0){
    		if (num % 2 == 1){
    			count ++;
    		}
    		num = num >> 1;
    	}
    	
    	return count;
    }
    
    private static void add(Map<Integer, String> map, int key, String value){
		if (map.get(key) == null){
			map.put(key, value);
		} else {
			value = map.get(key) + " " + value;
			map.put(key, value);
			
			
			
		}
	}
	
	/*private void mapTypeTest(){
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		
		add(hashMap, 1, "A1");
		add(hashMap, 2, "A2");
		add(hashMap, 3, "A3");
		add(hashMap, 4, "A4");
		add(hashMap, 5, "A5");
		add(hashMap, 3, "A3_1");
		
		
		add(treeMap, 3, "T3");
		add(treeMap, 2, "T2");
		add(treeMap, 4, "T4");
		add(treeMap, 1, "T1");
		add(treeMap, 5, "T5");
		add(treeMap, 5, "T5_1");
		add(treeMap, 1, "T6");
		add(treeMap, 2, "T2_1");
		
		System.out.println("HashMap:");
		print(hashMap);
		System.out.println("=============");
		System.out.println("Treemap:");
		print(treeMap);
	}

	private void print(Map<Integer, String> map) {
		
		for(int i: map.keySet()){
			System.out.println(i + " - " + map.get(i));
		}
		
	}
	
	
	private void add(Map<Integer, String> map, int key, String value){
		if (map.get(key) == null){
			map.put(key, value);
		} else {
			value = map.get(key) + " " + value;
			map.put(key, value);
		}
	}
*/
}
