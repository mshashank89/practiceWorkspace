package fibo;

public class Factorial {

	public static void main(String[] args) {

		factorial(5);
		System.out.println("Recursive: " + factRec(5));
	}

	private static void factorial(int n) {
		int fact = 1;
		for (int i=1;i<=n;i++){
			fact = fact * i;
		}
		System.out.println(fact);
	}
	
	private static int factRec(int n){
		if (n == 1) return 1;
		
		return n * factRec(n-1);
	}

}
