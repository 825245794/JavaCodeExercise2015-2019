package LQB_2016;

public class NO2 {
	public static void main(String args[]){
		int i=1;
		int k=1;
		int sum=0;
		while(sum!=236){
			sum+=i;
			i++;
			if(i>236){
				k++;
				i=k;
				sum=0;
			}
		}
		System.out.println(k);
	}
}
