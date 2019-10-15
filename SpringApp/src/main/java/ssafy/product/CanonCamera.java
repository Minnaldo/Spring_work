package ssafy.product;

import org.springframework.stereotype.Component;

public class CanonCamera implements Camera {

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		System.out.println("Cannon Camera 찰칵!!!");
	}

}
