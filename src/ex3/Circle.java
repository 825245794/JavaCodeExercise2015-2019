package ex3;

public class Circle implements RC{
	private int radii;    
	public static double pai=3.14;
	public Circle(int radii) {
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