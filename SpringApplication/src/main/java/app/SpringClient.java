package app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * //자바 프레임워크 짤 때 이렇게 객체 생성해서 함. Member m = new Member();
		 * System.out.println(m.toString());
		 */
		
		BeanFactory cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
		System.out.println("BeanFactory 생성");
//		IMember mem1 = cxt.getBean(MemberImpl.class);
//		System.out.println("Member 가져오기");
//		System.out.println(mem1.toString());
		//원래는 Client에 저장되어 있는 값인, 홍길동이 나와야 하지만,
		//applicationContext에서 생성자에 고길동,41,쌍문동  값을 넣어줘서 값이 수정되었다.
		
		
//		mem1.setName("둘리");
//		//applicationContext.xml 에  scope="Prototype"이라면 객체 생성을 두 번 한다.
//		//						   scope="Singletone"이라면 객체 생성 한 번으로 한다.
//		Member mem2 = (Member) cxt.getBean("mem");	//(Member)로 다운캐스팅.
//		System.out.println(mem2.toString());
		
		IMember mem2 = (IMember) cxt.getBean("mem");
		System.out.println(mem2.toString());
		
	}

}
