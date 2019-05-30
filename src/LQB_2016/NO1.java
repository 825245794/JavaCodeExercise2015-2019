package LQB_2016;

public class NO1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=2;
		int a=1;
		int j=0;
		for(int i=0;i<100;i++){
			j+=a;
			a+=k;
			k++;
		}
		System.out.println(j);
	}

}
