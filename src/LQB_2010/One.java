package LQB_2010;

public class One {
	public  One(int n)
	{
	    for(int i=2;i<n/2;i++){
	    	while( n % i == 0){
	    			System.out.print(i);
	    			n=n/i;
	    		}
	    }
	    if(n>1) System.out.println(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			One a=new One(60);
	}

}
