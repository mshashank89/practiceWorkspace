/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {
	
	private static Print p = new Print();
	
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
        
        long[] transaction = new long[t];

        for (int i = 0; i < t; i++) {
            transaction[i] = s.nextInt();
        }
        
        int q = s.nextInt();
        long[] target = new long[t];

        for (int i = 0; i < t; i++) {
            target[i] = s.nextInt();
        }
        
        for (long tgt : target){
            //find the index of the transactoin where target is achieved
            for (int i=0;i<t;i++){
                long currTurnOver=0;
                currTurnOver+= transaction[i];
                if (currTurnOver >= tgt){
                    p.println(i+1);
                }
            }
            
        }
        
        
        p.close();
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
