package LQB;

public class two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=0;
		for(int i=1;i<1000;i++){
			k=0;
			int a=i*i*i;
			String b=String.valueOf(a);
			for(int j=0;j<b.length();j++){
				k+=Integer.parseInt(String.valueOf(b.charAt(j)));
			}
			if(k==i){
				System.out.println(k);
			}
			
		}
	}

}
