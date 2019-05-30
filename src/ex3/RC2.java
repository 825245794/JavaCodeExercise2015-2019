package ex3;

public class RC2 {
	private int radii; 	
	private int height;	
	private int width;
	public static double pai=3.14;
	public int getRadii() {
		return radii;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void circle(){
		System.out.println("圆形面积:"+pai*radii*radii);
		System.out.println("圆形周长:"+2*pai*radii);		
	}
	public void ract(){		
		System.out.println("长方形面积:"+height*width);
		System.out.println("长方形周长:"+2*(height+width));
	}
		

public class Circle1 extends RC2{
	
	public void setRadii(int radii) {
		super.radii = radii;
	}
}
public class Ract1 extends RC2{
	public void setHeight(int height) {
		super.height = height;
	}
	public void setWidth(int width) {
		super.width = width;
	}
	}}
