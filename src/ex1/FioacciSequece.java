package ex1;

import java.util.Scanner;

public class FioacciSequece {
	static int a[];
	public static int f(int k){
		if(k==0)return 1;
		if(k==1){return 1;}
		if(k>1){
		if(a[k-2]==0){
			a[k-2]=f(k-2);
			return f(k-1)+f(k-2);
		}
		return f(k-1)+a[k-2];}
		return 0;
	}
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int q=input.nextInt();
		a=new int[q];
		System.out.print(f(q));
	}
}
