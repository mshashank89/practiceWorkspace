package alg.geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockCountingSoln2 {

	public static void main(String[] args) throws Exception {
		new SherlockCountingSoln2().run();
	}

	private void run() throws Exception {
		/*
		 * int[][] rres = new int[100][100]; PrintWriter pw = new
		 * PrintWriter("out.txt"); for (int n = 1; n < 100; n++) for (int k = 1;
		 * k < 100; k++) { int res = 0; for (int i = 1; i < n; i++) if (i * (n -
		 * i) <= n * k) res++; rres[n][k] = res; pw.printf("%d %d %d", n, k,
		 * res); for (int i = 1; i < n; i++) if (i * (n - i) <= n * k)
		 * pw.printf(" %d", i); pw.println(); } pw.close();
		 */BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String[] s = br.readLine().trim().split(" +");
			long n = Integer.parseInt(s[0]);
			long k = Integer.parseInt(s[1]);
			System.out.println(go(n, k));
		}
	}

	private long go(long n, long k) {
		long l = 1;
		long r = n / 2 + 1;
		while (l < r) {
			long m = (l + r + 1) / 2;
			if (m * (n - m) > n * k)
				r = m - 1;
			else
				l = m;
		}
		if (l > n / 2)
			return (n - 1);
		else
			return (2 * l);
	}

}
