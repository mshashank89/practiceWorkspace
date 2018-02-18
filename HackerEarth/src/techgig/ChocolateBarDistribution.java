package techgig;

public class ChocolateBarDistribution {

	public static void main(String[] args) {
		System.out.println(cadbury(5,6,3,4));
	}
	
	public static int cadbury(int m,int n,int p,int q)
    {
        int totalCount = 0;
        for (int i=m;i<=n;i++) {
            for (int j=p;j<=q;j++) {
                totalCount += count(i,j);
            }
        }
        return totalCount;
    }
    
    public static int count(int length, int breadth) {
        int count = 0;
		
		int l = Math.max(length, breadth);
		int b = Math.min(length, breadth);
		while (breadth > 0) {
			
			l = l - b;
			
			breadth = Math.min(l, b);
			length = Math.max(l, b);
			l = length;
			b = breadth;
			
			count++;
		}
		
		return count;
    }

}
