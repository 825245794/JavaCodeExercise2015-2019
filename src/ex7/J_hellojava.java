package ex7;

public class J_hellojava {
String s1="hello java";
String s2="hello java";
public void print()
{
	System.out.println("s1:"+s1);
	System.out.println("s2:"+s2);
	System.out.println("equal   s1"+(s1.equals(s2)?"==":"!=")+"s2");
	System.out.println("==      s1"+(s1==s2?"==":"!=")+"s2");
}
public static void main (String args[])
{
	J_hellojava a=new J_hellojava();
	a.print();
	
}
}
