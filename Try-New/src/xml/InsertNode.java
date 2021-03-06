package xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.nio.channels.FileChannel;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InsertNode {
	
	private static final String FILEPATH = "./src/xml/TestFile.xml";
	
	private static final String CONFIG_NODE_NAME = "emGatewayConfig";

	public static void main(String[] args) throws IOException, TransformerFactoryConfigurationError, TransformerException {

		printFile();
		
		/*String nameValue = getNodeValues("emGatewayConfig", "name");
		String portValue = getNodeValues("emGatewayConfig", "port");
		
		System.out.println(nameValue);
		System.out.println(portValue);*/
		
		String str = "<emGatewayConfig\nconfig-class=\"oracle.communication.brm.charging.appconfiguration.beans.emgateway.EMGatewayConfiguration\"\n            name=\"emGateway1\"\n            port=\"15503\"\n            threadPoolSize=\"10\"\n            sslEnabled=\"0\"\n            wallet=\"\"\n            clientAuthenticationEnabled=\"0\"/>";
		long offset = getOffSet();
		
		System.out.println(offset);
		insert(FILEPATH, offset, str.getBytes());
		
		printFile();
	}
	
	public static void insert(String filename, long offset, byte[] content)
			throws IOException {
		RandomAccessFile r = new RandomAccessFile(new File(filename), "rw");
		RandomAccessFile rtemp = new RandomAccessFile(new File(filename + "~"),
				"rw");
		long fileSize = r.length();
		FileChannel sourceChannel = r.getChannel();
		FileChannel targetChannel = rtemp.getChannel();
		sourceChannel.transferTo(offset, (fileSize - offset), targetChannel);
		sourceChannel.truncate(offset);
		r.seek(offset);
		r.write(content);
		long newOffset = r.getFilePointer();
		targetChannel.position(0L);
		sourceChannel.transferFrom(targetChannel, newOffset,
				(fileSize - offset));
		sourceChannel.close();
		targetChannel.close();
	}
	
	private static long getOffSet() throws IOException{
		FileInputStream fstream = new FileInputStream(FILEPATH);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		StringBuffer sb = new StringBuffer();

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine);
			sb.append("\n");
		}

		
		// Close the input stream
		br.close();
		
		long offSet = sb.toString().lastIndexOf("</emGatewayConfigurationList>");
		return offSet;
		
		
	}

	/*private static String getNodeValues(String node, String attribute) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new StringWriter());
		Node emConfigNode = getNode(node);
		
		return emConfigNode.getAttributes().getNamedItem(attribute).getNodeValue();
		
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String xmlString = result.getWriter().toString();
		System.out.println(xmlString);
		
	}
	*/
	private static Node getNode(String node){
		NodeList nodeList = null;
		try {
			
			nodeList = DocumentBuilderFactory
				    .newInstance()
				    .newDocumentBuilder()
				    .parse(new ByteArrayInputStream(getXMLString()))
				    .getElementsByTagName(node);
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
		
		Node node1 = nodeList.item(0);
		
		return node1;
	}

	
	
	private static byte[] getXMLString() throws FileNotFoundException, IOException {
		FileInputStream fstream = new FileInputStream(FILEPATH);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		StringBuffer sb = new StringBuffer();

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine);
			sb.append("\n");
		}
		
		// Close the input stream
		br.close();
		
		return sb.toString().getBytes();
	}

	
	
	
	private static void printFile() throws FileNotFoundException, IOException {
		FileInputStream fstream = new FileInputStream(FILEPATH);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		StringBuffer sb = new StringBuffer();

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine);
			sb.append("\n");
		}

		
		System.out.println(sb.toString());
		// Close the input stream
		br.close();
	}

	

}
