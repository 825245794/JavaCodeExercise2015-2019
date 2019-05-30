package LQB_2016;

import java.util.Arrays;
import java.util.Vector;

public class NO7 {
	static int[][] a=new int[4][3];
	static boolean[][] flag=new boolean[4][3];
	static int[][] check=new int[5][5];
	static int[] haved=new int[5];
	static int c1=0;
	public NO7(){
		sort();
	}
	
	public void sort(){
		int p=1;
		clear();
		for(int y=0;y<3;y++){
			for(int x=0;x<4;x++){
				a[x][y]=p;
				flag[x][y]=false;
				p++;
			}
		}
		
		for(int i=1;i<9;i++) {
			for(int b=i+1;b<10;b++) {
				for(int c=b+1;c<11;c++) {
					for(int d=c+1;d<12;d++) {
						for(int e=d+1;e<13;e++) {
						panduan(i,b,c,d,e);
				}
			  }
		   }
		}
	 }
			
		
	}
	
	public void panduan(int i,int b, int c,int d,int e){
		for(int y=0;y<3;y++){
				for(int x=0;x<4;x++){
					if(a[x][y]==i){
						flag[x][y]=true;
						
				
					}
					if(a[x][y]==b){
						flag[x][y]=true;
						
					}
					if(a[x][y]==c){
						flag[x][y]=true;
						
					}
					if(a[x][y]==d){
						flag[x][y]=true;
						
					}
					if(a[x][y]==e){
						flag[x][y]=true;
						
					}		
				}
			}
		cal();
	}
	public boolean identify(){
		int u=0;
		for(int y=0;y<3;y++){ 
			for(int x=0;x<4;x++){
			 
				if(flag[x][y]==false){ 
					continue;
				}
				check[0][u]=a[x][y];
				u++;
			}
		}
		
		int sum=-1;
		int p1=1;
		for(int y=0;y<3;y++){ 
			for(int x=0;x<4;x++){
				if(flag[x][y]==false){
					continue;
				}
				sum++;
				p1=1;	
				try{
					if(flag[x][y+1]==true){
					check[p1][sum]=a[x][y+1];
					p1++;}
				}catch(Exception e){}
				
				
				try{
					if(flag[x+1][y]==true){
					check[p1][sum]=a[x+1][y];
					p1++;}
				}catch(Exception e){}
				
				try{
					if(flag[x][y-1]==true){
					check[p1][sum]=a[x][y-1];
					p1++;}
				}catch(Exception e){}
				
				try{
					if(flag[x-1][y]==true){
					check[p1][sum]=a[x-1][y];
					p1++;}
				}catch(Exception e){}
			}
		}
		haved[0]=check[0][0];
		dfs(haved[0]);
		return true;
	}
	
	public void dfs(int i){
		boolean f=true;
		for(int j=0;j<5;j++){
			if(haved[j]==i){
				f=false;
				break;
			}
		}
		
		if(f==true){
			for(int j=0;j<5;j++){
				if(haved[j]==-1){
					haved[j]=i;
					f=false;
					break;
				}
			}}
		
		int x1=-1;
		for(int x=0;x<5;x++){
			if(check[0][x]==i){
				x1=x;
				break;
			}
		}
		
		if(x1!=-1){
			for(int y=1;y<5;y++){
				if(check[y][x1]!=-1){
					int h=check[y][x1];
					check[y][x1]=-1;
					dfs(h);
				}
			}
		}
	}
	public void cal(){
		int l=0;
		if(identify()==true){
			for(int i1:haved){
				if(i1!=-1){
					l++;
				}
			}
			if(l==5){
			clear();
			c1++;
			}
			else{
				clear();
			} 
		}
	}
	
	public void clear(){
		for(int y=0;y<3;y++){
			for(int x=0;x<4;x++){
				flag[x][y]=false;
			}
		}
		
		for(int y=0;y<5;y++){
			for(int x=0;x<5;x++){
				check[x][y]=-1;
			}
		}
		
		for(int x=0;x<5;x++){
			haved[x]=-1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO7 a=new NO7();
		System.out.print(c1);
	}

}
