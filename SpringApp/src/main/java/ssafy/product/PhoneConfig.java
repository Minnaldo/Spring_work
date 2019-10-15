package ssafy.product;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="ssafy.product")
public class PhoneConfig {
	//나중에 디비커넥션
//	public String getDBConnection() {
//		return "connected";
//	}
}
