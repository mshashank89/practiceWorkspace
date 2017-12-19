package regex;

public class TestRegex {
	
    private static final String NUMBER_REGEX = "[0-9]";
    private static final String OPERATOR_REGEX = "[+\\-*\\/]";
    
    private String s;
	public static void main(String[] args) {
		
		System.out.println("isNum('0')" + isNum('0'));
		System.out.println("isOperator('0')" + isOperator('0'));
		System.out.println("isOperator('=')" + isOperator('='));
		System.out.println("isNum('=')" + isNum('='));
		System.out.println("isOperator('+')" + isOperator('+'));
		System.out.println("isOperator('-')" + isOperator('-'));
		System.out.println("isOperator('*')" + isOperator('*'));
		System.out.println("isOperator('/')" + isOperator('/'));

		String s = "hi";
		TestRegex t = new TestRegex();
		t.test(t);
		System.out.println(t.s);
	}
	
	
	private void test (TestRegex t){
		t.s = "hello";
	}
	

	private static boolean isNum(char c){
		String s = String.valueOf(c);
		
		return s.matches(NUMBER_REGEX);
	}
	
	private static boolean isOperator(char c){
		String s = String.valueOf(c);
		
		return s.matches(OPERATOR_REGEX);
	}
}
