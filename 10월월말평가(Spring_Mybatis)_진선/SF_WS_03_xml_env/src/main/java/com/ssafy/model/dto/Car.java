package com.ssafy.model.dto;

public class Car {
	String num;
	String model;
	int price;
	String vcode;
	String vendor;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "Car [num=" + num + ", model=" + model + ", price=" + price + ", vcode=" + vcode + ", vendor=" + vendor
				+ "]";
	}
	
	
}
