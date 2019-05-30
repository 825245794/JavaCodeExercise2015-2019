package ex13;

public class RunThread2 extends Thread {
	public void run()
	{
		for(int i=1;i<6;i++)
		{
			System.out.println("你好,我的名字是李四，第"+i+"次来这儿");
		}
		
	}
}
