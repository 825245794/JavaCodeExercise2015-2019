package LQB_2015;

public class NO3 {
	public static boolean identify(String a,String b,String qi){
		if(a.indexOf(qi)!=-1){
			return false;
		}
		if(b.indexOf(qi)!=-1){
			return false;
		}
		if(a.charAt(1)!=b.charAt(3)){
			return false;
		}
		for(int i=0;i<10;i++){
			if(a.indexOf(String.valueOf(i))!=a.lastIndexOf(String.valueOf(i))){
				return false;
			}
			if(b.indexOf(String.valueOf(i))!=b.lastIndexOf(String.valueOf(i))){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,k;
		String sheng,san,yang,rui,b1,t;
		for(a=1000;a<10000;a++){
			for(b=1000;b<10000;b++){
				k=a+b;
				sheng=String.valueOf(a);
				sheng=String.valueOf(sheng.charAt(2));
				b1=String.valueOf(b);
				san=String.valueOf(b1.charAt(0));
				yang=String.valueOf(b1.charAt(1));
				rui=String.valueOf(b1.charAt(3));
				String qi=String.valueOf(k%10);
				t=String.valueOf(k);
				if(identify(String.valueOf(a),String.valueOf(b),qi)&&String.valueOf(t.charAt(0)).equals(san)&&String.valueOf(t.charAt(1)).equals(yang)&&String.valueOf(t.charAt(2)).equals(sheng)&&String.valueOf(t.charAt(3)).equals(rui)){
					System.out.println("a:"+a);
					System.out.println("b:"+b);
					System.out.println("a+b:"+k);
					System.out.println("三羊生瑞"+san+yang+sheng+rui);
				}
			}
		}
	}

}
