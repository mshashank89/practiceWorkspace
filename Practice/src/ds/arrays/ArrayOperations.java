package ds.arrays;

public class ArrayOperations {
	
	static int[] a;
	static{
		a = new int[5];
		for (int i=0;i<a.length;i++){
			a[i] = i+1;
		}
	}
	public static void main(String[] args) {
		
		printReverse();
		reverseCString("helilo1");
		reverseCStringInPlace("helilo1");

	}
	
	public static  void printReverse(){
		System.out.println("Print reverse: ");
		for (int i=a.length-1;i>=0;i--){
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		char[] c = new String().toCharArray();
	}
	
	
	public static void reverseCString(String s){
		
		System.out.println("Reversing String : " + s);
		char[] c1 = s.toCharArray();
		char[] c2 = new char[s.length()];
		
		int l = c1.length;
		
		for (int i=0;i<l-1;i++){
			c2[i] = c1[l-2-i];
		}
		
		c2[l-1] = c1[l-1];
		
		System.out.println(c2);
		
	}
	
	public static void reverseCStringInPlace(String s){
		
		System.out.println("Reversing String : " + s);
		char[] c = s.toCharArray();
		
		int l = c.length;
		int n = (l-1)/2;
		
		for (int i=0;i<n;i++){
			char temp = c[i];
			c[i] = c[l-2-i];
			c[l-2-i] = temp;
		}
		
		System.out.println(c);
		
	}
	
	

}
