package Model;
import java.util.List;

import DataAccessObject.OrderDAO;
import DataAccessObject.ProductDAO;
import DataAccessObject.UserDAO;
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
	
	public Product getProduct(int productId){
		return productAccess.getProductById(productId);
	}
	
	public void processXML(){
		
	}
	
	public List<Product> getAllProducts(){
		return productAccess.getAllProducts();
	}
	
	public void addOrder(Order order){
		// Make a contructor class instead! PRI01
		OrderDAO orderDao = new OrderDAO();
		orderDao.addOrder(order);
	
	}
	
}
