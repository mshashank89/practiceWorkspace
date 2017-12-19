import java.util.Scanner;


public class TestSample {

	
	
	public static void main1(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		
		
		System.out.println("Before:");
		for (int i : a){
			System.out.print(i + " ");
		}
		
		moveProcess(a,8,1);
		
		System.out.println("After:");
		for (int i : a){
			System.out.print(i + " ");
		}
		
	}
    
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i=1;i<6;i++){
			sum+=i*(6-i);
		}
		char a = 'a';
		char A = 'A';
		char z = 'z';
		char Z = 'Z';
		
		int a1 = a;
		int z1 = z;
		int A1 = A;
		int Z1 = Z;
		
		System.out.println("a: " + a1);
		System.out.println("z: " + z1);
		System.out.println();
		System.out.println("A: " + A1);
		System.out.println("Z: " + Z1);
		
	}
	
	public static int square(int n){
		System.out.println(n + " * " + n);
		return n*n;
	}
    
    public static void main3(String args[] ) throws Exception {
        

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        int[] callingOrder = new int[t];
        int[] idealOrder = new int[t];
        
        for (int i = 0; i < t; i++) {
        	callingOrder[i] = s.nextInt();
        }
        
        for (int i = 0; i < t; i++) {
        	idealOrder[i] = s.nextInt();
        }
        
        int count = 0;
        boolean flag = true;
        
        for (int i=0;i<t;i++){
    		for (int j=0;j<t;j++){
    			
//    			if(i==0) continue;
    			if (idealOrder[i] == callingOrder[j]){
    				
    				System.out.println("Calling move: from: " + j + " to: " + i);
    				System.out.println("Calling move: from: " + callingOrder[j] + " to: " + callingOrder[i]);
    				System.out.print("Before:   ");
    				print(callingOrder);
    				
    				
    				count+=moveProcess(callingOrder,j,i);
    				
    				System.out.print("After:    ");
    				print(callingOrder);
    				System.out.print("Target:   ");
    				print(idealOrder);
    				System.out.println("Increment in count: " + (j-i));
    				System.out.println("--------------\n");
    			}
    		}
    	}
        /*while (flag){
        	
        	for (int i=0;i<t;i++){
        		int c = 0;
        		for (int j=0;j<t;j++){
        			if (idealOrder[i] == callingOrder[j]){
        				c++;
        			}
        		}
        		if (c == t){
        			flag = false;
        		}
        	}
        }
    	*/
        System.out.println(t+count);

        
    }
    
    
    private static int moveProcess(int[] a, int from, int to){
    	int processNum = a[from];    	
    	
    	
    	if (to>=from){
    		return 0;
    	}
    	
    	for (int i=from;i>to;i--){
    		a[i] = a[i-1];
    	}
    	
    	a[to] = processNum;
    	return 1;
    }
    
    private static void print(int[] a){
    	for (int i : a){
    		System.out.print(i + " ");
    	}
    	
    	System.out.println();
    }
    

}