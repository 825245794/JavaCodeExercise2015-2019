package ex1;

import java.util.Scanner;

public class text {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		String a=input.next();
		String b="";
		for(int i=0;i<a.length();i++){
			if((int)(a.charAt(i))>96)
			{
				b+=String.valueOf((char)(a.charAt(i)-32));
				
			}
			else{
				b+=String.valueOf((char)(a.charAt(i)+32));
			}
		}
		System.out.print(b);
	}
}
