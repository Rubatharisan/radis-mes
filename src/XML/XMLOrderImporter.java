package XML;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import DataAccessObject.ProductDAO;
import Model.MesController;
import domain.Product;

public class XMLOrderImporter {
	private String orderDate;
	private Product product;
	private String orderStatus;
	private int orderQuantity;
	private int quantityWaste = 10;
	
	public XMLOrderImporter(File XMLFile){
		MesController myController = new MesController();
		ProductDAO proDAO = new ProductDAO();
		
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
				
				// get Product ID and set
				String elementProductInfo = eElement.getElementsByTagName("b2mml:ID").item(0).getTextContent();
				String[] elementProductInfos = elementProductInfo.split("O");
				Product product = proDAO.getProductById(Integer.valueOf(elementProductInfos[0]));
				
				// get Order Date and set it, awaiting approval - added with 2 days. 
				String timeStamp = new SimpleDateFormat("dd-MM-yy").format(Calendar.getInstance().getTime());
				
				Calendar c = Calendar.getInstance();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				try {
					c.setTime(sdf.parse(timeStamp));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.add(Calendar.DATE, 2);  // number of days to add
				timeStamp = sdf.format(c.getTime());  // dt is now the new date
				orderDate = timeStamp;
				
				// get Quantity and set it.
				int orderQuantityX = Integer.valueOf(eElement.getElementsByTagName("b2mml:QuantityString").item(0).getTextContent());
				
				
				// add waste. (Missing implementation)
				orderQuantity = orderQuantityX;
				System.out.println(orderQuantity);
				
				// get order status and set it
				orderStatus = eElement.getElementsByTagName("b2mml:Status").item(0).getTextContent();
				System.out.println(orderStatus);
				
				
			}
			try {
				myController.addOrder(product, orderQuantity, orderDate, null);
			} finally {
				System.out.println("Ok");
			}
		}


	}
	
}
