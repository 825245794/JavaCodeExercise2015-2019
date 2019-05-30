package ex3;

import ex3.RC2.Circle1;
import ex3.RC2.Ract1;

public class RC_Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RC2 rc2=new RC2();
Circle1 circle=rc2.new Circle1();
circle.setRadii(5);
Ract1 ract=rc2.new Ract1();
ract.setHeight(5);
ract.setWidth(4);
circle.circle();
ract.ract();

}
}