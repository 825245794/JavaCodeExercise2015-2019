package LQB2017;

public class NO1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b = null;
		for(int i=1;i<100;i++){
			String a=String.valueOf(i*i);
			if(a.length()==4){
			b=a.substring(0, 2);}
			else{
				continue;
			}
			if(b.equals("18")){
				System.out.println(a+"  ");
				System.out.println(i);
				System.out.println(Integer.parseInt(a)-i);
			}
		}
	}

}
