package ssafy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component(value="apple")
public class ApplePhone implements IPhone {
	
//	@Autowired
//	@Qualifier("cannoncam")
	private int price;
	private Camera cam;
	public ApplePhone() {}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public ApplePhone(Camera cam, int price) {
		this.cam = cam;
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("ApplePhone powerOn!!!");
	}

	public void poWerOff() {
		System.out.println("ApplePhone powerOff@@@");
	}
	
	public void takePicture() {
		this.cam.takePicture();
	}

	@Override
	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}


}
