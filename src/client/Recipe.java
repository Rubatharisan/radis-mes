package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

import domain.Order;

public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order myOrder;
	private Configuration myConfig;
	private int orderQuantity;
	private String productName;
	
	public Recipe(Order myOrder, Configuration myConfig, String name){
		this.myOrder = myOrder;
		this.myConfig = myConfig;
		this.orderQuantity = myOrder.getQuantity();
		this.productName = name;
	}
	
	public void sendRecipe(){
		 String serverName = "10.126.60.222";
	      int port = 7999;
	      
	      try
	      {
	    	  
	         System.out.println("Connecting to " + serverName
	                             + " on port " + port);
	         Socket client = new Socket(serverName, port);
	         
	         System.out.println("Just connected to "
	                      + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out =
	                       new DataOutputStream(outToServer);
	         ObjectOutputStream objectOut = new ObjectOutputStream(outToServer);
	         objectOut.writeObject(this);
	      
	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}

	public Order getMyOrder() {
		return myOrder;
	}

	public void setMyOrder(Order myOrder) {
		this.myOrder = myOrder;
	}

	public Configuration getMyConfig() {
		return myConfig;
	}

	public void setMyConfig(Configuration myConfig) {
		this.myConfig = myConfig;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
