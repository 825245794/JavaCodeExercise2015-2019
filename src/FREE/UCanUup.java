package FREE;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UCanUup{
	String text;

	public void read() throws IOException
	{
		
			try{
			FileReader r=new FileReader("c:\\UCanUup.txt");
			for(int i=r.read();i!=-1;i=r.read())
			{
				text+=(char)i;
			}}catch(FileNotFoundException e)
			{
				FileReader r;
				try {
					r = new FileReader("/Volumes/LJL/UCanUup.txt");
					for(int i=r.read();i!=-1;i=r.read())
					{
						text+=(char)i;
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("请把文件放在C盘根目录并命名为UCanUup");
				}
				
			}
			
	}
	public UCanUup()
	{
		try {
			read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String a;
		String b;
		int total=0;
		for(int index=0;index<text.length();index++)
		{
			try{
			a=text.substring(index, index+1);
			if(a.equals("U"));
			{
				
				b=text.substring(index+1, index+7);
				a=a+b;
			}
				if(a.equals("UCanUup"))
				{
					total++;
					a=null;
					b=null;
					index=index+6;
				}
				else
				{
					b=null;
					a=null;
				}
			}catch(Exception e)
			{
				
			}
		}
		System.out.print(total);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UCanUup ucanuup=new UCanUup();
	}

}
