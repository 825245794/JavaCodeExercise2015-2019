package ex6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Calendars {
static int i;
int Year;
static int arr=0;
static int mon;
static int M_month;
String []array;
Date date;
Calendar_Week Week=new Calendar_Week();
Calendar_Month Month=new Calendar_Month();
Calendar cal = new GregorianCalendar(Year,1,1);
Calendar c = Calendar.getInstance();
	
	public Calendars()
{
	M_month=0;
	mon=-1;
    array=new String[100];
	
}
	public void Year(int Year)
	{
		this.Year=Year;
	}
	public void setdate()
	{
		int k=M_month();
		String strDate = Year+"-"+k+"-01";
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  try {
			   date = format.parse(strDate);
			  } catch (ParseException e) {
			   System.out.println(e);
			  }
	}
	public int M_month()
	{
		
		M_month++;
		return M_month;
	}
	public int week()
	{
		int k;
		cal.setTime(date);
		k=cal.get(Calendar.DAY_OF_WEEK)-1;
		if(k<0)
		{
			k=0;
			return k;
		}
		return k;
	}
	public String month()
	{
		mon++;
		String Mon=Month.Month[mon];
		return Mon;
	}
	public void data_and_week(int j,int k)
	{
		if(j==1&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"1  "+Week.Week[0][1];
				arr++;
		}
		if(j==2&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"2  "+Week.Week[0][2];
				arr++;
		}

		if(j==3&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"3  "+Week.Week[0][3];
				arr++;
		}

		if(j==4&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"4  "+Week.Week[0][4];
				arr++;
		}

		if(j==5&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"5  "+Week.Week[0][5];
				arr++;
		}

		if(j==6&&k-j==0)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"6  "+Week.Week[0][6];
				arr++;
		}

		if(j==7&&j-k==7)
		{
			
				array[arr]=Year+"."+(M_month)+"."+"7  "+Week.Week[0][0];
				arr++;
		}
	}

		public void date()
	{
		int j=0;
		setdate();
		int k=week();
		System.out.println(month());
		for(i=1;i<7;i++)
		{
			if(i==1)
			{
				while(k!=7)
				{
					j++;
					
				Week.Week[i][k]=" "+j+"";
				data_and_week(j,k);

				    k++;
				}
			}
			else
			{
				for(int i1=0;i1<7;i1++)
				{
					
					j++;
					data_and_week(j,i1);
					
					if(M_month==4||M_month==5||M_month==6||M_month==9||M_month==11)
					{
						if(j>30)
						{
						break;
						}
					}
					if(M_month==2)
					{
						if(Year%4==0 && Year%100!=0 ||Year%400==0)
						{
						if(j>29)
						{break;}
						}
						else
						{
							if(j>28)
								{
								break;
								}
						}
							
					}
					if(M_month==1||M_month==3||M_month==7||M_month==8||M_month==10||M_month==12)
					{
						if(j>31)
						{
						break;
						}
					}
					if(j<10)
					{
						Week.Week[i][i1]=j+" ";
						
					}
					
					else{
					Week.Week[i][i1]=""+j+"";
					}
				}
			}
		}
	}
	public void allclear()
	{
		for(int i=1;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				Week.Week[i][j]="  ";
			}
		}
	}
	public void clearnull()
	{
		for(i=0;i<7;i++)
		{
			for(int y=0;y<7;y++)
			{
		
			if(Week.Week[i][y]==null)
			{
				Week.Week[i][y]="  ";
			}
			}
		}
	}
	public void print()
	{
		
		System.out.println(Year);
		for(int j=0;j<12;j++)
		{
		date();
        clearnull();		
		for(i=0;i<7;i++)
		{			
			System.out.print(Week.Week[0][i]);
		}		
		System.out.println();
		for(i=1;i<7;i++)
		{
			for(int y=0;y<7;y++)
			{
			System.out.print(" "+Week.Week[i][y]+" ");	
			
			
			
			if(y==6)
			{
				System.out.println();
			}
			
			}
		}
		allclear();
}
		System.out.println("");
		for(int d=0;d<arr;d++)
		{
			System.out.println(array[d]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Calendars a=new Calendars();
Scanner input=new Scanner(System.in);
System.out.print("Enter Year(example:2016):");
int i=input.nextInt();
a.Year(i);
a.print();
input.close();
	}

}
