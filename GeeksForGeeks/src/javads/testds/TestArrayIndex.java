package javads.testds;

public class TestArrayIndex {

	public static void main(String[] args) {
		int size = 10;
		int array[] = new int[size];
		Integer a2[] = new Integer[size];
		
		for (int i=0;i<size;i++){
//			array[i] = i;
			System.out.print(array[i] + "     ");
		}
		System.out.println();
		for (int i=0;i<size;i++){
//			array[i] = i;
			System.out.print(a2[i] + "  ");
		}
		
		int index = size -1;
		int n = array[index];
	}
}
