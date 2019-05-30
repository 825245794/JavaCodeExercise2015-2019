package ex3;
public class Test_Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Shape rc=new J_Circle(5);
	System.out.println("圆形面积:"+rc.Area());
	System.out.println("圆形周长:"+rc.perimeter());
	rc= new J_Square(5,4);
	System.out.println("长方形面积:"+rc.Area());
	System.out.println("长方形周长:"+rc.perimeter());
	}

}
