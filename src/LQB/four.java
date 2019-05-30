package LQB;

import java.util.Vector;

public class four {
	public static int f(int n,int m){
			n=n%m;
			
			Vector v=new Vector();
			
			for(;;){
				//System.out.println(v.indexOf(n));
				v.add(n);
				n*=10;
				n=n%m;
				
				if(n==0) return 0;
				if(v.indexOf(n)>=0){
					return v.size();
				}
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(f(1,7));
	}

}
