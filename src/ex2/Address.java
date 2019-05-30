package ex2;

public class Address {
	private String name;
	private String address;
	private int tel;
	public String getname()
	{
		return name;
	}
	public String getaddress()
	{
		return address;
	}
	public int gettel()
	{
		return tel;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public void setaddress(String address)
	{
		this.address=address;
	}
	public void settel(int tel)
	{
		this.tel=tel;
	}
	public void getinfo()
	{
		Address s=new Address();
		s.setname("zhangsan");
		s.setaddress("guangdong");
		s.settel(123455);
		System.out.println("姓名:"+s.getname());
		System.out.println("地址:"+s.getaddress());
		System.out.println("电话:"+s.gettel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Address s=new Address();
s.getinfo();

	}

}
