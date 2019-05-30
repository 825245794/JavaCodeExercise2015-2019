package ex1;

import java.util.Scanner;
import java.util.Vector;

public class Loop3_0920 {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int count=0;
	int sum=0;
	for(;;){
		int i=input.nextInt();
		if(i==0){
			break;
		}
		sum+=i;
		count++;
	}
	System.out.println("总和	:"+sum);
	System.out.println("平均值和	:"+((double)sum/(double)count));
}
}
