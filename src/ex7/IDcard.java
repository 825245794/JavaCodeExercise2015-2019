package ex7;

public class IDcard {
String s=("440105196503214563");
	/**
	 * @param args
	 */
public void print()
{
	String s1=(s.charAt(0)+""+s.charAt(1));
	System.out.println(s1.equals("44")?"guangdong":"fei guangdong");
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
IDcard a=new IDcard();
a.print();
	}

}
