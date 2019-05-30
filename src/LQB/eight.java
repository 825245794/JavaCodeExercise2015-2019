package LQB;

import java.util.Scanner;

public class eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=a;
		input.close();
		while(b>=3){
			a+=b/3;
			b=b/3+b%3;
		}
		System.out.println(a);		
	}

}
