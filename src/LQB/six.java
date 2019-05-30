package LQB;

public class six {
	public static void f(){
		int k=0;
		int a=0;
		String r="";
		;
			for(int j=1;j<50;j++){
				a=0;
				r="";
					for(int b=1;b<50;b++){
						a=0;
						r="";
							for(int s=1;s<50;s++){
								if(a==2015){
									System.out.println(r);
									break;
								}
								if((s==j||s==b)&&(s!=49)){
									a*=s;
									r=r+s+"*";
									continue;
								}
								else{
								a+=s;
								r=r+s+"+";
								}
							}
						
					}
				
			
		}
		System.out.println(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f();
	}

}
