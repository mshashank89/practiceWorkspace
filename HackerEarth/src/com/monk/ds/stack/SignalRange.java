package com.monk.ds.stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SignalRange {

	
	private static Print p = new Print();
	
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int r[] = new int[n];
            
            Stack stk = new Stack(n);
            Stack tempStk = new Stack(n);
            
            for (int j=0;j<n;j++) {
                stk.push(s.nextInt());
            }
            
            for (int j=0;j<n;j++) {
                int cur = stk.pop();
                int range = 1;
                
                while (cur > stk.peek()) {
                    range++;
                    tempStk.push(stk.pop());
                }
                r[n-1-j] = range;
                refillStk(tempStk, stk);
                
            }
            
            for (int range : r) {
                p.print(range + " ");
            }
            p.println();
            
        }
        
        
        p.close();
    }
    
    private static void refillStk(Stack tempStk, Stack stk) {
        while (tempStk.top > -1) {
            stk.push(tempStk.pop());
        }
    }
    
  
    static class Stack {
        int a[];
        int top;
        int size;
        
        public Stack(int n) {
            a = new int[n];
            top = -1;
            size = n;
        }
        
        
        public void push(int n) {
            a[++top] = n;
        }
        
        public int pop() {
            return (top > -1) ? a[top--] : Integer.MAX_VALUE;
        }
        
        public int peek() {
            return (top > -1) ? a[top] : Integer.MAX_VALUE;
        }
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
