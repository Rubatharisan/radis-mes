

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import domain.Order;
import domain.Product;
import domain.User;
import DataAccessObject.OrderDAO;
import DataAccessObject.ProductDAO;
import DataAccessObject.UserDAO;
import Sandbox.CRUD;
import Sandbox.Listener;
import Sandbox.LxmlReceiver;
import XML.XMLOrderImporter;

public class Main {
	
	public static void main(final String[] args){
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

//		User user = new User();
//		user.setEmail("Rubatharisan");
//		user.setUsername("Rubas");
//		
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		
//		try{
//			session.save(user);
//			session.beginTransaction();
//			session.getTransaction().commit();
//			
//		} catch (Exception exp){
//			session.getTransaction().rollback();
//		} finally {
//			session.close();
//			sessionFactory.close();
//		}
//		
////		// Read
////		User myuser = (User) session.load(User.class, 11);
////		System.out.println(myuser.getEmail());
//		
//		System.out.println("Done?");

//		User hi = new User();
//		hi.setUsername("Hi");
//		dao.addUser(hi);
//		
//		UserDAO dao = new UserDAO();
//		User k = new User();
//		k.setEmail("Rubatharisan@gmail.com");
//		k.setUsername("Rubas");
//		dao.addUser(k);
//		System.out.println("Added " + k.getUsername());
//		if(!dao.getAllUsers().isEmpty()){
//			for (User iter : dao.getAllUsers()) {
//	            System.out.println(iter.getUsername());
//	            dao.deleteUser(iter.getId());
//	            System.out.println("Deleted " + iter.getId());
//	        }
//		} else {
//			System.out.println("List empty");
//		}
		
//		CRUD action = new CRUD();
//		
//		action.create("Rubas", "Rubaatharisan@gmail.com");
//		action.create("kk", "aad");
//		action.delete(49);
//		
//		User xo = new User();
//		xo.setEmail("Rubas");
//		
//		OrderDAO orderDao = new OrderDAO();
//		Order one = new Order();
//		one.setProduct(7);
//		orderDao.addOrder(one);
//		
//		ProductDAO productDAO = new ProductDAO();
//		System.out.println();
//		
//		for (Product iter : productDAO.getAllProducts()) {
//			System.out.println(iter.getName());
//		
//		}
//		

//		Order tmpOrder = new Order();
//		OrderDAO dao1 = new OrderDAO();
//		tmpOrder.setProduct(6);
//		tmpOrder.setQuantity(5);
//		dao1.addOrder(tmpOrder);
//		
//		for(int i = 0; i<10; i++){
//			System.out.println("Hello");
//			tmpOrder.setProduct(6);
//			tmpOrder.setQuantity(i);
//			dao1.addOrder(tmpOrder);
//			System.out.println("Added");
//
//		}
//		
//		tmpOrder.setQuantity(4);
//		tmpOrder.setProduct(ohMy.getName());
//		dao1.addOrder(tmpOrder);
//		
//		ProductDAO dao = new ProductDAO();
//		Product Radis = dao.getProductById(8);
//		System.out.println(Radis.getEta());
		
//		for (Product iter : productDAO.getAllProducts()) {
//			System.out.println(iter.getName());
//		
//		}	
//		
//		Order nyOrdre = new Order();
//		nyOrdre.setQuantity(3);
//		nyOrdre.setProduct(5);
//		dao1.addOrder(nyOrdre);
		
//		for (Order order : dao1.getAllOrders()){
//			System.out.println("Order ID: " + order.getId() + " Product: " + dao.getProductById(order.getProduct()).getName() + "(" + dao.getProductById(order.getProduct()).getId() + ")");
//		}
//		
//		Product getMyProduct = dao.getProductById(8);
//		System.out.println(getMyProduct.getName());
//		getMyProduct.setId(15);
//		dao.updateProduct(getMyProduct);
//		
		
//		Product hi = new Product("BjønsNosser", 1, 3);
//		ProductDAO dao = new ProductDAO();
//		dao.addProduct(hi);
//		
		File fXmlFile = new File("src/12OQ1.xml");

		XMLOrderImporter disOne = new XMLOrderImporter(fXmlFile);
		
	}
}
