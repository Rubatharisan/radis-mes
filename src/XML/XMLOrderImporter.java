package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.Product;

public class XMLOrderImporter {
	private int productId;
	private String orderDate;
	private Product productID;
	private String orderStatus;
	private int orderQuantity;
	
	
	public XMLOrderImporter(File XMLFile){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document doc = null;
		try {
			doc = dBuilder.parse(XMLFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("b2mml:MaterialInformation");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			Node nNode = nList.item(temp);
	 
			System.out.println("@MES> Added new order <");
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				
				System.out.println("->ID : " + eElement.getElementsByTagName("b2mml:ID").item(0).getTextContent());
				System.out.println("->Description : " + eElement.getElementsByTagName("b2mml:Description").item(0).getTextContent());
				System.out.println("->PublishedDate : " + eElement.getElementsByTagName("b2mml:PublishedDate").item(0).getTextContent());
				System.out.println("->Material:ID : " + eElement.getElementsByTagName("b2mml:MaterialLot").item(0).getChildNodes().item(0).getTextContent());
				System.out.println("->Material:Status : " + eElement.getElementsByTagName("b2mml:MaterialLot").item(0).getChildNodes().item(1).getTextContent());
				System.out.println("->Material:Quantity : " + eElement.getElementsByTagName("b2mml:MaterialLot").item(0).getChildNodes().item(2).getChildNodes().item(0).getTextContent());
				System.out.println("->ID : " + eElement.getElementsByTagName("b2mml:ID").item(0).getTextContent());

				// get Product ID and set
				String elementProductInfo = eElement.getElementsByTagName("b2mml:ID").item(0).getTextContent();
				String[] elementProductInfos = elementProductInfo.split("O");
				productId = Integer.valueOf(elementProductInfos[0]);
				

	 
			}
		}


	}
	
}
