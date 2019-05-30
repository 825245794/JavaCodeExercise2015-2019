package ex7;

public class J_Stringtomath {
	char s1='A';
	char s2='D';
	public void print()
	{
		
		System.out.println((int)s1-(int)s2>0?"s1>s2":"s2>s1");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J_Stringtomath a=new J_Stringtomath();
		a.print();
	}

}
