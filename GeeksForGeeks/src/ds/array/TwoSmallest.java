package ds.array;

public class TwoSmallest {

	public static void main(String[] args) {

		int a[] = {34,23,-5,7,-8,343,-2};
		twoSmallest(a);
	}

	private static void twoSmallest(int a[]){
		int m1 = a[0];
		int m2 = a[1];
		
		for (int i=2;i<a.length;i++){
			if (a[i] < m1){
				m2 = m1;
				m1 = a[i];
				continue;
			}			
			if ( a[i] < m2){
				m2 = a[i];
			}
		}
		System.out.println(m1 + "  " + m2);
	}
}
