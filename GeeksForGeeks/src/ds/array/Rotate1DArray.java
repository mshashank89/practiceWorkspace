package ds.array;

public class Rotate1DArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		for(int i : a){
			System.out.print(i + "   ");
		}
		System.out.println("\nAfter rotation ");
		rotateLeft(a,3);
		for(int i : a){
			System.out.print(i + "   ");
		}
		
		rotateRight(a, 1);
		System.out.println("\nRotate right : ");
		for(int i : a){
			System.out.print(i + "   ");
		}
	}

	
	public static void rotateRight(int a[], int n){
		rotateLeft(a, a.length-n);
	}
	
	
	public static void rotateLeft(int a[], int n){
		int size = a.length;
		
		n = n > size ? n%size : n;
		
		int temp[] = new int[n];
		for (int i=0;i<n;i++){
			temp[i] = a[i]; 
		}
		
		for (int i=0;i<size-n;i++){
			a[i] = a[(i+n)%size];
		}
		
		for (int i=0;i<n;i++){
			a[size-n + i] = temp[i];
		}
	}
}
