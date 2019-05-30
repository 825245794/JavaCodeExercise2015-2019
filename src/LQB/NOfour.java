package LQB;

import java.util.Scanner;

public class NOfour {
	
	static Scanner input=new Scanner(System.in);
	static int b=input.nextInt();
	static int a[][]=new int[b][b];
	static int h=0,w=0;
	static int k=1;

	
	static public void output(){
		for(int i=0;i<a.length;i++){
			System.out.println();
			for(int j=0;j<a.length;j++){
				System.out.print(a[i][j]+"\t");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int k=1;
		int i=0,j=0;
		int index=0;
		int xmin=0,ymin=0;
		int xmax=b,ymax=b;
		int x=0,y=0;
		boolean flag=true;
		for(int p=0;p<b*b;p++){
		
			a[y][x]=p+1;
			if(y+1<ymax&&flag){
				y++;
			}
			else if(x+1<xmax&&flag){
				x++;
			}
			else{
				if(y>ymin){
					y--;
				}
				else if(x>xmin+1){
					x--;
				}
				else{
					xmax--;
					ymax--;
					xmin++;
					ymin++;
					y++;
					flag=true;
				}
			}
			if(y+1==ymax&&x+1==xmax){
					flag=false;
					
				}
		}
		
		output();
	}

}
