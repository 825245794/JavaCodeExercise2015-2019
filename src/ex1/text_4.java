package ex1;

import java.util.Scanner;

public class text_4 {
	
		public static void main(String args[]){
			Scanner input=new Scanner(System.in);
			int l=input.nextInt();
			int[][] a=new int[l][l];
			a[0][0]=1;
			for(int i=1;i<l;i++){
				for(int j=0;j<i+1;j++){
					if(j==0){
						a[i][j]=1;}
					else{
						a[i][j]=a[i-1][j]+a[i-1][j-1];
					}
				}
			}
				int o=0;
			for(int i=0;i<l;i++){
				if(o!=0)
				System.out.println();
				o++;
				for(int j=0;j<l;j++){
					if(a[i][j]!=0)
					System.out.print(a[i][j]+" ");
				}
			}
			
		}
}
