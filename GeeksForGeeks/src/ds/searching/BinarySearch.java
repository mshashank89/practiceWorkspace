package ds.searching;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,6,17,18,91};
		int x = 23230;
		
		int index = recSearch(arr, 0, arr.length-1, x);
		
		System.out.println("Recursive Result: " + index);
		
		index = search(arr, 0, arr.length-1, x);
		
		System.out.println("Non - Recursive Result: " + index);
	}

	public static int recSearch(int arr[], int l, int r, int x){
		//if l>r return -1 : key not found
		int index = -1;
		
		if (l > r){
			return index;
		}
		
		int mid = (l+r)/2;
		
		if (x == arr[mid]){
			index = mid;
		}
		
		if (x < arr[mid]){
			index = recSearch(arr, l, mid-1, x);
		}
		if (x > arr[mid]){
			index = recSearch(arr, mid+1, r, x);
		}
		
		return index;
	}
	
	public static int search(int arr[], int l, int r, int x){
		int index = -1;
		
		while(l <= r){
			int mid = (l+r)/2;
			
			if (x == arr[mid]){
				index = mid;
				break;
			}
			if (x < arr[mid]){
				r = mid - 1;
				continue;
			}
			if (x > arr[mid]){
				l = mid + 1;
				continue;
			}
			
		}
		
		return index;
	}
}
