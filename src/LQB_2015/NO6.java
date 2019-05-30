package LQB_2015;

public class NO6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p=2;
		int k=1;
		int sum=0;
		boolean flag=false;
		while(p!=50){
			//if(k==p||k==p-1||k==p+1){k++;continue;}
		
			for(int total=1;total<50;total++){
				if(total==p||total==k){
					flag=true;
				}
					if(flag==true&&k!=p&&k!=p-1&&k!=p+1){
						sum=sum*total;
						flag=false;
					}
					else{
						sum=+total;
					}
					
				}
			if(sum==2015)System.out.println(p);
			
			if(k==49){
				k=1;
				p++;
			}
			else{
				k++;
			}
			
	}
		
	}

}
