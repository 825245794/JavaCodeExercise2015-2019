package LQB_2016;

import java.util.Scanner;

public class NO8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,d,s;
		Scanner input=new Scanner(System.in);
		s=input.nextInt();
		 for(a=0;a<=Math.sqrt(s);a++) {
			            for(b=a;b<=Math.sqrt(s);b++) {
		                for(c=b;c<=Math.sqrt(s);c++) {
		                     for(d=c;d<=Math.sqrt(s);d++) {
		                        if(s == (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2) + Math.pow(d, 2))){
		                             System.out.println(a+" "+b+" "+c+" "+d);
			                           return;
		                        }
			                    }
		                }
		             }
			         }
	}

}
