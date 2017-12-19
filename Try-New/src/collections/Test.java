package collections;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	
	public static void main(String[] args) {

		Map<Integer, Integer> intMap = new TreeMap<Integer, Integer>();
		
		intMap.put(100, 1);
		intMap.put(31, -4);
		
		for (int i : intMap.keySet()){
			System.out.println(intMap.get(i));
		}
		
		System.out.println("End of map test");
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(-10);
		l.add(-30);
		l.add(90);
		l.add(9);
		
		Collections.sort(l);
		for (int i : l){
			System.out.println(i);
		}
	}
	
	public static void main2(String[] args) {
		System.out.println("starting");
		File f = new File("D:/test/testFileq.txt");
		try 
		{
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
		
			bw.append("hello");
			bw.close();
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
	
	
	public static void main1(String[] args) {
		LoyPromoBean bean1 = new LoyPromoBean();
		bean1.setLoyPromoRLId("1");
		bean1.setCreatedBy("pn");
		bean1.setLastUpdatedBy("pn");
		bean1.setLastUpdateLogin("pn");
		bean1.setCreationDate("28-OCT-15 04.55.24.101000000 AM");
		bean1.setLastUpdateDate("28-OCT-15 04.55.33.386000000 AM");
		bean1.setConflictId("0");
		bean1.setApplyToCd("Transactions");
		bean1.setDescText("null");
		bean1.setLibraryCatgCd("");
		bean1.setLibBasePromoFlg("N");
		bean1.setName("RS1");
		bean1.setParRowId("");
		bean1.setPromoId("100");
		bean1.setSeqNum("1");
		bean1.setTypeCd("Criteria");
		bean1.setObjectVersionNumber("1");
		
		LoyPromoBeanTreeNode promoTreeRootNode = new LoyPromoBeanTreeNode();
		try{
//			promoTreeRootNode = (LoyPromoBeanTreeNode)bean1;
			
			bean1 = promoTreeRootNode;
		}
		catch(Exception e){
			System.out.println("oops!!");
		}
		
		System.out.println("End");
	}

	

}
