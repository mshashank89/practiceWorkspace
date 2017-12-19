package xml;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;







import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class Test2 {

	public static void main2(String[] args) throws TransformerException, SAXException, IOException, ParserConfigurationException {
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new StringWriter());
		Node doc = getNode();
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String xmlString = result.getWriter().toString();
		System.out.println(xmlString);
		
	}
	
	
	private static Element getNode(){
		Element node = null;
		try {
			
			node = DocumentBuilderFactory
				    .newInstance()
				    .newDocumentBuilder()
				    .parse(new ByteArrayInputStream("<swe:frame   type=\"Tool bar\"  name =\"CTIToolbar\"     htmlAttr= \"class='siebui-tb-cti-container'\"/>".getBytes()))
				    .getDocumentElement();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return node;
	}
	
	
	
	
	
	public static void main4(String[] args) {
		String test1 = "<swe:frame   type=\"Toolbar\"  name =\"CTIToolbar\"   htmlAttr= \"class='siebui-tb-cti-container'\" />";
        String test2 = "<swe:frame  name =CTIToolbar  htmlAttr =   \"class='siebui-tb-cti-container'\" type = \" Tool bar\"  count   =   \"100  />";
        String test3 = "<swe:toolbar name=\"Custom-Settings\"/>";
        String test4 = "<swe:toolbar name=Custom-Settings  htmlAttr=class='siebui-tb-cti-container'  type=Toolbar/>";
        String test5 = " <swe:if condition=\"Web Engine State Properties, IsLoggedIn\"  />";
//		repairMissingQuotes(test1);
		repairMissingQuotes(test5);
	}
	
	private static void repairMissingQuotes(String s){
		
		//matches values with no quotes. Eg: type=value
		String regex = "((?<=[a-zA-Z0-9 ]=))([ ]*[a-zA-Z0-9-=']*)";
		
		
		
		String replaceRegex = "\"$2\"";
		
		
		
		String newStr = s.replaceAll(regex, replaceRegex);
		
		System.out.println(s + " -> \n" + newStr);
		
		
		//matches text after "="
		//((?<=[a-zA-Z]=).[a-zA-Z\s]*)
		
		//Expr to match valid attr-value pair
		//((([a-zA-Z]+\s*=\s*"[a-zA-Z]+")))
		
	}

	private static void repairMissingQuotesOld(String s){
		//([a-z]\w+)|([A-Z]\w+)|(\s[a-z]\w+)|(\s[A-Z]\w+)
		
		//(=\s*[a-zA-Z]\w+\s*)
		
//		String regex ="(=\\s*[a-zA-Z]\\w+\\s*)"; 
		
		//matches values with no quotes. Eg: type=value
		String regex = "((?<=[a-zA-Z0-9 ]=))([ ]*[a-zA-Z0-9]*[-]\\w+)";
		
		
		//matches value in type="value
		String regex2 = "((?<=[a-zA-Z0-9 ]=))([ ]*[\"][a-zA-Z0-9]*[-]\\w+)((?<=[\"]))*";
		
		//matches value in type=value"
		String regex3 = "((?<=[a-zA-Z0-9 ]=))([ ]*[a-zA-Z0-9]\\w+)[ ]*[\"]((?<=[\"]))*";
		
		String replaceRegex = "\"$2\"";
		String replaceRegex2 = "\"$2\"";
		String replaceRegex3 = "\"$2\"";
		
//		 s = "type=too  count=\"100\"  count=\"100\" type1=\"too  type2=too\" type2=too\" type2=too\" count=\"100\"  type2=too\" type   =\"too";
		
		
		String newStr = s.replaceAll(regex, replaceRegex);
		
		newStr = newStr.replaceAll(regex2, replaceRegex2);
		newStr = newStr.replaceAll("\" *\"", "\"");
		
		newStr = newStr.replaceAll(regex3, replaceRegex3);
		newStr = newStr.replaceAll("\" *\"", "\"");
		
		System.out.println(s + " -> \n" + newStr);
		
		
		//matches text after "="
		//((?<=[a-zA-Z]=).[a-zA-Z\s]*)
		
		//Expr to match valid attr-value pair
		//((([a-zA-Z]+\s*=\s*"[a-zA-Z]+")))
		
		
	}

}