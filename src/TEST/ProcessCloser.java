package TEST;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.glass.ui.Window;


public class ProcessCloser extends Thread implements Runnable{
	String programName;
	private int identify=0;
	Thread thread=new Thread();
	static int time;
	boolean s=false;
	String path="/Volumes/LJL/1.txt";
	String path2="/Volumes/LJL/loggl.ini";
	String save1="/Volumes/LJL/savve.ini";
	public boolean isS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}
	static JTextField d[]={new JTextField(),new JTextField("10000")};
	
	public void idetify()
	{String a="";
		try {
			FileReader r=new FileReader("c:\\Windows\\save.ini");
			for(int j=r.read();j!=-1;j=r.read())
			{
				
				a+=(char)j;
				
			}
			identify=Integer.parseInt(a);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "缺少权限，请尝试使用右键管理员权限启动");
			System.exit(0);
		}
	}
	
	public void save()
	{
		try {
			String d =""+identify;
			FileWriter g=new FileWriter("c:\\Windows\\save.ini",false);
			
			g.write(d);
			g.flush();
			g.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "缺少权限，请尝试使用右键管理员权限启动");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "缺少权限，请尝试使用右键管理员权限启动");
			System.exit(0);
		}
	}
	public ProcessCloser ()
	{
		idetify();
		if(identify>8)
		{
		JOptionPane.showMessageDialog(null, "超过使用次数");
		System.exit(0);
		}
		identify++;
		save();
		JFrame a=new JFrame();
		a.setTitle("后台进程结束器");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container b=a.getContentPane();
		JPanel c=new JPanel(null);
		a.setSize(480, 240);
		JLabel[] e={new JLabel("进程名"),new JLabel("限定时间（毫秒）")};
		JButton[] jb={new JButton("开始"),new JButton("隐藏"),new JButton("注册")};
		jb[0].setBounds(200, 48, 150, 30);
		jb[1].setBounds(200, 120, 150, 30);
		e[0].setBounds(32, 20, 150, 30);
		d[0].setBounds(32, 48, 150, 30);
		e[1].setBounds(32, 90, 150, 30);
		d[1].setBounds(32, 120, 150, 30);
		jb[2].setBounds(350,170, 100, 30);
		jb[0].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			String o=jb[0].getText();
		
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(s)
					{
						programName=d[0].getText();
						try{
						time=Integer.parseInt(d[1].getText());
						}catch(Exception eg)
						{
							JOptionPane.showMessageDialog(null, "输入的时间格式不正确");
						}
						
							closeProcess();
							try {
								Thread.sleep(time);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								

					}}});

				
			
			
			if(o=="开始")
			{
			jb[0].setText("停止");
			setS(true);
			
			thread.start();
			}
			
			if(o=="停止")
			{
				jb[0].setText("开始");
				setS(false);
			}
		
		
			
	
			}
		});
		
		jb[1].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			a.setVisible(false);
		}});
		
		
		jb[2].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			
			 double i=Math.random()*10000000+88888888;
			 double j=((int)i+87654+12345)*3*4;
			String zc=JOptionPane.showInputDialog("您的随机八位序列码:"+(int)i,"输入激活码");
			
			try{
			
			double k=Double.parseDouble(zc);
			if((int)k==(int)j)
			{
				String a="1";	
				byte[] b=a.getBytes();
				FileOutputStream w;
				try {
					w = new FileOutputStream(path2);
					w.write(b);
			     	w.flush();
			    	w.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				JOptionPane.showMessageDialog(null, "注册成功");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "注册失败，激活码不正确");
			}

			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "注册失败，激活码不正确");
			}
			}});
		
		
		
		a.add(c);
		c.add(d[0]);
		c.add(d[1]);
		c.add(e[0]);
		c.add(e[1]);
		c.add(jb[0]);
		c.add(jb[1]);
		c.add(jb[2]);
		a.setVisible(true);
		
		//programName=d[0].getText();
	}
	
	public void run()
	{
		
		
			
		
	}
	public void closeProcess(){
		  Process listprocess;
		  
		  try {
		   listprocess = Runtime.getRuntime().exec("cmd.exe /c tasklist");
		   InputStream is = listprocess.getInputStream();
		   BufferedReader r = new BufferedReader(new InputStreamReader(is));
		   //StringBuffer sb = new StringBuffer();
		   String str = null;
		   while ((str = r.readLine()) != null) { 
		    String id = null; 
		    Matcher matcher = Pattern.compile(programName + "[ ]*([0-9]*)").matcher(str); 
		    while (matcher.find()) {  
		     if (matcher.groupCount() >= 1) {   
		      id = matcher.group(1);   
		      if (id != null) {    
		       Integer pid = null;    
		       try {     
		        pid = Integer.parseInt(id);    
		        } catch (NumberFormatException e) {     
		         e.printStackTrace();    
		         }    
		        if (pid != null) {     
		         Runtime.getRuntime().exec("cmd.exe /c taskkill /f /pid " + pid);     
		         System.out.println("kill progress"+pid);    
		         }   
		        }  
		      }
		    }
		   }
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new ProcessCloser();
			
		
		//ProcessCloser a=new ProcessCloser();
		
	}

}
