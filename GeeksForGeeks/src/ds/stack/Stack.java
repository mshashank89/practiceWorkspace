package ds.stack;

public class Stack {
	
	private int size;
	private int curIndex;
	private int noOfElements;
	private int[] stk;
	
	public Stack (int size){
		this.size = size;
		stk = new int[size];
		curIndex = -1;
		noOfElements = 0;
	}
	
	public void push(int num){
		if (curIndex >= size){
			System.out.println("Stack full");
			return;
		}
		stk[++curIndex] = num;
		noOfElements++;
	}
	
	public int pop(){
		if (curIndex < 0){
			System.out.println("Stack empty");
			return Integer.MIN_VALUE;
		}
		noOfElements--;
		return stk[curIndex--];
	}
	
	public int getNoOfElements(){
		return noOfElements;
	}

}
