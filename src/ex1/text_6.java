package ex1;

import java.util.Scanner;

public class text_6 {
		public static void main(String args[]){
			Scanner input=new Scanner(System.in);
			String a=input.next();
			int[] b=new int[a.length()];
			for(int i=0;i<a.length();i++){
				if(a.charAt(i)=='A'){ b[i]=10; continue;}
				if(a.charAt(i)=='B') { b[i]=11; continue;}
				if(a.charAt(i)=='C') { b[i]=12; continue;}
				if(a.charAt(i)=='D') { b[i]=13; continue;}
				if(a.charAt(i)=='E') { b[i]=14; continue;}
				if(a.charAt(i)=='F') { b[i]=15; continue;}
				b[i]=Integer.parseInt(String.valueOf(a.charAt(i)));
			}
			int p=a.length()-1;
			int k=0;
			for(int i=0;i<a.length();i++){
				k+=b[i]*Math.pow(16,p);
				p--;
			}
			System.out.println(k);
		}
	

}
