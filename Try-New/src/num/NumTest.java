package num;

import java.util.ArrayList;
import java.util.Scanner;

public class NumTest {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

		int arrayLength = 5;
		int index = 7;
		
		if (index > arrayLength) index = index % arrayLength;
		int k = 0;
		for (int i=0;i<arrayLength;i++){
			k++;
			System.out.print((i + arrayLength - index)%arrayLength + " ");
			
			if(k == 20){
				System.out.println();
				k=1;
			}
		}
	}
	
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            
            int a[] = new int[n];
            ArrayList<Integer> al = new ArrayList<Integer>();
            
            for (int j=0;j<n;j++){
//            	a[j] = s.nextInt();
            	al.add(s.nextInt());
            }
            
//            rotateRight(a, k);
            rotateRight(al, k);
            System.out.println();
        }
        

        
    }
    
    private static void rotateRight(ArrayList<Integer> a, int k) {

//    	int[] b = new int[a.length];
    	ArrayList<Integer> b = new ArrayList<Integer>();
    	if (k > a.size()) k = k % a.size();
    	int num = a.size() - k;
    	
    	for(int i=0;i<a.size();i++){
    		b.add(i, a.get((i + num)%a.size()));
    	}
    	
    	print(b);
	}

	private static void print(ArrayList<Integer> b) {
		for (int i : b){
			System.out.print(i + " ");
		}
		
	}

	private static void print(int[] a){
    	for (int i=0;i<a.length;i++){
    		System.out.print(a[i] + " ");
    	}
    }
    
    private static void rotateRight(int[] a, int k){
    	
    	int[] b = new int[a.length];
    	if (k > a.length) k = k % a.length;
    	int num = a.length - k;
    	
    	for(int i=0;i<a.length;i++){
    		b[i] = a[(i + num)%a.length];
    	}
    	
    	print(b);
    }

}
