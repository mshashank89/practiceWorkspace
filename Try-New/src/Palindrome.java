import java.util.Scanner;


public class Palindrome {

	
	public static void main(String[] args) {
		String str= "\"16006\"";
		System.out.println(str);
		str = str.replaceAll("\"", "");
		System.out.println(str);
		int num = Integer.parseInt(str);
		
		System.out.println(num);
		
	}
	public static void main2(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		int length = str.length();
		int noOfCombinations = factorial(length);
/*		for (int i=0;i<noOfCombinations;i++){
			System.out.println(get(i,str));
		}
*/
		System.out.println(String.format("%05d", 100));
		
		String a = "M P";
		String[] c = a.split(" ");
		
		for (String c1 : c){
			System.out.println(c1);
		}
		
		
	}
	
	private static int factorial(int num){
		int factorial = 1;
		for (int i=num;i>0;i--){
			factorial = factorial * i;
		}
		
		return factorial;
	}
	
	private static String get(int num, String s){
		String comb = "";
		char[] charArray = s.toCharArray();
		char[] c1 = new char[s.length()];
		int nextIndex = 0;
		for (int i=s.length()-1;i>=0;i--){
			nextIndex = num % 10;
			num = num/10;
			c1[i] = charArray[nextIndex];
		}
		
		comb = c1.toString();
		return comb;
		
	}

}
