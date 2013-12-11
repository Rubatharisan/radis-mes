package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	private int id;
	private String name;
	private int eta;
	private int available;
	
	public Product(){
		this.id = 0;
		this.name = null;
		this.eta = 0;
		this.available = 0;
	}
	
	public Product(String name, int eta, int available){
		this.name = name;
		this.eta = eta;
		this.available = available;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	

}
