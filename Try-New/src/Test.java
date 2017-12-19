/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

//import for Scanner and other utility  classes
import java.util.*;


class Test {
	
	private static Print p = new Print();
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
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
        int n = s.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        scan(a);
        
        int maxLength = 0;
        for (int i : map.keySet()){
            int curLength = map.get(i);
            maxLength = (maxLength > curLength) ? maxLength : curLength;
        }
        
        //if there are other 1s in the array that can be swapped with
        int countOnes = countOnesOrZeros(a, 1);
        if (maxLength == 0){
        	maxLength = countOnes;
        }
        if (countOnes > maxLength){
        	maxLength =maxLength + 1; // since there are other 1s in the array that the 0 can be swapped with.
        	
        }
        
        
        
        p.println(maxLength);
        
        
        p.close();
    }
    
    private static int countOnesOrZeros(int[] a, int num){
    	int count = 0;
    	for (int i=0;i<a.length;i++){
    		if (a[i] == num){
    			count ++;
    		}
    	}
    	return count;
    }
    
    private static void scan(int[] a){
    	if (countOnesOrZeros(a, 0) == 0){
    		return;
    	}
        for (int i=0;i<a.length;i++){
            if (a[i] == 0){
                if (i>0 && i<a.length-1){
                    if (a[i-1] == 1 && a[i+1] == 1){
                        int length = subArrayLength(a,i);
                        map.put(i,length);
                    }
                }
            }
        }
    }
    
    private static int subArrayLength(int[] a, int i){
        int length = 0;
        int leftIndex = i, rightIndex = i;
        //left sub array length
        for (int k = leftIndex;leftIndex>0;leftIndex--){
            if (a[leftIndex-1] == 1){
                ++length;
            }
            else{
            	break;
            }
        }
        
        //left sub array length
        for (int k = rightIndex;rightIndex<a.length-1;rightIndex++){
            if (a[rightIndex+1] == 1){
                ++length;
            }
            else{
            	break;
            }
        }
        
        
        return length;
    }
    
    
    static class Print {
 
        private final BufferedWriter bw;
 
        public Print() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
 
        public void print(String str) throws IOException {
            bw.append(str);
        }
        
        public void print(int val) throws IOException {
            bw.append(String.valueOf(val));
        }
        
        public void println(int val) throws IOException {
            print(val);
            bw.append("\n");
        }
        public void println(String str) throws IOException {
            print(str);
            bw.append("\n");
        }
        
        public void println() throws IOException {
            bw.append("\n");
        }
 
        public void close() throws IOException {
            bw.close();
        }
    }
}
