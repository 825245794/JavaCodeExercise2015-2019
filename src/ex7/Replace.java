package ex7;

public class Replace {
String s="AB-C-ABC";
	/**
	 * @param args
	 */
public void replace()
{
	System.out.println("s:"+s);
	s=s.replaceAll("A","First");
	String s1=s.substring(0, 6);
	String s2=s.substring(7,8);
	String s3=s.substring(9, 16);
	System.out.println("s1:"+s1);
	System.out.println("s2:"+s2);
	System.out.println("s3:"+s3);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Replace a=new Replace();
a.replace();
	}

}
