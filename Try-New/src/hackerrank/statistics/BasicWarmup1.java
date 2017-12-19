package hackerrank.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/*
Mean (m): The average of all the integers.

m=x1+x2+x3+x4+…+xNN
m=x1+x2+x3+x4+…+xNN
where xixi is the ithith element of the array.

Array Median: If the number of integers is odd, display the middle element. Otherwise, display the average of the two middle elements.

Mode: The element(s) that occur most frequently. If multiple elements satisfy this criteria, display the numerically smallest one.

Standard Deviation (σσ):

σ=(x1−m)2+(x2−m)2+(x3−m)2+(x4−m)2+…+(xN−m)2N−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−√
σ=(x1−m)2+(x2−m)2+(x3−m)2+(x4−m)2+…+(xN−m)2N
where xixi is the ithith element of the array.


 */
public class BasicWarmup1 {

	
	public static void main(String[] args) {

		solution();
	}

	private static void solution() {

		Scanner sc = new Scanner(System.in);
		
		int numOfInput = sc.nextInt();
		int[] input = new int[numOfInput];
		for (int i=0;i<numOfInput;i++){
			input[i] = sc.nextInt();
		}
		
		double mean = findMean(input);
		
		double median = findMedian(input);
		
		int mode = findMode(input); 
		
		double stdDeviation = findStdDeviation(input, mean);
		
		DecimalFormat df = new DecimalFormat("#.0");
		
//		System.out.println("Mean : " + df.format(mean));
//		System.out.println("Median : " + df.format(median));
//		System.out.println("Mode: " + df.format(mode));
//		System.out.println("Standard Deviation : " + df.format(stdDeviation));
		
		System.out.println(df.format(mean));
		System.out.println(df.format(median));
		System.out.println(mode);
		System.out.println(df.format(stdDeviation));
	}

	private static double findStdDeviation(int[] input, double mean) {
		
		int n = input.length;
		double sumOfDeviationSquares = 0;
		double standardDeviation = 0;
		
		for (int i : input){
			//deviation from the mean
			double deviation = Double.valueOf(String.valueOf(i)) - mean;
			sumOfDeviationSquares = Math.pow(deviation, 2) + sumOfDeviationSquares;
		}
		
		standardDeviation = Math.pow(sumOfDeviationSquares/n, 0.5);
		return standardDeviation;
	}

	private static int findMode(int[] input) {
		int mode = 0;
		Map<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
		for (int i : input){
			if (!occuranceMap.containsKey(i)){
				occuranceMap.put(i, 1);
			}
			else {
				occuranceMap.put(i, occuranceMap.get(i) + 1);
			}
		}

		int maxOccurance = occuranceMap.get(input[0]);
		List<Integer> maxOccuranceList = new ArrayList<Integer>();
		int leastNum = input[0];
		
		//find max occurance
		for (int i : input){
			maxOccurance = (occuranceMap.get(i) > maxOccurance) ? occuranceMap.get(i) : maxOccurance;
			leastNum = (i < leastNum) ? i : leastNum;
		}
		
		//check for multiple maxOccurance
		for (int i : input){
			if (occuranceMap.get(i) == maxOccurance){
				maxOccuranceList.add(i);
			}
		}
		
		//if there are multiple maxOccurances, return the least number
		if (maxOccuranceList.size() > 1){
			mode = leastNum;
		}
		else {
			mode = maxOccuranceList.get(0);
		}
		return mode;
	}

	private static double findMedian(int[] input) {
		int n = input.length;
		double median = 0;
		Arrays.sort(input);
		
		if (n%2 == 0){
			double sumOfMidElements = input[(n/2) - 1 ] + input[(n/2)];
			median = sumOfMidElements/2;
			
		}
		else {
			int midIndex = (n/2) + 1;
			median = input[midIndex];
		}
		return median;
	}

	private static double findMean(int[] input) {

		int n = input.length;
		double sum = 0;
		for  (int i : input){
			sum = sum + i;
		}
		
		return sum/n;
	}

}
