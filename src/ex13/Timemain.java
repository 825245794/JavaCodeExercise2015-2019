package ex13;
import java.util.Calendar;
public class Timemain extends JTimemain implements Runnable{
	public void run()
	{
		Calendar c = Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		if(hour>11)
		{
			d[8].setText(" p.m.");
		}
		else
		{
			d[8].setText(" a.m.");
		}
		d[0].setText(""+(int)(hour/10));
		d[1].setText(""+(int)(hour%10));
		d[2].setText(":");
		d[3].setText(""+(int)(minute/10));
		d[4].setText(""+(int)(minute%10));
		if(second%2==0)
		{
		d[5].setText(":");
		}
		else{
		d[5].setText(" ");
		}
		d[6].setText(""+(int)(second/10));
		d[7].setText(""+(int)((second%10)));
		
	}
	public static void main(String[] args) {
		Timemain t=	new Timemain();
	for(;;)
	{
		try {
			new Thread(t).start();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
		
}
