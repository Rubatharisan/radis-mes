package client;

import domain.Order;

public class Recipe {
	private Order myOrder;
	private Configuration myConfig;
	private int orderQuantity;
	private String productName;
	
	public Recipe(Order myOrder, Configuration myConfig){
		this.myOrder = myOrder;
		this.myConfig = myConfig;
		this.productName = myOrder.getProductName(myOrder.getId());
		this.orderQuantity = myOrder.getQuantity();
	}
	
	void sendRecipe(){
		
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
