package ex6;

public class P160_8 {
int [][]array;
int k=0;
	public P160_8()
	{
		array=new int[3][5];
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<5;j++)
			{
				array[i][j]=-1;
			}
		}
		for(int i=2;i<3;i++)
		{
			for(int j=0;j<5;j++)
			{
				array[i][j]=-1;
			}
		}
		array[1][0]=2;
		array[1][1]=0;
		array[1][2]=0;
		array[1][3]=8;
		array[1][4]=5;
	}
	public void start()
	{
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<5;j++)
			{
				array[i][j]=-1;
			}
		}
		for(int i=2;i<3;i++)
		{
			for(int j=0;j<5;j++)
			{
				array[i][j]=-1;
			}
		}
	}
	public void random(int i)
	{
	  array[0][i]=(int)(Math.random()*10);
	}
	public boolean identify()
	{
		
			for(int j=0;j<5;j++)
			{
				int d=0;
				if(array[0][j]==-1)
				{
					continue;
				}
				for(int i=0;i<5;i++)
				{
					if(array[0][i]!=-1)
					{
						if(array[0][j]==array[0][i])
						{
							d++;
							if(d>1)
							{
							return(false);	
							}
						}
					}
			    }
		}
			return(true);
	}
	public void arrays()
	{
		
		int i=0;
		boolean j;
		while(i!=5)
		{
			random(i);
			j=identify();
			if(j==true)
			{
				i++;
			}
			else
			{
				continue;
			}
		}
		plus_identify();
	}
	public void plus_identify()
	{
		for(int i=0;i<5;i++)
		{
			array[2][i]=array[0][i]+array[1][i];
		}
		for(int j=0;j<5;j++)
		{
			for(int i=0;i<5;i++)
			{
				if(array[2][i]>9)
				{
					start();
					arrays();
					
				}
				if(array[0][j]==array[2][i])
				{
					start();
					arrays();
					
				}					
		    }
		}
		
	}
	public void plus()
	{
		for(int i=0;i<5;i++)
		{
			array[2][i]=array[0][i]+array[1][i];
		}
		plus_identify();
	}
	public void print()
	{
		arrays();
		
		for(int j=0;j<3;j++)
		{
		for(int i=0;i<5;i++)
		{
			System.out.print(array[j][i]);
			if(i==4)
			{
				System.out.println();
			}
		}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P160_8 a=new P160_8();
		a.arrays();
		
		a.print();
	}

}
