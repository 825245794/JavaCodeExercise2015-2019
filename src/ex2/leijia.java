package ex2;

public class leijia {
public void lj(int a)
{
	if(a==1){
	System.out.println(a);
	}
	if(a>1){
		lj(a-1);
		for(int i=1;i<=a;i++){
			  System.out.print(i+ "*" + a + "=" + i * a +  "  ");  
		}
	}
	
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
leijia a=new leijia();
a.lj(4);
	}
}
