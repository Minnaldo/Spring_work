package ssafy.product;

public class LgPhone implements IPhone {

	private int price;
	private Camera cam;
	
	public LgPhone() {
	}
	
	public LgPhone(int price, Camera cam) {
		super();
		this.price = price;
		this.cam = cam;
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgPhone powerOn###");
	}

	@Override
	public void poWerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgPhone powerOff###");
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		this.cam.takePicture();
	}

	@Override
	public int howmuch() {
		// TODO Auto-generated method stub
		return price;
	}

}
