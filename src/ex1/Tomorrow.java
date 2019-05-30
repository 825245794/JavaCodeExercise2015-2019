package ex1;

import java.util.Scanner;

public class Tomorrow {
    int max=0;//储存该月份的最大日期
    int year=0;
    int month=0;
    int day=0;
    
    public Tomorrow(){
    	Scanner input=new Scanner(System.in);
    	String a=input.next();
    	String []s=a.split(",");
    	year=Integer.parseInt(s[0]);
    	month=Integer.parseInt(s[1]);
    	day=Integer.parseInt(s[2]);
    	input.close();
    	identity();
    	sumday();
    	sumyear();
    	System.out.println(year+","+month+","+day);
    }
    public void sumyear(){
    	if(month>12){
    		year++;
    		month=1;
    	}
    }
    public void sumday(){
    	if(day<max){
    		day=day+1;
    	}
    	else if(day>=max){
    		month++;
    		day=1;
    	}
    }
    
    public void identity(){
    	if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
    		max=31;
    	}
    	if(month==4||month==6||month==9||month==11){
    		max=30;
    	}
    	if(month==2){
    		if(year%4==0&&year%100!=0||year%400==0){
    			max=29;
    		}
    		else{
    			max=28;
    		}
    	}
    }
    public static void main(String[] args) {
		Tomorrow a=new Tomorrow();
	}
}
