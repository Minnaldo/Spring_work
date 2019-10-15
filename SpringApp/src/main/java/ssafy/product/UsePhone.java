package ssafy.product;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePhone {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("/ssafy/phone/config/phonebean.xml");
//		BeanFactory factory = new AnnotationConfigApplicationContext(PhoneConfig.class);
		IPhone phone = (IPhone) factory.getBean("apple");
		phone.powerOn();
		phone.takePicture();
		phone.poWerOff();
		System.out.println(phone.howmuch());
		
		IPhone phone2 = (IPhone) factory.getBean("galaxy");
		phone2.powerOn();
		phone2.takePicture();
		phone2.poWerOff();
		System.out.println(phone2.howmuch());
		
		IPhone phone3 = (IPhone) factory.getBean("lg");
		phone3.powerOn();
		phone3.takePicture();
		phone3.poWerOff();
		System.out.println(phone3.howmuch());
		
	}

}
