package ssafy.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		//config.xml을 사용해서 하는법.
//		BeanFactory fac = new ClassPathXmlApplicationContext("/ssafy/spring/config/config.xml");
//		IMember mem = (IMember) fac.getBean("mem");
//		System.out.println(mem.toString());
		
		
		//Config.java 클래스 만들어서 어노테이션으로 값을 다 가져와서 끝내버림.
		BeanFactory fac = new AnnotationConfigApplicationContext(Config.class);
		
		IMember mem = (IMember) fac.getBean("mem");
		
		mem.setBig(new BigMouse("인호우공주"));
		System.out.println(mem.toString());
		
	}

}
