package xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class ModifyXML {
	
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