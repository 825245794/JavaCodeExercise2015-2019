package ex13;
//implements Runnable
public class RunThread1 extends Thread {
	int i;
	public void run()
	{
		for(i=1;i<6;i++)
		{
			System.out.println("你好,我的名字是张三，第"+i+"次来这儿");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunThread1().start();
		new RunThread2().start();
	}

}
