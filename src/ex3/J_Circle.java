package ex3;

public class J_Circle implements Shape{
	private int radii;    
	public static double pai=3.14;
	public J_Circle(int radii) {
		this.radii = radii;
	}
	public double Area()
	{
		return (pai*radii*radii);
	}
	public double perimeter()
	{
		return 2*pai*radii;
	}
}