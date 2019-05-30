package ex3;

public class Rect implements RC{
	private int height;	
	private int width;
	public Rect(int height,int width) {
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
