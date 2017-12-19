package tricky;

import java.util.ArrayList;

public class TestPow {

	public static void main(String[] args) {
		int sq = pow(10,6);
		System.out.println(sq);
		
		
	}
	
	public static int pow(int num, int pow){
		int sq = 1;
		
		for (int i=0;i<pow;i++){
			sq = sq * num;
		}
		return sq;
	}

}
