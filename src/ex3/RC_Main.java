package ex3;
public class RC_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RC rc=new Circle(5);
	System.out.println("圆形面积:"+rc.Area());
	System.out.println("圆形周长:"+rc.perimeter());
	rc= new Rect(5,4);
	System.out.println("长方形面积:"+rc.Area());
	System.out.println("长方形周长:"+rc.perimeter());
	}

}
