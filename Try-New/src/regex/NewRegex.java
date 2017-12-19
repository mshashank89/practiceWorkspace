package regex;

public class NewRegex {

	public static void main(String[] args) {
		String test1 = "<swe:frame   type=\"Toolbar\"  name =\"CTIToolbar\"   htmlAttr= \"class='siebui-tb-cti-container'\" />";
		String test2 = "<swe:frame  name =CTIToolbar  htmlAttr =   \"class='siebui-tb-cti-container'\" type = \" Tool bar\"  count   =   \"100  />";
		String test3 = "<swe:toolbar name=\"Custom-Settings\"/>";
		String test4 = "<swe:toolbar name=Custom-Settings  htmlAttr=class='siebui-tb-cti-container'  type=Toolbar/>";

		// repairMissingQuotes(test1);
		repairMissingQuotes(test4);
	}

	private static void repairMissingQuotes(String s) {

		// matches values with no quotes. Eg: type=value
		String regex = "((?<=[a-zA-Z0-9 ]=))([ ]*[a-zA-Z0-9-=']*)";

		String replaceRegex = "\"$2\"";

		String newStr = s.replaceAll(regex, replaceRegex);

		System.out.println(s + " -> \n" + newStr);

		// matches text after "="
		// ((?<=[a-zA-Z]=).[a-zA-Z\s]*)

		// Expr to match valid attr-value pair
		// ((([a-zA-Z]+\s*=\s*"[a-zA-Z]+")))

	}

}
