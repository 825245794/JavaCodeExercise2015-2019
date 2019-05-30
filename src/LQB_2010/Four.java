package LQB_2010;

import java.util.Arrays;
import java.util.Scanner;

public class Four {
	Scanner input=new Scanner(System.in);
	int a[]=new int[4];
	String c=null;
	public Four(){
		c=input.next();
		sort(c,a);
		cal();
		input.close();
	}
	
	public void sort(String c,int a[]){
		for(int i=0;i<c.length();i++){
			a[i]=Integer.parseInt(String.valueOf(c.charAt(i)));
		}
	}
	
	public void cal(){
		Arrays.sort(a);
		int k=a[0]*1000+a[1]*100+a[2]*10+a[3];
		int j=a[3]*1000+a[2]*100+a[1]*10+a[0];
		System.out.print(j+"-"+k+"="+(j-k));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Four a=new Four();
	}

}
