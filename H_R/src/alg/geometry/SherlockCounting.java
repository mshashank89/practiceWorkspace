package alg.geometry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockCounting {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:/Data/Shashank/SherlockOutput.txt");
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Scanner sc = new Scanner(System.in);

		List<Integer> list = new ArrayList<Integer>();
		
		long startTime = System.currentTimeMillis();
		int t = Integer.parseInt(sc.nextLine());

		
		for (int r = 0; r < t; r++) {
			String inputStr = sc.nextLine();
			String[] input = inputStr.split(" ");

			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			int count = 0;
			for (int i = 1; i < n; i++) {

				if (i*(n-i) <= n*k) {
					count++;
				}
			}

			list.add(count);
		}
		
		
//		System.out.println("Totaltime taken : " + (System.currentTimeMillis() - startTime));
		
		
		
		for (int i : list)
		{
			bw.append(String.valueOf(i));
			bw.newLine();
		}
		
		bw.close();
		fw.close();
	}

}
