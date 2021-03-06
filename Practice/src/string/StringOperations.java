package string;

public class StringOperations {

	public static void main(String[] args) {
//		removeDuplicates("Helllloooowo".toCharArray());
		replaceNewLine();
//		replaceSpaces("Hello how are you ? ");
	}

	private static void replaceNewLine() {
        String value = "Rule Name: New Rule\n" + 
        "Logic: \n" + 
        "    IF\n" + 
        "        [Amount] \u2265 0.00\n" + 
        "    THEN DO\n" + 
        "        Assign Points\n" + 
        "            Point Type: Normal\n" + 
        "            Point Sub Type: Bonus\n" + 
        "            Qualified Points: No\n" + 
        "            Attribute: 13.00\n" + 
        "            Expiration Period: 29\n" + 
        "            Period UOM: Quarters\n" + 
        "            Expiry Adjustment: 1st Day of Next Year\n" + 
        "            Notes: \"\"\n" + 
        "\n" + 
        "Rule Name: Assign Voucher\n" + 
        "Logic: \n" + 
        "    IF\n" + 
        "        [Amount] \u2265 0.00\n" + 
        "    THEN DO\n" + 
        "        Assign Voucher - Percentage\n" + 
        "            Product: Pro 400\n" + 
        "            Quantity: 2\n" + 
        "            Start Date: 10/27/2017 4:25 AM\n" + 
        "            Expiration Period: 23\n" + 
        "            Period UOM: Quarters\n" + 
        "            Expiry Adjustment: 1st Day of Next Year\n" + 
        "            Percent: 23.00\n" + 
        "            Notes: \"\"\n";
        
        value = value.replaceAll("\n", "\n<br/>");
        System.out.println(value);
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		
		
		System.out.println(str);
	}
	
	
	public static void replaceSpaces(String str){
		ReplaceSpaces r = new ReplaceSpaces(str);
		
		System.out.println(r.replaceSpace());
	}

	private static class ReplaceSpaces
	{
		private int spaceCount;
		private char [] newStr;
		private char[] str;
		
		private ReplaceSpaces(String s){
			str = s.toCharArray();
			spaceCount();
			newStr = new char[str.length + spaceCount*2];
		}
		
		private void spaceCount(){
			for (char c : str){
				if (c == ' '){
					spaceCount ++;
				}
			}
		}
		
		public String replaceSpace(){
			int j=0;
			for (int i=0;i<str.length;i++){
				if (str[i] == ' '){
					newStr[j++] = '%';
					newStr[j++] = '2';
					newStr[j++] = '0';
				}
				else{
					newStr[j++] = str[i];
					
				}
			}
			
			
			return String.valueOf(newStr);
		}
	}
}
