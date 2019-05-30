package ex1;

import java.util.Scanner;

public class searchstring {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner input=new Scanner(System.in);
			int q=input.nextInt();
			int tol=65;
			String a[]=new String[26];
			String s="";
			for(int i=0;i<q;i++){
				if(i==q)break;
				if(i==0){
						s+=String.valueOf((char)tol);
						a[i]=s;
						tol++;
				}
				else{
						s=a[i-1]+String.valueOf((char)tol)+a[i-1];
						a[i]=s;
						tol++;
				}
			}
			System.out.println(s);
		}
	 }

