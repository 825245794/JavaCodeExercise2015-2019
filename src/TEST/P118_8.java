package TEST;
public class P118_8 {
private double a;
private double b;
private double c;
public double del;
public double getA() {
	return a;
}
public void setA(double a) {
	this.a = a;
}
public double getB() {
	return b;
}
public void setB(double b) {
	this.b = b;
}
public double getC() {
	return c;
}
public void setC(double c) {
	this.c = c;
}
public int identify()
{
	int d = 1;
	del=b*b-(4*a*c);
	if(del<0)
	{		
		d=0;
	}
	return d;
}
public void print()
{
	System.out.println("x1的值="+(-b+Math.sqrt(del))/(2*a));
	System.out.println("x2的值="+(-b-Math.sqrt(del))/(2*a));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
     P118_8 s=new P118_8();
     s.setA(1);
     s.setB(0);
     s.setC(1);
     a=s.identify();
     if(a==0)
     {
    	 System.out.println("方程无解");
     }
     else
     {
     s.print();
     }
	}

}
