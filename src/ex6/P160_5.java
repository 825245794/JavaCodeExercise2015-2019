package ex6;

public class P160_5 {
static int i,n;
static int[] Array;
public P160_5()
{
Array=new int[21];
n=10000;
}
	public static int random()
	{
		i=(int)(Math.random()*20+0.5);
		return i;
	}
	public void print()
	{
		int k,j = 0;
		while(j!=n)
		{
			k=random();
			Array[k]++;
			j++;
		}
		for(j=0;j<21;j++)
		{
			System.out.println(j+":"+Array[j]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
P160_5 a=new P160_5();
a.print();
	}

}
