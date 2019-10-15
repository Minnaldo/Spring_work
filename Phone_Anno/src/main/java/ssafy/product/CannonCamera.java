package ssafy.product;

import org.springframework.context.annotation.Configuration;

@Configuration("cannoncam")
public class CannonCamera implements Camera {

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		System.out.println("Cannon Camera 찰칵 뿌잉뿌잉");
	}

}
