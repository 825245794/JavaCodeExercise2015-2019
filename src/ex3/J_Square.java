package ex3;

public class J_Square implements Shape{
	private int height;	
	private int width;
	public J_Square(int height,int width) {
		this.height = height;
		this.width = width;
	}
	public double Area()
	{		
		return height*width;
			}
	public double perimeter()
	{
		return 2*(height+width);
	}
}
