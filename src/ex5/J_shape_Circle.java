package ex5;

public class J_shape_Circle implements J_Shape {
	double pai,radii;	
	J_shape_Pointer x=new J_shape_Pointer(0,4);
	J_shape_Pointer center=new J_shape_Pointer(0,0);
	public J_shape_Circle()
	{
	pai=3.14;
    radii=raddi(x.a,x.b,center.a,center.b);
	}
public double raddi(double PointX,double PointY,double CenterX,double CenterY)
{	
	radii=Math.sqrt(((PointX-CenterX)*(PointX-CenterX))+((PointY-CenterY)*(PointY-CenterY)));
	return radii;	
}
public boolean Jungle()
{
	if(x.a!=center.a||x.b!=center.b)
	{
	 return(true);
	}
	else
	{
	 return(false);
	}
		
}
public void print()
{
	boolean Jungle=Jungle();
    if(Jungle==true)
{
	System.out.println("Circle Area:"+Area());
	System.out.println("Circle perimeter:"+perimeter());
}
    else
    System.out.println("Circle Error");
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
