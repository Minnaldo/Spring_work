package app;

public interface IMember {

	
	public String getName();

	public void setName(String name);

	public int getAge();

	public void setAge(int age);

	public String getAddr();

	public void setAddr(String addr);
	
	public void getBig(BigMouse big);
	
	public void setBig(BigMouse big);
	
	
	@Override
	public String toString();
	
}
