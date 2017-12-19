package ds.string;

public class SubStringSearch {

	public static void main(String[] args) {
		
		String a = "01010210212901920192324923749324knlnafnkdsanfya927423543543b5kkknfdsay9fdsaf97979742957435435";
		String b = "af979797";
		
		int index = isSubString(a.toCharArray(), b.toCharArray());
		System.out.println("A length : " + a.length());
		System.out.println("B length : " + b.length());
		System.out.println("jdk output " + a.indexOf(b));
		System.out.println("Result : " + index);
	}
	
	private static int isSubString(char a[], char b[]){
		if (a.length > b.length){
			return isSubStringUtil(a, b);
		}
		
		return isSubStringUtil(b, a);
	}
	
	private static int isSubStringUtil(char a[], char[] b){
		int index = -1;
		
		int ai = 0;
		boolean found = false;
		
		while(!found){
			if (ai >= a.length){
				break;
			}
			
			while(ai < a.length && a[ai] != b[0]) ai++;
			
			int i=0;
			
			for(i=0;((ai + i) < a.length && i < b.length);i++){
				if (a[ai + i] != b[i]){
					break;
				}
			}
			
			if (i == b.length){
				found = true;
				index = ai;
				break;
			}
			ai++;
		}
		
		return index;
	}

}
