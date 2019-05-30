package ex4;

public class J_Student extends J_Human{
	int num;
	J_Student()
	{
		num=32;
		setName("liuyi");
		setAge(16);
		setSex("Boy");
	}
	public void print()
	{
		System.out.println();
		System.out.println("Student");
		System.out.println("Name:"+getName());
		System.out.println("Age:"+getAge());
		System.out.println("Sex:"+getSex());
		System.out.println("Number:"+num);
	}
}