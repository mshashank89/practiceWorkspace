package collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {


		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(null, 100);
		map.put(1, 200);
		
		Iterator<Integer> it = map.keySet().iterator();
		
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
		
		//Map supports 1 null as key.
		//The above code prints 100 200
		
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put(new String("a"), "audi");
		map1.put(new String("a"), "ferrari");
		
		Iterator<String> i = map1.keySet().iterator();
		while(i.hasNext()){
			System.out.println(map1.get(i.next()));
		}
		
		
		System.out.println("----Identity hash map");
		Map<String, String> identityHashMap = new IdentityHashMap<String, String>();
		identityHashMap.put(new String("a"), "ferrari");
		identityHashMap.put(new String("a"), "audi");
		identityHashMap.put("a", "lamborghini");
		identityHashMap.put("a", "porsche");
		
		
		Iterator<String> m = identityHashMap.keySet().iterator();
		while(m.hasNext()){
			System.out.println(identityHashMap.get(m.next()));
		}
	}

}
