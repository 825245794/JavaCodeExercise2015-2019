package ex3;
public class RC_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RC rc=new Circle(5);
	System.out.println("Բ�����:"+rc.Area());
	System.out.println("Բ���ܳ�:"+rc.perimeter());
	rc= new Rect(5,4);
	System.out.println("���������:"+rc.Area());
	System.out.println("�������ܳ�:"+rc.perimeter());
	}

}
