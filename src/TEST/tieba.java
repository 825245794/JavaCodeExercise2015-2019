package TEST;

import java.util.Scanner;

public class tieba {
	double normal;
	double question;
	double design;
	double[] per=new double[15];
	Scanner in=new Scanner(System.in);
	public void MyJava()
	{
		System.out.print("平时分：");
		normal=in.nextDouble();
		System.out.print("答辩分：");
	    question=in.nextDouble();
		System.out.print("设计分：");
		design=in.nextDouble();
		int j=1;
		double total;
		for(int i=0;i<per.length;)
		{
			total=0;
			System.out.println("输入第"+j+"次百分比");
			j++;
			System.out.print("1：");
			per[i]=in.nextDouble();
			i++;
			System.out.print("2：");
			per[i]=in.nextDouble();
			i++;
			System.out.print("3：");
			per[i]=in.nextDouble();
			i++;
			total=per[i-3]+per[i-2]+per[i-1];
			if(total!=100)
			{
				i=i-3;
				j--;
				System.out.println("输入错误,请重新输入");
			}
		}
		print();
	}
		public void print()
		{	int i=0;
			int j=1;
			System.out.println("Score:     "+"Normal      "+"Question     "+"Design");
			while(i!=per.length)
			{
			System.out.println("第"+j+"次成绩:    "+(normal*(per[i]/100))+"         "+(question*(per[i+1]/100))+"          "+(design*(per[i+2]/100)));
			j++;
			i=i+3;
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tieba a=new tieba();
		a.MyJava();
	}

}
