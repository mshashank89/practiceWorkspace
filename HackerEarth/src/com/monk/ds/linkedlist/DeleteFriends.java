package com.monk.ds.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeleteFriends {

/*	public static void main1(String[] args) {

		LinkedList<Integer> a = new LinkedList<Integer>();
//		a.push(23);
//		a.push(45);
//		a.push(11);
//		a.push(77);
//		a.push(18);

		a.add(23);
		a.add(45);
		a.add(11);
		a.add(77);
		a.add(18);
		
		
		for (int j = 0; j < a.size(); j++) {
			System.out.print(a.get(j) + " ");
		}
		System.out.println();
		
		for (int j = 0; j < a.size(); j++) {
			System.out.print(a.peek() + " ");
		}
		System.out.println();
		
	}*/
	
	/*
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			LinkedList<Integer> a = new LinkedList<Integer>();
			int n = s.nextInt();
			int k = s.nextInt();
			for (int j = 0; j < n; j++) {
				int num = s.nextInt();
				a.push(num);
			}

			// a.deleteKFriends(k);
			for (int j = 0; j < k; j++) {
				deleteFriend(a);
			}
			
			for (int j=0;j<a.size();j++) {
				System.out.print(a.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void deleteFriend(LinkedList<Integer> a) {
		boolean flag = false;
		
		for (int i=0;i<a.size()-1;i++) {
			if (a.get(i) < a.get(i+1)) {
				a.remove(i);
				flag = true;
				break;
			}
		}
		
		if (!flag) {
			a.remove(a.size()-1);
		}

	}*/
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		long now = System.currentTimeMillis();
		for (int i = 0; i < t; i++) {
			LinkedList a = new LinkedList();
			int n = s.nextInt();
			int k = s.nextInt();
			for (int j = 0; j < n; j++) {
				int num = s.nextInt();
				a.add(num);
			}

			// a.deleteKFriends(k);
			for (int j = 0; j < k; j++) {
				a.deleteFriend();
			}
			
			a.print();
//			System.out.println();
		}
		
		now = System.currentTimeMillis() - now;
		System.out.println("total time taken: " + (now));
		
		
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static class LinkedList {
		Node head;
		Node last;

		LinkedList() {
			head = null;
		}

		public void add(int n) {
			Node l = last;
			Node temp = new Node(n);
			if (null == head) {
				head = temp;
				last = head;
				return;
			}

			l.next = temp;
			last = temp;
		}

		public void print() {
			Node t = head;
			while (null != t) {
				System.out.print(t.data + " ");
				t = t.next;
			}
			System.out.println();
		}

		public void deleteNode(int key) {
			if (null == head) {
				return;
			}

			if (head.data == key) {
				Node temp = head;
				head = head.next;
				temp = null;
				return;
			}
			Node prev = head;
			Node cur = prev.next;
			while (null != cur && cur.data != key) {
				prev = cur;
				cur = cur.next;
			}

			if (null == cur) {
				// data not found
				return;
			}
			if (cur.data == key) {
				prev.next = cur.next;
				cur = null;
			}
		}

		private void deleteLast() {
			Node t = head;
			while (null != t.next && t.next.data != last.data) {
				t = t.next;
			}
			last = t;
			t.next = null;
		}
		
		public void deleteFriend() {
			boolean flag = false;
			if (null == head)
				return;
			Node cur = head;

			while (null != cur && null != cur.next) {
				if (cur.data < cur.next.data) {
					int delNode = cur.data;
					deleteNode(delNode);
					flag = true;
					break;
				} else {
					cur = cur.next;
				}
			}

			if (!flag) {
				deleteLast();
			}
		}

	}

}
