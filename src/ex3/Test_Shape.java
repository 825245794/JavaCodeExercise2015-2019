package ex3;
public class Test_Shape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Shape rc=new J_Circle(5);
	System.out.println("Բ�����:"+rc.Area());
	System.out.println("Բ���ܳ�:"+rc.perimeter());
	rc= new J_Square(5,4);
	System.out.println("���������:"+rc.Area());
	System.out.println("�������ܳ�:"+rc.perimeter());
	}

}
