package LQB_2016;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class NO10 {
	static int[] a;
	static int[] flag;
	static int k=0;
	static int[] save;
	public NO10(){
		Scanner input=new Scanner(System.in);
		int q=input.nextInt();
		a=new int[q];
		flag=new int[q];
		save=new int[q];
		clear();
		for(int i=0;i<a.length;i++){
			a[i]=input.nextInt();
		}
		flag=a.clone();
		input.close();
		sort();
	}
	
	public void sort(){
		for(int i=0;i<a.length;i++){
			if(!repeat(a[i],i)){
				if(k>1){
					
				vsort();
				a[i]=k;
				k=0;}
				else if(k==0){
					a[i]=0;
					clear();
				}
				else if(k==1){
					a[i]=1;
					clear();
					k=0;
				}
			}
			else{
				a[i]=a[i]*-1;
			}
		}
		print();
	}
	
	public boolean repeat(int s,int j){
		k=0;
		int p=0;
		int h=s;
		//save.add(h);
		for(int i=j-1;i>-1;i--){
			
			if(flag[i]==(a[j])){
				return false;
			}
				if(h!=flag[i]){
					k++;
					h=flag[i];
					save[p]=flag[i];
					p++;
				}
				
				
		}
		return true;
	}
	public void vsort(){
		Arrays.sort(save);
		int h=0;
		int p=0;
		for(int i=0;i<save.length;i++){
			
			if(save[i]==-1){
				continue;
			}
			else{
				h=save[i];
				p=i;
				break;
			}
		}
		k=1;
		for(int i=p;i<save.length;i++){
			if(h==save[i]){
				continue;
			}
			if(save[i]==-1){
				continue;
			}
			if(save[i]!=h){
				k++;
				h=save[i];
				}
		}
		
		clear();
	}
	
	
	public void print(){
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	public void clear(){
		for(int i=0;i<save.length;i++){
			save[i]=-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			NO10 a=new NO10();
	}

}
