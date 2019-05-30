package ex6;

import java.util.Arrays;

public class P160_6 {
	static int i;
	static char[] Array;
	public P160_6()
	{
	Array=new char[10];
	while(i<10)				
	{
		Array[i]=0;
		i++;
	}
	}
		public static int random()
		{
			i=(int)(Math.random()*26+97);
			return i;
		}
		public boolean identify(int k)
		{
			int l1;
			for(l1=0;l1<10;l1++)
			{
			if(k==(int)Array[l1])
			{
				return false;
			}
			
			}
			return true;
		}
		public void Array()
		{
			boolean l1;
			int k,l=0,j = 0;
			while(j<10)
			{
				k=random();
				l1=identify(k);
				for(l=0;l<10;l++)
				{
					if(l1==false)
					{
						break;
					}
					if(Array[l]==0)
					{
						if(l1==true)
						{
					Array[l]=(char)k;
					j++;
                    break;
					}
					}
				else
				{
					continue;	 
				}
			    }	
				
			}
		}
		public void print()
		{
			int j;
			Array();
			System.out.print("Sort before: ");
			for(j=0;j<10;j++)
			{
				System.out.print(Array[j]);
			}
			Arrays.sort(Array);
			System.out.println();
			System.out.print("Sort After:  ");
			for(j=0;j<10;j++)
			{
				System.out.print(Array[j]);
			}
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	P160_6 a=new P160_6();
	a.print();
		}
}
