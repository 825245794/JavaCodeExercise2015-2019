package ex1;

import java.util.Scanner;
import java.util.Vector;

public class Arraydel {
	static String[] v;
	public static void f(String c,int j){
		for(int i=0;i<v.length;i++){
			if(i==j)continue;
			if(v[i]==null)continue;
			if(v[i].equals(c))v[i]=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		v=new String[a];
		for(int i=0;i<a;i++){
			v[i]=input.next();
		}
		for(int i=0;i<v.length;i++){
			if(v[i]!=null)
			f(v[i],i);
		}
    int p=0;
   for(int i=0;i<v.length;i++){
			if(v[i]!=null)p++;
		}
		System.out.println(p);
	}

}
