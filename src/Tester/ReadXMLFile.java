package Tester;

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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {
	 
	  public static void main(String argv[]) {
	 
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			try {
				System.out.println("Welcome to interactive MES server");
				System.out.println("----------------------------");

				//Using factory get an instance of document builder
				DocumentBuilder db = dbf.newDocumentBuilder();

				//parse using builder to get DOM representation of the XML file
				Document dom = db.parse("RAD40OQ11.xml");
				dom.getDocumentElement().normalize();
//				System.out.println("Root element :" + dom.getDocumentElement().getNodeName());
				NodeList nList = dom.getElementsByTagName("b2mml:MaterialLot");
				
				// XML Get Time.
				String date = dom.getElementsByTagName("b2mml:PublishedDate").item(0).getTextContent();
				String ID = dom.getElementsByTagName("b2mml:ID").item(0).getTextContent();

				String[] dates = date.split("T");
				String xmlDate = dates[0];
				String xmlTime = dates[1].replace("Z", "");

				System.out.println("Order created: " + xmlDate + " @ " + xmlTime);
				
				System.out.println("----------------------------");
				 
//				for (int temp = 0; temp < nList.getLength(); temp++) {
//			 
//					Node nNode = nList.item(temp);
//			 
//					System.out.println("\nCurrent Element :" + nNode.getNodeName());
//			 
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						
//						Element eElement = (Element) nNode;
//						System.out.println("ID : " + eElement.getElementsByTagName("b2mml:ID").item(0).getTextContent());
//						System.out.println("Status : " + eElement.getElementsByTagName("b2mml:Status").item(0).getTextContent());
//						System.out.println("Quantity : " + eElement.getElementsByTagName("b2mml:QuantityString").item(0).getTextContent());
//						System.out.println("Data Type : " + eElement.getElementsByTagName("b2mml:DataType").item(0).getTextContent());
//						System.out.println("Unit of Measure : " + eElement.getElementsByTagName("b2mml:UnitOfMeasure").item(0).getTextContent());
//						System.out.println("Key : " + eElement.getElementsByTagName("b2mml:Key").item(0).getTextContent());
//			 
//					}
//				}
				
				System.out.println("DONE");

			}catch(ParserConfigurationException pce) {
				pce.printStackTrace();
			}catch(SAXException se) {
				se.printStackTrace();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
	  }
	 
	}
