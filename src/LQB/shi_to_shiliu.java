package LQB;

import java.util.Scanner;

public class shi_to_shiliu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		String k="";
		int remain=0;
		if(a==0){k=String.valueOf(0);}
		while(a!=0){
			remain=a%16;
			a=a/16;
			if(remain==10){k+="A";continue;}
			if(remain==11){k+="B";continue;}
			if(remain==12){k+="C";continue;}
			if(remain==13){k+="D";continue;}
			if(remain==14){k+="E";continue;}
			if(remain==15){k+="F";continue;}
			k+=String.valueOf(remain);
		}
		for(int i=k.length()-1;i>-1;i--){
			System.out.print(k.charAt(i));
		}
	}

}
