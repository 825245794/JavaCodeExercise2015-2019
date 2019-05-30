package LQBMONI;

import java.util.Scanner;
import java.util.Vector;

public class NO9 {
	static Vector<Integer> x=new Vector<Integer>();;
	static Vector<Integer> y=new Vector<Integer>();;
	static int[] maxpoint=new int[2];
	static int[][] map;
	static int[][] map_clone;
	static int n,m,boomnum=0,handel=0;
	public void init(){
		maxpoint[0]=-1;maxpoint[1]=-1;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		m=input.nextInt();
		map=new int[n][m];
		map_clone=new int[n][m];
		for(int i=0;i<n;i++){
				String o=input.next();
				for(int w=0;w<o.length();w++){
				if(String.valueOf(o.charAt(w)).equals("1")){
					map[i][w]=1;
					x.add(i);
					y.add(w);
				}
				
			}
		}
		check();
	}
	public void print(){
		System.out.println();
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public void w(){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				map_clone[i][j]=map[i][j];
			}
		}
	}
	public void check(){
		for(int i=0;i<x.size();i++){
			w();
			getBoom(x.get(i),y.get(i),0);
		}
		if(maxpoint[0]!=-1&&maxpoint[1]!=-1){
		makeboom(maxpoint[0],maxpoint[1]);
		handel++;}
		for(int i=0;i<x.size();i++){
			if(map[x.get(i)][y.get(i)]==1){
				handel++;
			makeboom(x.get(i),y.get(i));
			}
		}
		//System.out.println(boomnum);
		System.out.println(handel);
	}
	public void makeboom(int x,int y){
		if(map[x][y]==0)return;
		   map[x][y]=0;
		for(int i=0;i<n;i++){
			if(i==x)continue;
			if(map[i][y]==1){
				makeboom(i,y);
			}
		}
		for(int i=0;i<m;i++){
			if(i==y)continue;
			if(map[x][i]==1){
				makeboom(x,i);
			}
		}
	}
	public void getBoom(int x,int y,int max){
		map_clone[x][y]=0;
		for(int i=0;i<n;i++){
			if(i==x)continue;
			if(map_clone[i][y]==1){
				map_clone[i][y]=0;
				max=max+1;
				getBoom(i,y,max);
			}
		}
		for(int i=0;i<m;i++){
			if(i==y)continue;
			if(map_clone[x][i]==1){
				map_clone[x][i]=0;
				max=max+1;
				getBoom(x,i,max);
			}
		}
		if(max>boomnum){
			boomnum=max;
			maxpoint[0]=x;
			maxpoint[1]=y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO9 a=new NO9();
		a.init();
	}
}

