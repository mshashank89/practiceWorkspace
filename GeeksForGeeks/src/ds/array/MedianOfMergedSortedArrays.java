package ds.array;

public class MedianOfMergedSortedArrays {

	/*
	 There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the 
	 array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)).
	 */
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		int b[] = {6,7,8,9,10};
		
		System.out.println(getMedian(a, b));

	}
	
	public static int getMedian(int a[], int b[]){
		int median = 0;
		int size = a.length, n=0;
		
		int ai=0,bi=0,temp=0, medianArr[] = new int[2];
		while(ai < size && bi < size){
			if (a[ai] <= b[bi]){
				temp = a[ai];
				ai++;
			}
			else {
				temp = b[bi];
				bi++;
			}
			n++;
			if (n == size){
				medianArr[0] = temp;
				continue;
			}
			if (n == size+1){
				medianArr[1] = temp;
				break;
			}
		}
		median = (medianArr[0] + medianArr[1])/2;
		return median;
	}

}
