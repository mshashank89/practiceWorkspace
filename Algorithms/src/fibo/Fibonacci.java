package fibo;

public class Fibonacci {

	public static void main(String[] args) {

		fibonacci(10);
		System.out.println();
		System.out.println(" Recursive : ");
		fiboRec(0, 1, 10);
	}

	/**
	 * Method to point first n numbers in fibonacci series
	 * @param n
	 */
	private static void fibonacci(int n) {
		int n1 = 0;
		int n2 = 1;
		int num = n1 + n2;
		System.out.print(0 + " " + 1 + " ");
		for (int i=3;i<=n;i++){
			System.out.print(num + " ");
			n1 = n2;
			n2 = num;
			num = n1 + n2;
		}
	}
	
	/**
	 * recursive fibonacci method
	 */
	private static void fiboRec(int n1, int n2, int n){
		if (n == 0){
			return;
		}
		if (n1 == 0 && n2 == 1){
			System.out.print(0 + " " + 1 + " ");
			n = n-2;
		}
		int num = n1 + n2;
		System.out.print(num + " ");
		fiboRec(n2, num, --n);
	}
	
	


}
