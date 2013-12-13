package Model;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import server.Server;
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
	
//	public boolean getActive(){
//		new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Server serv = null;
//				try {
//					serv = new Server();
//					serv.start();
//
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				while(true){
//					if(serv.isBusy()){
//						System.out.println("Hi?");
//						scadaBusy = true;
//					} else {
//						System.out.println("No");
//						scadaBusy = false;						
//					}
//					try {
//						Thread.sleep((long) 1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//			
//			
//		}.run();
//		return scadaBusy;
//	}
	
	public void processXML(File XMLFile){
		new XMLOrderImporter(XMLFile);
		System.out.println("Processed");
		
	}
	
	public List<Product> getAllProducts(){
		return productAccess.getAllProducts();
	}
	
	public void addOrder(Order order){
		// Make a contructor class instead! PRI01
		OrderDAO orderDao = new OrderDAO();
		orderDao.addOrder(order);
		
		Recipe myRecipe = new Recipe(order, new Configuration(550, 400, 0, 25), productAccess.getProductById(order.getProduct()).getName());
		theQueue.add(myRecipe);
		
	}
	

	
	
	// 
}
