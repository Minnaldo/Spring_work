package ssafy.product;

public class ApplePhone implements IPhone {

	private int price;
	private Camera cam;
	public ApplePhone() {}
	
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
