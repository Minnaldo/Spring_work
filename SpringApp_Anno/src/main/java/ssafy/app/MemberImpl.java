package ssafy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mem")
public class MemberImpl implements IMember{
	private String name = "홍길동";
	private int age = 21;
	private String addr = "광산구";
	
	//Autowired가 BigMouse 타입을 자동으로 비교해서 객체 생성해서  넣어준다. 
	@Autowired()
	private BigMouse big;
	
	public void init() {
		System.out.println("init Member");
	}
	public void destroy() {
		System.out.println("Destroy Member");
	}
	
	public MemberImpl() {
		super();
	}
	
	public MemberImpl(String name, int age, String addr, BigMouse big) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.big = big;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public BigMouse getBig() {
		return big;
	}
	public void setBig(BigMouse big) {
		this.big = big;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + ", big=" + big + "]";
	}

	
	
	
}
