package alg.dynprg;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ModifiedFibonacci<K, V, T> {
	
	private static Map<String, StringBuilder> prodMap = new HashMap<String, StringBuilder>();
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		String[] inputStr = input.split(" ");
		String a = inputStr[0];
		String b = inputStr[1];
		String n = inputStr[2];

		
		Runtime r = Runtime.getRuntime();
		long beforeFreeMem = r.freeMemory();
		long startTimeinMillis = System.currentTimeMillis();
		
//		System.out.println(beforeFreeMem);
		System.out.println(series(a, b, Integer.parseInt(n)));
		long afterFreeMem = r.freeMemory();
//		System.out.println(afterFreeMem);

		/*System.out.println();
		System.out.println("Total memory: " + r.totalMemory());
		System.out.println("Max memory: " + r.maxMemory());
		System.out.println("*******************");
		System.out.println("Mem used  : " + (afterFreeMem - beforeFreeMem)/1000 + " kb");		
		System.out.println("Time taken: " + (System.currentTimeMillis() - startTimeinMillis)* 0.001 + " seconds");
		*///System.out.println(series1(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(n)));

	}

	public static BigInteger series1(int a, int b, int n) {

		BigInteger output = new BigInteger("0");
		// long tempOutput = 0;
		BigInteger num1 = new BigInteger("0"), num2 = new BigInteger("1");

		for (int i = 0; i < n - 2; i++) {
			output = num2.multiply(num2);
			output = output.add(num1);

			num1 = num2;
			num2 = output;

			 System.out.println("n: " + n + " , " + num1 + ", " + num2);

		}

		return output;
	}

	public static String series(String a, String b, int n) {

		StringBuilder output = new StringBuilder("0");
		// long tempOutput = 0;
		StringBuilder num1 = new StringBuilder(a), num2 = new StringBuilder(b);

		for (int i = 0; i < n - 2; i++) {
			output = multiply2BigNumbers(num2, num2);
			output = addBigNumbers(output, num1);

			num1 = num2;
			num2 = output;

			System.out.println("n: " + n + " , " + num1 + ", " + num2);

		}

		return output.toString();
	}

	public static StringBuilder addBigNumbers(StringBuilder a, StringBuilder b) {

		StringBuilder output = new StringBuilder();
		int carry = 0;

		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {

			int num1 = 0, num2 = 0;
			if (0 <= i) {
				num1 = Integer.parseInt(String.valueOf(a.charAt(i)));
			}
			if (0 <= j) {
				num2 = Integer.parseInt(String.valueOf(b.charAt(j)));
			}
			int temp = num1 + num2 + carry;

			if (temp >= 10) {
				carry = temp / 10;
			} else {
				carry = 0;
			}
			output.append(temp % 10);

		}

		if (carry != 0) {
			output.append(carry);
		}

		return output.reverse();
	}

	public static StringBuilder multiplyBigBySingleDigit(StringBuilder bigNumber, int num) {

		if (null != prodMap.get(bigNumber + "_" + num)){
			return prodMap.get(bigNumber + "_" + num);
		}
		StringBuilder output = new StringBuilder();
		int carry = 0;

		// bigNumber = "111111111111111";
		// num = 2;

		for (int i = bigNumber.length() - 1; i >= 0; i--) {

			int num1 = 0;
			if (0 <= i) {
				num1 = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
			}

			int temp = (num1 * num) + carry;

			if (temp >= 10) {
				carry = temp / 10;
			} else {
				carry = 0;
			}
			output.append(temp % 10);

		}

		if (carry != 0) {
			output.append(carry);
		}

		
		//add the output into the map
		
		prodMap.put(bigNumber + "_" + num, output.reverse());
		return output.reverse();
	}

	/**
	 * metho to mutiply 2 huge numbers
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static StringBuilder multiply2BigNumbers(StringBuilder a, StringBuilder b) {

		StringBuilder output = new StringBuilder();
		int max = a.length() > b.length() ? a.length() : b.length();
		int min = a.length() > b.length() ? b.length() : a.length();

		StringBuilder bigNumber = new StringBuilder("");
		StringBuilder smallNumber = new StringBuilder("");

		StringBuilder[] outputArrays = new StringBuilder[min];

		bigNumber = (a.length() == max) ? a : b;

		smallNumber = (a.equals(bigNumber)) ? b : a;
		int p = 0;
		for (int i = min - 1; i >= 0; i--) {

			StringBuilder tempOutput = new StringBuilder();

			int num = Integer.parseInt(String.valueOf(smallNumber.charAt(i)));

			for (int k = 0; k < min - 1 - i; k++) {
				tempOutput.append("0");
			}
			StringBuilder tempProd = multiplyBigBySingleDigit(bigNumber, num);

			tempProd = tempProd.append(tempOutput.toString());

			outputArrays[p++] = tempProd;

		}

		// add all strings in the array
		StringBuilder finalOutput = new StringBuilder("0");

		StringBuilder num1 = new StringBuilder("");
		for (int i = 0; i <= outputArrays.length - 1; i++) {

			num1 = outputArrays[i];
			finalOutput = addBigNumbers(finalOutput, num1);

		}
		return finalOutput;
	}

}
