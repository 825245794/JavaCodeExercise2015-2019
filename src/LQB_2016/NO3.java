package LQB_2016;

import java.util.Arrays;

public class NO3 {
	static int a[]=new int[9];
	static int c=0;
	public NO3(){
		sort();
	}
	public void sort(){
		for(int i=10000;i<=99999;i++){
			String s=String.valueOf(i);
			if(s.indexOf("0")!=-1){
				continue;}
					a[0]=Integer.parseInt(s.substring(0, 1));
					a[1]=Integer.parseInt(s.substring(1, 2));
					a[2]=Integer.parseInt(s.substring(2, 3));
					a[3]=Integer.parseInt(s.substring(3, 4));
					a[4]=Integer.parseInt(s.substring(4, 5));
					
					for(int k=1000;k<=9999;k++){
						String g=String.valueOf(k);
						if(g.indexOf("0")!=-1){
							continue;}
					a[8]=Integer.parseInt(g.substring(3));	
					a[5]=Integer.parseInt(g.substring(0, 1));
					a[6]=Integer.parseInt(g.substring(1, 2));
					a[7]=Integer.parseInt(g.substring(2, 3));
					cal();
					}
		}
	}
	
	public boolean identify(){
		int[] b=new int[9];
		b=a.clone();
		Arrays.sort(b);
		for(int i=0;i<a.length-1;i++){
			if(b[i]==b[i+1]){
				return false;
			}
			else{
				continue;
			}
		}
		return true;
	}
	
	public void cal(){
		if(identify()==true){
			double i=a[3]*100+a[4]*10+a[5];
			double j=a[6]*100+a[7]*10+a[8];
		String q=String.valueOf(i);
		String w=String.valueOf(j);
		String e=String.valueOf(a[1]);
		double sum=a[0]+(Double.parseDouble(e)/a[2])+((Double.parseDouble(q))/(Double.parseDouble(w)));
		if(sum==10.0){
		c++;
		}
		}
		
	}
	public static void main(String[] args) {
		NO3 a=new NO3();
		System.out.println(c);
	}

}
