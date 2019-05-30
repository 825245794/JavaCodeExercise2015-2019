package LQB_2010;

public class Five {
	public Five(int m,int n){
		 System.out.println(f(m,n));
	}
	
	public int f(int m,int n){
		if(m < n)  return 0;
		if(n==0)   return 1;
		return f(m-1, n) + f(m, n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Five a=new Five(3,3);
	}

}
