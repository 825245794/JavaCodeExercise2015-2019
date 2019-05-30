package ex5;

public class J_shape_Square implements J_Shape {
double length;
J_shape_Pointer x=new J_shape_Pointer(5,5);
J_shape_Pointer y=new J_shape_Pointer(0,5);
J_shape_Pointer z=new J_shape_Pointer(5,0);
J_shape_Pointer w=new J_shape_Pointer(0,0);
public J_shape_Square()
{
	length=length(x.a,x.b,y.a,y.b);
}
public boolean Jungle()
{
	double Jungle1,Jungle2,Jungle3;
	Jungle1=length(x.a,x.b,y.a,y.b);
	Jungle2=length(z.a,z.b,x.a,x.b);
	Jungle3=length(z.a,z.b,w.a,w.b);
	if(Jungle1==Jungle2&&Jungle2==Jungle3)
	{
		if(x.a==y.a&&x.b==y.b)
		{
		return(false);
		}
		if(x.a==z.a&&x.b==z.b)
		{
		return(false);
		}
		if(x.a==w.a&&x.b==w.b)
		{
		return(false);
		}
		if(z.a==y.a&&z.b==y.b)
		{
		return(false);
		}
		if(w.a==y.a&&w.b==y.b)
		{
		return(false);
		}
		if(z.a==w.a&&z.b==w.b)
		{
		return(false);
		}
	 return(true);
	}
	
	else
	{
	 return(false);
	}
		
}
public double length(double PointX,double PointY,double CenterX,double CenterY)
{	
	length=Math.sqrt(((PointX-CenterX)*(PointX-CenterX))+((PointY-CenterY)*(PointY-CenterY)));
	return length;	
}
public void print()
{
	boolean Jungle=Jungle();
    if(Jungle==true)
{
	System.out.println("Square Area:"+Area());
	System.out.println("Square perimeter:"+perimeter());
}
    else
        System.out.println("Square Error");

}
public double Area()
{
	return (length*length);
}
public double perimeter()
{
	return 4*length;
}
}
