package ex9;

import java.util.Scanner;

public class chartodouble {

	/**
	 * @param args
	 */
	String a;
	char []str;
	double b=0;
	public void print()
	{
		
		Scanner input=new Scanner(System.in);
		a=input.next();
		char[] str=new char[a.length()];
		for(int i=0;i<a.length();i++)
		{
			str[i]=a.charAt(i);
		}
		for(char c:str)
		{
			b+=(double)c;
		}
		System.out.print(b);
		input.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chartodouble a=new chartodouble();
		
		try{
		a.print();
		}
		catch(Exception e){
			System.out.print(e);
		}
	}

}
