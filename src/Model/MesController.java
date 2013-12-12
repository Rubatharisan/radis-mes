package Model;
import java.util.Date;

import DataAccessObject.OrderDAO;
import domain.Order;
import domain.Product;


public class MesController {
	void processOrder(String XMLDocumentPath){
		
	}
	
	public void addOrder(Order order){
		// Make a contructor class instead! PRI01
		OrderDAO orderDao = new OrderDAO();
		orderDao.addOrder(order);
	
	}
	
}
