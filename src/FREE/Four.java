package FREE;
import java.util.Scanner;
public class Four {
	static int [] a=new int [4];
	public static int temp,b,c,d,i=0;	
	public static int Fenzu(int f)
	{		
		a[0]=f/1000;
		a[1]=(f/100)%10;
		a[2]=(f/10)%10;
		a[3]=f%10;
	
		for(int j=0;j<a.length-1;j++)
		{
			for(int k=0;k<a.length-1-j;k++)
			{
				if(a[k]<a[k+1])
				{
					temp=a[k];
					a[k]=a[k+1];
					a[k+1]=temp;
				}
			}		}
		b=a[0]+a[1]*10+a[2]*100+a[3]*1000;	
		c=a[0]*1000+a[1]*100+a[2]*10+a[3];
		d=c-b;
		if(d<1000)
		{System.out.println("数字不正确的");
		d=0;
		
		}
		else
		{
		++i;
		System.out.println("第"+i+"次排列"+c);
		System.out.println("第"+i+"次排列"+b);
		System.out.println("第"+i+"次排列"+d);
		}
		return d;
	}
	public static int identify(int f)
	{
		a[0]=f/1000;
	    a[1]=(f/100)%10;
	    a[2]=(f/10)%10;
	    a[3]=f%10;
		for(int j=0;j<a.length;j++)
		{
			for(int k=0;k<a.length;k++)
			{
				if(a[j]==a[k])
				{
					i++;
				}
				else{continue;}
			}}
			if(i==16)
			{
				f=0;}
			else{f=1;}
		
		return f;}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
int i,a,b=-100,k=0;
System.out.print("输入0～9任意四个数可得神秘数字 ");
for(;;){
i=input.nextInt();
a=identify(i);
if(i>9999||i<1000){
    System.out.println("数字超出范围");
    continue;
   }
else if(a==0)
{
	System.out.println("输入错误");
	continue;
}
else 
	break;
}

a=Fenzu(i);
for(;;){
	++k;
if(b==a)
{
	System.out.println("经过"+k+"次计算"+"最终结果"+a);
	break;
}
else
{  	b=a;
	a=Fenzu(a);	
	if(a==0){
		break;
	}
	continue;
}
	}
input.close();
	}
}
