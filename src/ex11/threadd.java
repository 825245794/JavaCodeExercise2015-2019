package ex11;

public class threadd implements Runnable{
	public void run(){
		synchronized(this){  
			System.out.println(Thread.currentThread().getName());
				try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadd hyy=new threadd();
		String a[]=new String[10];
		int j=97;
		for(int i=0;i<a.length;i++){
			a[i]=String.valueOf((char)j);
			j++;
		}
	
		for(int i=0;i<a.length;i++){
			new Thread(hyy,a[i]).start();
		}
		
			
	}

}
