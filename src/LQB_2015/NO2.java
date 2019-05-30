package LQB_2015;

public class NO2 {
	static int sum;
	static int num;
	public NO2(){
		cal();
	}
	
	public void cal(){
		for(int i=1;i<101;i++){
			sum=i*i*i;
			num=i;
			sort();
		}
		
	}
	
	public void sort(){
		String a=String.valueOf(sum);
		int sum1=0;
		for(int i=0;i<a.length();i++){
			sum1+=Integer.parseInt(String.valueOf(a.charAt(i)));
		}
		if(sum1==num){
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO2 a=new NO2();
	}

}
