package ex4;

public class J_Teacher extends J_Human {
	int worktime;
	J_Teacher()
	{
		worktime=16;
		setAge(32);
		setName("haha");
		setSex("Woman");
	}
public void print()
{	
	System.out.println();
	System.out.println("Teacher");
	System.out.println("Name:"+getName());
	System.out.println("Age:"+getAge());
	System.out.println("Sex:"+getSex());
	System.out.println("Worktime:"+worktime);
	
}
}
