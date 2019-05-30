package TEST;

import java.util.Scanner;

public class zhuceji {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("输入序列号");
		Scanner a=new Scanner(System.in);
		int i=a.nextInt();
		double j=(i+87654+12345)*3*4;
		System.out.println((int)j);
	}

}
