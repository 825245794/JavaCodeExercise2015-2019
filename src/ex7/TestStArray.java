package ex7;

import java.util.Scanner;


public class TestStArray {

	/**
	 * @param args
	 */
	static int[] a=new int[3];

	public void print()
	{
		int k=0;
		for(int c:a)
		{
			System.out.println(c);
		   k+=c;
		}
		System.out.println("Æ½¾ùÖµ"+k/3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		TestStArray b=new TestStArray();
		for(int i=0;i<3;i++)
		{
			System.out.println("input NO."+(i+1));
			a[i]=input.nextInt();
		}
		b.print();
		input.close();
	}

}
