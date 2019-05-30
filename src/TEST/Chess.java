package TEST;
import java.util.Scanner;
public class Chess {
	public int i,j,i1,j1,k=0,q1=0,q2=0;
	static int [] q;
	static int [][] Array;
	static String [][] Text;
	public void Ramdon()
	{
	for(i=0;i<3;i++)
	{
		k++;
		int l=1;
		for(j=0;j<3;j++)
		{
			Text[i][j]=new String("("+l+","+k+")");
			++l;
		}
	}

	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			Array[i][j]=-1;
			
		}
	}
	
	}
	public void Easy()
	{
		Text[1][1]=("  5  ");
		Array[1][1]=5;
	}
	public void Difficult()
	{
		i=(int)(0+Math.random()*(2-0+1));
		j=(int)(0+Math.random()*(2-0+1));
		i1=(int)(1+Math.random()*(9-1+1));
		Text[i][j]=("  "+i1+"  ");
		Array[i][j]=i1;
	}
	Chess() {
	
		Array=new int[3][3];
		Text=new String [3][3];
		q=new int[3];
	}
	public static boolean Change(int in,int put)
	{
		int part1,part2;
		part1=(in%10)-1;
		part2=(in/10)-1;
		if(part1>2||part2>2)
		{
			return(false);
		}
		else
		{
		Text[part1][part2]=("  "+put+"  ");
		Array[part1][part2]=put;
		return(true);
		}
		
	}
	public static void Print(){
	
		System.out.print("------------------------------");
		System.out.println();
		System.out.println("|         |         |        |");
		System.out.println("|  "+Text[0][0]+"  |  "+Text[1][0]+"  |  "+Text[2][0]+" |");
		System.out.println("|         |         |        |");
		System.out.print("------------------------------");
		System.out.println();
		System.out.println("|         |         |        |");
		System.out.println("|  "+Text[0][1]+"  |  "+Text[1][1]+"  |  "+Text[2][1]+" |");
		System.out.println("|         |         |        |");
		System.out.print("------------------------------");
		System.out.println();
		System.out.println("|         |         |        |");
		System.out.println("|  "+Text[0][2]+"  |  "+Text[1][2]+"  |  "+Text[2][2]+" |");
		System.out.println("|         |         |        |");
		System.out.print("------------------------------");
	}
	public boolean smilar2()
	{
		int k1;
		int q4 = 0;
		for(int i3=0;i3<3;i3++)
		{
			for(int j3=0;j3<3;j3++)
			{
			 k1=Smilar(Array[i3][j3]);
				q4+=k1;
					
			}
		}
		if(q4!=9)
		{
			return(false);
		}	
			return(true);
	}
	
	public int Smilar(int i)
	{
		int k2=0;
			
				for(int i4=0;i4<3;i4++)
				{
					for(int j4=0;j4<3;j4++)
					{
						if(i==Array[i4][j4])						
								{k2++;
								if(k2>1)
								{
									Array[i4][j4]=-1;
									Text[i4][j4]=("("+(j4+1)+","+(i4+1)+")");
								}
								}
						
						else{
							continue;
						}
						
					}
				}
				return k2;
				
		
	}
	public boolean identifynum(int put)
	{
		if(put>0&&put<10)
		{
			return(true);
		}
		return false;
	}
	public boolean identifymath()
	{

		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(Array[i][j]==-1)
				{
					return(false);
					
				}
				
				
			}
		}
		return(true);
	}
	public boolean IdentifyH()
	{
		
		for(i=0;i<3;i++)
		{
		q[i]=0;
			for(j=0;j<3;j++)
			{
				q[i]=q[i]+Array[i][j];
				
			}
		}
		if(q[0]==15&&q[1]==15&&q[2]==15)
		{
			return(true);
			
		}
		return(false);
		
			
		
	}
	public boolean IdentifyX()
	{
		
	q2=Array[0][0]+Array[1][1]+Array[2][2];
	q1=Array[0][2]+Array[1][1]+Array[2][0];	
		if(q2!=15&&q1!=15)
		{
			return(false);
			
		}
		
		return(true);
		
	}
	public boolean IdentifyS()
	{
		
		for(i=0;i<3;i++)
		{
			q[i]=0;
			for(j=0;j<3;j++)
			{
				q[i]=q[i]+Array[j][i];
						}
			
		}
		if(q[0]==15&&q[1]==15&&q[2]==15)
		{
			return(true);
			
		}
		return(false);
			
		
	}
	public void Select()
	{int a;
	Scanner input=new Scanner(System.in);
	Chess chess=new Chess();
	chess.Ramdon();
		for(;;)
		{
			
		System.out.println("输入数字选择难度");
		System.out.println("1.简单模式");
		System.out.println("2.困难模式");
		System.out.println("3.专家模式");
		System.out.print("");
		a=input.nextInt();
		if(a==1)
		{
			chess.Easy();
			break;
		}
		if(a==2)
		{
			
			break;
		}
		if(a==3)
		{
			chess.Difficult();
			break;
		}
		if(a!=1||a!=3||a!=2)
			
		{
			System.out.println("输入错误");
			
		}
		}
		
		
	}
	public void Mmain()
	{
		int put,in = 0;
		boolean b,c,d,e;
		boolean f;
		Scanner input=new Scanner(System.in);
		Chess chess=new Chess();		
		chess.Select();
		Chess.Print();
		start:
		for(;;)
		{
			 b=chess.identifymath();
			   if(b==true)
				{		  
				   f=chess.smilar2();
				   if(f==false)
				   {
					   System.out.println();
					   Chess.Print();
					   System.out.println();
					  System.out.println("数字相同");
					  System.out.print("");
					 continue start;
				   }
				   System.out.println();
					c=chess.IdentifyH();
					d=chess.IdentifyS();
					e=chess.IdentifyX();
					System.out.println("检查横行:"+c);
					System.out.println("检查竖列:"+d);
					System.out.println("检查对角:"+e);
					if(c==false&&d==false&&e==false)
					{
						System.out.println("计算结果不为15");
						System.out.println();
						chess.Select();
						Chess.Print();
						continue start;
					}
				   if(c==true&&d==true&&e==true){
						System.out.println("已完成");
						
					}
				   break;
				}
			  
		System.out.println();
	    System.out.print("输入坐标:");
		try{
	        in=input.nextInt();
	        b=Change(in,-1);
		}catch (Exception e1) {
            // TODO: handle exceptio;
	        System.out.print("坐标错误，（1，2）坐标输入为12");
	        Mmain();
        }
		if(b==false)
		{
			System.out.println("坐标不正确");
			continue start;
		}
		System.out.print("");
		System.out.print("输入数字:");
		put=input.nextInt();
		b=chess.identifynum(put);
		  if(b==false)
		  {
			  System.out.println("输入数字的范围不在1~9之间");
			  continue start;
		  }

		Change(in,put);
		Chess.Print();
		
	}input.close();}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chess s=new Chess();
		s.Mmain();
		}
	

}
