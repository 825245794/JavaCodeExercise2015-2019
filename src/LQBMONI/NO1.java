package LQBMONI;

public class NO1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		int m=0;
		for(int i=10;i<100;i++){
			String a=String.valueOf(i);
			m=i;
			if(a.charAt(1)!='0'){
				n=Integer.parseInt(String.valueOf(a.charAt(1)))*10+Integer.parseInt(String.valueOf(a.charAt(0)));
			}
			else{
				n=Integer.parseInt(String.valueOf(a.charAt(0)));
			}
			int max=i+n;
			int min=Math.abs(i-n);
			if(Math.abs(max-min)==32){
				System.out.println(i);
				System.out.println(min);
			}
		}
	}

}
