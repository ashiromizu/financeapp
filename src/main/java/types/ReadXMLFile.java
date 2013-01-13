package types;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

//taken from http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
//check and adapt to your code

public class ReadXMLFile {

public void readFile(){
	

		try {
			File fXMLFile = new File("expenses.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(fXMLFile);
			document.getDocumentElement().normalize();
	 
			
			System.out.println("Root element :" + document.getDocumentElement().getNodeName());
			NodeList nList = document.getElementsByTagName("expenses");
			System.out.println("-----------------------");
	 
			for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			   Node nNode = nList.item(temp);
			   
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) { // this ELEMENT_NODE command I don't understand what is it. How can you get which element to read
	 
			      Element eElement = (Element) nNode; //this is casting: Ask how would you code without it.
	 
			      System.out.println("uuid: " + getTagValue("uuid", eElement));
			      System.out.println("currency: " + getTagValue("currency", eElement));
		          System.out.println("amount: " + getTagValue("type", eElement));
			      System.out.println("date: " + getTagValue("date", eElement));
			      System.out.println("user: " + getTagValue("user", eElement));
			      System.out.println("type: " + getTagValue("type", eElement));
	 
			   }
			}
		  }
		catch (Exception e) {
			e.printStackTrace();
		  }
	  }
	 
	  private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	        Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	  }
	 
}
	
