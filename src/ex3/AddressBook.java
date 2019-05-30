package ex3;
public class AddressBook {
	private String Name;
	private String Address;
	private int tel;

	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public void getAllInfo()
	{
		
		System.out.println(Name);
		System.out.println(Address);
		System.out.println(tel);
		
	}
     

}