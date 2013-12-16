package Model;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataAccessObject.OrderDAO;
import DataAccessObject.ProductDAO;
import DataAccessObject.UserDAO;
import XML.XMLOrderImporter;
import client.Configuration;
import client.Recipe;
import domain.Order;
import domain.Product;
import domain.User;


public class MesController {
	Product productOperator = new Product();
	ProductDAO productAccess = new ProductDAO();
	Order orderOperator = new Order();
	OrderDAO orderAccess = new OrderDAO();
	User userOperator = new User();
	UserDAO userAccess = new UserDAO();
	public static boolean scadaBusy = false;
	boolean serverAvailable;
	public static Queue<Recipe>	theQueue = new LinkedList<Recipe>();

	public Product getProduct(int productId){
		return productAccess.getProductById(productId);
	}
	
	
	public void processXML(File XMLFile){
		new XMLOrderImporter(XMLFile);
		System.out.println("Processed");
		
	}
	
	public List<Product> getAllProducts(){
		return productAccess.getAllProducts();
	}
	
	public void addOrder(Order myOrder){
		// Make a contructor class instead! PRI01
		orderAccess.addOrder(myOrder);
		
		Recipe myRecipe = new Recipe(myOrder, new Configuration(550, 400, 0, 25), productAccess.getProductById(myOrder.getProduct()).getName());
		theQueue.add(myRecipe);
		
	}
	
	
	
	// 
}
