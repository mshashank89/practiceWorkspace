package javads.testds;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("one");
		treeSet.add("One");
		treeSet.add("ONE");
		System.out.println(treeSet.ceiling("p"));
		
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.UK);
		Float f = 99.99F;
		System.out.println(fmt.format(f));
	}

}
