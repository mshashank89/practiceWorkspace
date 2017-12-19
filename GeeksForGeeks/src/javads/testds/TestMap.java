package javads.testds;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

//import for Scanner and other utility  classes
import java.util.*;

/*
class Graph{
    LinkedList<LinkedList<Integer>> graph;
    
    public Graph {
        graph = new LinkedList<LinkedList<Integer>>();
    }
    
    public add(int v1, int v2){
        addPvt(v1,v2);
        addPvt(v2,v1);
    }
    public int getNumOfCities(){
        return graph.size();
    }
        
    private addPvt(int v1, int v2){
        if (null == graph.get(v1)){
            LinkedList<Integer> ll = new LinkedList<Integer>();
            
            ll.add(v2);
            graph.add(ll);
        }
        else{
            LinkedList<Integer> ll = graph.get(v1);
            ll.add(v2);
        }
    }
}*/

class TestMap {  
	
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
        int t =  s.nextInt();
        
        for (int i = 0; i < t; i++) {
            // Graph graph = new Graph();
            
            int noOfEdges = s.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j=0;j<noOfEdges;j++){
                Integer v1 =  s.nextInt();
                Integer v2 =  s.nextInt();
                
                // graph.add(v1,v2);
                map.put(v1,v1);
                map.put(v2,v2);
            }
            
            // System.out.println(graph.getNumOfCities());
            System.out.println(map.size());
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
