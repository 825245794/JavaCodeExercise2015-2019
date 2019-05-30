package TEST;

public class P117_4 {
public static int A(int x)
{
	return(x*x);
}
public static double B(int y)
{
	double d=y;
	return(d*d);
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
int b=A(6);
System.out.println(b);
b=(int) B(5);
System.out.println(b);
}


}
