package ex11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Readstudentscore {

	/**
	 * @param args
	 */
	
	int arr=0;
	int[] score=new int[6];
    String[] c=new String[6];
	public void Read()
	{
		
		try {
			
			FileReader r=new FileReader("/Volumes/LJL/rename/chengji.txt");
			String a="";
				for(int i=r.read();i!=-1;i=r.read())
				{
					a+=(char)i;
				}
				System.out.println(a);
				String b=a.replaceAll("java score:", "@");
				b=b.replaceAll("C score:", "@");
				
				for(int i=0;i<b.length();i++)
				{
					
					if(b.charAt(i)=='@')
					{
						try{
						c[arr]=b.substring(i+1, i+4);
						score[arr]=Integer.parseInt(c[arr]);
				         ++arr;
						}catch(Exception e)
						{
							c[arr]=b.substring(i+1, i+3);
							score[arr]=Integer.parseInt(c[arr]);
					         ++arr;

						}
						
					}
				}
				for(int arr=0;arr<c.length;arr++)
				{
					if(c[arr]==null)
					{
						score[arr]=0;
					}
				}

				int f=0;
				for(int d:score)
				{
					System.out.println(d);
					f+=d;
				}
				System.out.println("Score:"+f);
				System.out.println("Average:"+f/6);
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Readstudentscore a=new Readstudentscore();
		a.Read();
	}

}
//D:\\chengji.txt