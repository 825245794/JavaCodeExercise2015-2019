package ex5;

public class J_shape_Triangle implements J_Shape{
	double length,length1,length2,length3;
	J_shape_Pointer x=new J_shape_Pointer(0,0);
	J_shape_Pointer y=new J_shape_Pointer(0,3);
	J_shape_Pointer z=new J_shape_Pointer(3,4);
	public J_shape_Triangle()
	{
		length1=length(x.a,x.b,y.a,y.b);
		length2=length(z.a,z.b,y.a,y.b);
		length3=length(z.a,z.b,x.a,x.b);
	}
	public boolean Jungle()
	{
		if(length1+length2>length3&&length1-length2<length3)
		{
		 if(x.a==y.a&&x.b==y.b)
			{
			return(false);
			}
		if(x.a==z.a&&x.b==z.b)
			{
			return(false);
			}
		if(z.a==y.a&&z.b==y.b)
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
		System.out.println("Triangle Area:"+Area());
		System.out.println("Triangle perimeter:"+perimeter());
	}
	    else
	        System.out.println("Triangle Error");

	}
	public double Area()
	{
		return (0.5*length2*length1);
	}
	public double perimeter()
	{
		return (length1+length2+length3);
	}
}
