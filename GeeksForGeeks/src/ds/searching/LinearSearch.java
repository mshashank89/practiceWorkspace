package ds.searching;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int search(int arr[], int x){
		int size = arr.length;
		for (int i=0;i<size;i++){
			if (arr[i] == x){
				return i;
			}
		}
		return -1;
	}

}
