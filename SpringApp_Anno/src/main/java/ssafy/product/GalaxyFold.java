package ssafy.product;

public class GalaxyFold implements IPhone {

	private Camera cam;
	private int price;
	
	public GalaxyFold() {}
	
	public GalaxyFold(Camera cam, int price) {
		this.cam = cam;
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("GalaxyFold PowerOn");
	}

	@Override
	public void poWerOff() {
		// TODO Auto-generated method stub
		System.out.println("GalaxyFold PowerOff");
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
