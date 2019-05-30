package TEST;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class Readxml {
	String forntsix[]=new String[3465];
	String area[]=new String[3465];
	String input;
	int i;
	private int Year;
	static int are;
	public Readxml(int Year)
	{
		this.Year=Year;
	}
	public void Readfile()
	{
		try
		{
			String a="D:\\JavaEX\\LJL\\src\\TEST\\xml\\1.xls";
		Workbook book=
		Workbook.getWorkbook(new File(a));//获得第一个工作表对象
		Sheet sheet=book.getSheet(0);//单元格第一页
		Cell[] cellfornt=new Cell[forntsix.length];
		Cell[] cellarea=new Cell[area.length];
		for(i=0;i<forntsix.length;i++)
		{
		cellfornt[i]=sheet.getCell(0,i+1);
		cellarea[i]=sheet.getCell(1,i+1);
		forntsix[i]=cellfornt[i].getContents();//数组加入第一列的单元格
		area[i]=cellarea[i].getContents();//数组加入第二列的单元格
		//System.out.println(area[i]);
		}
		book.close();
		}catch(Exception e)
		{
			Workbook book;
			try {
				book = Workbook.getWorkbook(new File("/Volumes/LJL/JavaEX/LUJIALE04151010/src/TEST/xml/1.xls"));//获得第一个工作表对象
				Sheet sheet=book.getSheet(0);//单元格第一页
				Cell[] cellfornt=new Cell[forntsix.length];
				Cell[] cellarea=new Cell[area.length];
				for(i=0;i<forntsix.length;i++)
				{
					cellfornt[i]=sheet.getCell(0,i+1);
					cellarea[i]=sheet.getCell(1,i+1);
					forntsix[i]=cellfornt[i].getContents();//数组加入第一列的单元格
					area[i]=cellarea[i].getContents();//数组加入第二列的单元格
				}
				book.close();
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		}
	}
	
	public void Input()
	{//
		boolean k=false,k1=false,k2=false;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter your ID:");
		input=scanner.next();
		while(k!=true||k1!=true)
		{
		if(input.length()>18||input.length()==0)
		{
			System.out.println("Error ID");
			System.out.print("Enter your ID:");
			input=scanner.next();
			continue;
		}
		k=Checkfont();
		k1=both();
		k2=last();
		if(k==false||k1==false)
		{
			System.out.println("Error ID");
			System.out.print("Enter your ID:");
			input=scanner.next();
			k=Checkfont();
			k1=both();
			continue;
		}
		}
		scanner.close();
	}
	
	public boolean Checkfont()
	{
		String k=input.substring(0, 6);
		for(i=0;i<forntsix.length;i++)
		{
			if(forntsix[i].equals(k))
			{
				are=i;
				return true;
			}
		}
		return false;
	}
	
	public boolean both()
	{
		String k=input.substring(6, 10);
		String k1=input.substring(10, 12);
		String k2=input.substring(12, 14);
		int s=Integer.parseInt(k);
		int s1=Integer.parseInt(k1);
		int s2=Integer.parseInt(k2);
		if(k1.equals("01")||k1.equals("02")||k1.equals("03")||k1.equals("04")||k1.equals("05")||k1.equals("06")||k1.equals("07")||k1.equals("08")||k1.equals("09")||k1.equals("010")||k1.equals("11")||k1.equals("12"))
		{
			 if((k1.equals("04")||k1.equals("05")||k1.equals("06")||k1.equals("09")||k1.equals("11"))&&s2<=30)
		{
			return true;
		}
		else if((k1.equals("01")||k1.equals("03")||k1.equals("07")||k1.equals("08")||k1.equals("10")||k1.equals("12"))&&s2<=31)
		{
			return true;
		} 
		}
		if(k1.equals("02"))
		{
			if((s%4==0)&&(s%100!=0||s%400==0)&&(s2<30))
			{
				return true;
			}	
			else if(s2<29)
			{
			return true;
			}	
		}
		return false;
	}
	public boolean last()
	{
		int  []a=new int[17];
		double []b=new double[17];
		double d=0;
		try{
		for(i=0;i<input.length()-1;i++)
		{
			a[i]=Integer.parseInt(input.substring(i, i+1));	
		}
		}catch(Exception e)
		{
			for(i=0;i<=input.length()-2;i++)
			{
				a[i]=Integer.parseInt(input.substring(i, i+1));	
			}
		}
		for(i=0;i<17;i++)
		{
			b[i]=Math.pow((double)2, (double)(i+1));
		}
		for(i=0;i<17;i++)
		{
			d+=a[i]*b[16-i];
		}
		
		int k=(int)d%11;
		try{
		int e=Integer.parseInt(input.substring(17));
		 if(k==0&&e==1)
		{
				return true;
		}
		else if(k==1&&e==0)
		{
			return true;
		}
		else if((k==2&&input.substring(17).equals("x"))||(k==2&&input.substring(17).equals("X")))
		{
				return true;
			
		}
		else if(k==3&&e==9)
		{
				return true;
		}
		else if(k==4&&e==8)
		{
				return true;
		}
		else if(k==5&&e==7)
		{
				return true;
		}
		else if(k==6&&e==6)
		{
				return true;
		}
		else if(k==7&&e==5)
		{
				return true;
		}
		else if(k==8&&e==4)
		{
				return true;
		}
		else if(k==9&&e==3)
		{
				return true;
		}
		else if(k==10&&e==2)
		{
				return true;
		}
		}
		catch(Exception d1)
	   {	
			 if(k==2&&input.substring(17).equals("x")||k==2&&input.substring(17).equals("X"))
						return true;	
	   }
		
			return false;
		
	}
	public void print()
	{
		Readfile();
  		Input();
		String k=input.substring(6, 10);
		String k1=input.substring(10, 12);
		String k2=input.substring(12, 14);
		String sex=input.substring(14, 17);
		int s1=Integer.parseInt(k);
		int s=Integer.parseInt(sex);
		System.out.println("地区:"+area[are]);
		System.out.println("出生:"+k+"."+k1+"."+k2);
		System.out.println("年龄:"+(Year-s1));
		System.out.println("性别:"+(s%2==0?"女":"男"));
		System.out.println("合法:"+(last()?"是":"否"));
	}
  	public static void main(String[] args) {
		// TODO Auto-generated method stub
  		Readxml a=new Readxml(2016);
  		a.print(); 
  	
	}

}
