package ex9;

import java.util.Scanner;

public class P246_3 {

	/**
	 * @param args
	 */
	public void print()
	{
		Scanner input=new Scanner(System.in);
		System.out.print("输入第一个数：");
		System.out.print("");
		int a=input.nextInt();
		System.out.print("输入第二个数：");
		int b=input.nextInt();
		System.out.println("计算结果："+a+"+"+b+"="+(a+b));
		input.close();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P246_3 a=new P246_3();
		a.print();
	}

}
