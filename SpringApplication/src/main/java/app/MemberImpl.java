package app;

public class MemberImpl implements IMember{
	private String name = "홍길동";
	private int age = 21;
	private String addr = "광산구";
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
	
	public void getBig(BigMouse big) {
		
	}
	
	public void setBig(BigMouse big) {
		
	}
	
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + ", big=" + big + "]";
	}

	
	
	
}
