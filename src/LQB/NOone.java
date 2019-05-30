package LQB;

import java.util.Scanner;

public class NOone {
	static Scanner input =new Scanner(System.in);
	static int a=input.nextInt();
	static int b[][]=new int[a][a];
	static int c=1;
	
		public static void output(){
			for(int i=0;i<a;i++){
				System.out.println();
				for(int j=0;j<a;j++){
					{
						if(b[i][j]!=0)
							System.out.print(b[i][j]+"\t");
					}
			
				}
			}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<a;i++){
			for(int j=0;j<a;j++){
				if(i==0){
				b[i][j]=c;
				c++;;
				}
				else if(i!=0&&j==a-i-1){
					b[i][j]=c;
					c++;;
				}
			}
		}
		
		for(int i=a-1;i>0;i--){
			if(b[i][0]==0){
			b[i][0]=c;
			c++;;
			}
		}
		
		for(int i=1;i<a;i++){
			for(int j=0;j<a-i-1;j++){
				if(b[i][j]==0){
					b[i][j]=c;
					c++;}
				}
			}
		
		
		output();
		}
	}

