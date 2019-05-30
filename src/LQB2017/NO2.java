package LQB2017;

public class NO2 {
	static String first=null,second=null,third=null,last=null;
	public static boolean cal(int a,int b,String first,String second,String third,String last){
		String totalnum=String.valueOf(a)+String.valueOf(b)+first+second+third+last;
		int total=0;
		for(int k=0;k<10;k++){
			total=0;
			for(int i=0;i<totalnum.length();i++){
				if(String.valueOf(totalnum.charAt(i)).equals(String.valueOf(k))){
					total++;
				}
				if(total>2){
					return false;
				}
			}
			if(total!=2){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<1000;i++){
			for(int j=100;j<1000;j++){
				int a=i*(j%10);
				first=String.valueOf(a);
				a=i*((j/10)%10);
				second=String.valueOf(a);
				a=i*((j/100)%10);
				third=String.valueOf(a);
				a=Integer.parseInt(first)+Integer.parseInt(second)*10+Integer.parseInt(third)*100;
				last=String.valueOf(a);
				if(last.length()==5){
				if(cal(i, j, first, second, third, last)==true){
					System.out.println(last);
				}}
			}
		}
	}

}
