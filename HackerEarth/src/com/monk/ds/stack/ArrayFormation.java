package com.monk.ds.stack;

import java.util.Scanner;

public class ArrayFormation {
	private static Scanner s = new Scanner(System.in); 
    public static void main(String[] args) {
        solve();
        s.close();
    }

	private static void solve() {
		int n = s.nextInt();
        int a[] = new int[n];
        Queue queue = new Queue(n);
        Stack stk = new Stack(n);
        
        for (int i=0;i<n;i++) {
            a[i] = s.nextInt();
            
            if (isPrime(a[i])) {
                queue.push(a[i]);
            }
            else {
                stk.push(a[i]);
            }
        }
        
        
        while (queue.tail >= queue.head) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        
        while(stk.top > -1) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
	}
    
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) return true;
        for (int i=2;i<=n/2;i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    static class Stack {
        int a[];
        int top;
        
        public Stack(int size) {
            a = new int[size];
            top = -1;
        }
        
        public void push(int n) {
            a[++top] = n;
        }
        
        public int pop() {
            return a[top--];
        }
        
        public int peek() {
            return (top > -1) ? a[top] : Integer.MIN_VALUE;
        }
        
    }
    
    
    static class Queue {
        int a[];
        int head;
        int tail;
        int size;
        
        public Queue(int size) {
            a = new int[size];
            head = 0;
            tail = -1;
            this.size = size;
        }
        
        public void push(int n) {
            if (tail <= size)
            {
                a[++tail] = n;
            }
        }
        
        public int dequeue() {
            if (head > tail){
                head = 0;
                tail = -1;
                return Integer.MIN_VALUE;
            }
            return a[head++];
        }
        
        public int peek() {
            if (head <= tail) {
                return a[head];
            }
            return Integer.MIN_VALUE;
        }
    }
    

}
