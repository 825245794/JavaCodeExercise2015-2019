package ex1;

import java.util.*;
public class text_1
{
	static String o1;
	public static void f(int n){
		
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
				for(int k=0;k<10;k++){
				for(int a=0;a<10;a++){
				for(int b=0;b<10;b++){
					o1=String.valueOf(i)+j+k+a+b;
					if (i+j+k+a+b==n&&q1(o1)==true){
						System.out.println(o1);
					}
					for(int c=0;c<10;c++){
						o1=String.valueOf(i)+j+k+a+b+c;
						
						if (i+j+k+a+b+c==n&&q(o1)==true){
							System.out.println(o1);
						}
					}
				
			}
			}
			}
			}
			}
		
	}
	
	public static boolean q(String o){
		
		
		if(o.charAt(2)==o.charAt(3)&&o.charAt(0)==o.charAt(5)&&o.charAt(1)==o.charAt(4)){
			return true;}
		
		
		return false;
		
			
	}
public static boolean q1(String o){
		
		if(o.charAt(0)==o.charAt(4)&&o.charAt(1)==o.charAt(3)){	
			return true;}
		return false;
		
			
	}
	
    public static void main(String args[])
    {	
			Scanner input=new Scanner(System.in);
			int a=input.nextInt();
			f(a);
			
		}
}