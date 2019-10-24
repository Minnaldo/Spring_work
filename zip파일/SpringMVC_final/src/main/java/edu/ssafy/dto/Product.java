package edu.ssafy.dto;

public class Product {
	private String num;
	private String name;
	private String price;
	private String quantity;
	
	public Product() {	}
	public Product(String num, String name, String price, String quantity) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}