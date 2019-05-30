package ex1;

import java.util.Scanner;

public class Tomorrow1 {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int y=s.nextInt();
	int m=s.nextInt();
	int d=s.nextInt();
	boolean f=false;
	if(m==4||m==6||m==9||m==11){
		if(d==30){
			f=true;
		}
		else{
			d++;
		}
	}
	else if(m==2){
		if(y%4==0&&y%100!=0||y%400==0){
			if(d==29){
				f=true;
			}
			else{
				d++;
			}
		}
		else{
			if(d==28){
				f=true;
			}
			else{
				d++;
			}
		}
	}
	else{
		if(d==31){
			f=true;
			if(m==12){
				m=0;
				y++;
			}
		}
		else{
			d++;
		}
	}
	
	if(f){
		m++;
		d=1;
	}
	System.out.println(y+","+m+","+d);
}

}
