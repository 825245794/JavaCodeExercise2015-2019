package ex7;

import java.util.Vector;
public class student {

	/**
	 * @param args
	 */
	Vector<String> a=new Vector<String>();
	public student()
	{
	a.add("NO.123456");
	a.add("Name:haha");
	a.add("85");
	a.add("96");
	a.add("25");
	}
	public void print()
	{
		for(String c:a)
		{
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student a=new student();
		a.print();
	}

}
