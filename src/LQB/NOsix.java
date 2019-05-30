package LQB;

import java.util.Scanner;

public class NOsix {
	public static int f(int i){
		int k=0;
		for(;i%5==0;i=i/5)
		k++;
		return k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int k=0;
		for(int i=5;i<=a;i=i+5){
			k+=f(i);
			
		}
	
		System.out.println(k);
	}

}
