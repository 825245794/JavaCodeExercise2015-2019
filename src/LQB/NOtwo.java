package LQB;

import java.util.Scanner;
	
public class NOtwo {
		static Scanner input=new Scanner(System.in);
		static int a=input.nextInt();
		static int price[]=new int[a];
		static int total[]=new int[a];
		static int num[]=new int[a];
		static int index=0;
		static int g=0;
	public static void f(int a,int b,int c){
		total[c]=a*b;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    
		for(int i=0;i<price.length;i++){
			price[i]=input.nextInt();
		}
	
		for(int i=a-1;i>-1;i--){
			index=i;
			
			for(int k=0;;k++){
				num[index]=k;
				f(price[index],num[index],index);
				for(int h:total){
					g+=h;
				}
				if(g==1000){
					for(int j=0;j<num.length;j++)
					System.out.println(num[a]);
				}
				else if(g>1000){
					break;
				}
				else if(g<1000){
					continue;
				}
			}
		}
		
	}

}
