package regex;

public class ChineseCharRegex {

	public static void main(String[] args) {
		String chineseRegex = "^[A-Za-z\\p{InCJK_UNIFIED_IDEOGRAPHS}]*$";
		String allRegex = "^\\p{L}[\\p{L}\\s]*\\p{L}$";
		String r1 = "([^0-9])+";
		
		String s4="HelloERمرحباERWERdwsdf汉sdf夜のコンサートは最高でしたkorean안녕하세요\\sdfsssssssssssssssssssss1";
		
		String s = "HelloERمرحباERWERdwsdf汉sdf夜のコンサートは最高でしたkorean안녕하세요\\";
		String s1= "汉字汉字汉字汉字汉字汉fasdsdf";
		String s2="!#!@#@!#!@#@!#wedfdfas汉汉汉";
		
		/*if (s.matches(r1)){
			System.out.println("matches");
		}
		else {
			System.out.println("Doesn't match");
		}
		*/
		if ("".matches("^(.)*$")){
			System.out.println("matches. Length = " + s4.length());
			
		}
		else {
			System.out.println("Doesn't match. Length = " + s4.length());
		}
		
		
		
	}

}
