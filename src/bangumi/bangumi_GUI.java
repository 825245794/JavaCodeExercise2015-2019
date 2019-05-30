package bangumi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.misc.BASE64Decoder;

public class bangumi_GUI extends bangumi_get implements Runnable{
	FileInputStream r;
	Vector<String> name=new Vector<String>();
	Vector<String> time=new Vector<String>();
	Vector<String> url=new Vector<String>();
	Vector<String> jishu=new Vector<String>();
	String[][] zrs=getZrs();
	String[][] zfs=getZfs();
	String[][] dms=getDms();
	String[][] gxsj=getGxsj();
	String[][] jj=getJj();
	String name_get[][]=getName();
	String time_get[][]=getTime();
	String url_get[][]=getUrl();
	String jishu_get[][]=getJishu();
	Calendar g = Calendar.getInstance();
	JFrame frame=new JFrame();
	JPanel main_panel=new JPanel();
	static JPanel anime_panel=new JPanel();
	JLabel[] time_label=new JLabel[30];
	JLabel[] name_label=new JLabel[30];
	JLabel anime=new JLabel("<html>新<br>番<br>推<br>送",JLabel.CENTER);
	JLabel support=new JLabel("<html>支<br>持",JLabel.CENTER);
	JLabel calendar=new JLabel("",JLabel.CENTER);
	JLabel day=new JLabel("",JLabel.CENTER);
	int week;
	int record=-1;
	int record_stop=-1;
	static boolean panel_dis=false;
	ImageIcon imageicon=new ImageIcon();
	JLabel image=new JLabel();
	static Object o=null;
	boolean t=false;
	static int ii=0;
	static Point origin = new Point(); 
	static JPanel support_panel=new JPanel();
	public bangumi_GUI(){
//		try {
//			r=new FileInputStream(System.getProperty("user.dir")+"\\data\\wehi.dll");
//			String a="";
//			
//			for(int i=r.read();i!=-1;i=r.read())
//			{
//				a+=(char)i;
//			}
//			BASE64Decoder decoder = new sun.misc.BASE64Decoder(); 
//			byte[] bytes1;
//			bytes1 = decoder.decodeBuffer(a);
//			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);      
//	        BufferedImage bi1 =ImageIO.read(bais);
//	        imageicon.setImage(bi1);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "文件读取失败 错误代码:502");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		week();
		sort_out();
		GUI();
		Listener();
		
               
       
		
	}
	
	public void GUI(){
		add_new();
		color();
		ListToComponents();
		
		frame.setSize(300, 420);
		frame.setLayout(null);
		main_panel.setLayout(null);
		main_panel.setBounds(0, 0, 30, frame.getHeight());
		anime_panel.setLayout(null);
		anime_panel.setBounds(30, 0, frame.getWidth()-30, frame.getHeight());
		support_panel.setLayout(null);
		support_panel.setBounds(30, 0, frame.getWidth()-30, frame.getHeight());
		
		frame.add(main_panel);
		location();
		frame.add(anime_panel);
		add_components();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void Listener(){
		
                // TODO Auto-generated method stub
		for(int i=0;i<30;i++){
			ii=i;
			time_label[i].addMouseListener(new MouseAdapter(){
				int j=ii;
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					Point p =frame.getLocation(); 
					frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
							- origin.y);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					if(j!=record&&time_label[j].getText().indexOf("本周停更")==-1){
					time_label[j].setBackground(new Color(230,156,33));
					name_label[j].setBackground(new Color(230,156,33));
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(j!=record&&time_label[j].getText().indexOf("本周停更")==-1){
					time_label[j].setBackground(Color.black);
					name_label[j].setBackground(Color.black);
					}
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					origin.x = e.getX(); 
					origin.y = e.getY();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseReleased(e);
				}
				
			});
			
			name_label[i].addMouseListener(new MouseAdapter(){
				int j=ii;
				bangumi_info a;
				public void mouseEntered(MouseEvent arg0){
					Point p =frame.getLocation(); 
					Point k=name_label[j].getLocation();
					a=new bangumi_info(p.x+310,(p.y+k.y),name.get(j),time.get(j),url.get(j),zrs[week][j],zfs[week][j],dms[week][j],gxsj[week][j],jj[week][j],week,j);
					if(j!=record&&time_label[j].getText().indexOf("本周停更")==-1){
					time_label[j].setBackground(new Color(230,156,33));
					name_label[j].setBackground(new Color(230,156,33));
					}
				}
				
				public void mouseExited(MouseEvent arg0){
					a.cancel();
					if(j!=record&&time_label[j].getText().indexOf("本周停更")==-1){
					time_label[j].setBackground(Color.black);
					name_label[j].setBackground(Color.black);
					}
				}
				
				public void mouseDragged(MouseEvent e) {
					Point p =frame.getLocation(); 
					frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
							- origin.y);
				}
				
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					origin.x = e.getX(); 
					origin.y = e.getY();
				}
			});
		}
		
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { 														
				Point p =frame.getLocation(); 
				frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
						- origin.y);
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				origin.x = e.getX(); 
				origin.y = e.getY();
			}
   });  
		
		support.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
				
			        imageicon.setImage(imageicon.getImage().getScaledInstance(image.getWidth(),image.getHeight()-20,Image.SCALE_DEFAULT));
			        frame.setOpacity(0.92f);
			        image.setIcon(imageicon);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					image.setForeground(Color.red);
					image.setText("<html><font align=\"center\">Error");
				}      
				anime_panel.setVisible(false);
				support_panel.setVisible(true);
			}
		
		});
	
		
		anime.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				anime_panel.setVisible(true);
				support_panel.setVisible(false);
				frame.setOpacity(0.57f);
			}
		
		});
	
	}
	
	
	public void ListToComponents(){
		for(int i=0;i<time.size();i++){
			if(time.get(i).indexOf("更")==-1){
				String a=time.get(i);
				time.set(i, jishu_get[week][i]);
				jishu_get[week][i]=a;
			}
			if(!time.get(i).equals(null)){
				time_label[i].setText(time.get(i));
				name_label[i].setText(name.get(i));
			}
		}
	}
	
	public void location(){
		int k=0;
		for(int i=0;i<30;i++){
			if(!time_label.equals(null)){
				time_label[i].setBounds(2, i*24+24, 70, 20);
				name_label[i].setBounds(77, i*24+24, 195, 20);
				k=i*24+24;
			}
		}
		anime.setBounds(9,0,20,60);
		support.setBounds(9, 62, 20, 60);
		day.setBounds(2, 0, 70, 20);
		calendar.setBounds(77,0, 195, 20);
		image.setBounds(0,0, support_panel.getWidth(), support_panel.getHeight());
	}
	public void add_components(){
		for(int i=0;i<time.size();i++){
			if(!time_label[i].getText().equals(null)){
				anime_panel.add(time_label[i]);
				anime_panel.add(name_label[i]);
			}
		}
		main_panel.add(anime);
		main_panel.add(support);
		anime_panel.add(day);
		anime_panel.add(calendar);
		frame.add(support_panel);
		support_panel.add(image);
	}
	
	public void add_new(){
		for(int i=0;i<30;i++){
			time_label[i]=new JLabel("",JLabel.CENTER);
			name_label[i]=new JLabel();
			time_label[i].setText(null);
			name_label[i].setText(null);
			time_label[i].setOpaque(true);
			name_label[i].setOpaque(true);
		}
		anime.setOpaque(true);
		support.setOpaque(true);
		calendar.setOpaque(true);
		day.setOpaque(true);
	}
	
	public void clear(){
		for(int i=0;i<30;i++){
			time_label[i].setText(null);
			name_label[i].setText(null);
		}
	}
	public void color(){
		frame.setUndecorated(true);
		frame.setOpacity(0.57f);
		frame.setBackground(new Color(0,0,0,0));
		//anime_panel.setBackground(Color.BLACK);
		anime_panel.setBackground(new Color(0,0,0,0));
		support_panel.setBackground(new Color(0,0,0,0));
		main_panel.setBackground(new Color(0,0,0,0));
		for(int i=0;i<30;i++){
		time_label[i].setBackground(Color.black);
		time_label[i].setForeground(Color.white);
		name_label[i].setBackground(Color.black);
		name_label[i].setForeground(Color.white);
		day.setBackground(Color.black);
		day.setForeground(Color.white);
		calendar.setBackground(Color.black);
		calendar.setForeground(Color.white);
		anime.setBackground(Color.blue);
		anime.setForeground(Color.white);
		support.setBackground(Color.red);
		support.setForeground(Color.white);
		name_label[i].setFont(new java.awt.Font("微软雅黑",1,11));
		time_label[i].setFont(new java.awt.Font("微软雅黑",1,10));
		anime.setFont(new java.awt.Font("微软雅黑",1,10));
		support.setFont(new java.awt.Font("微软雅黑",1,11));
		calendar.setFont(new java.awt.Font("微软雅黑",1,11));
		day.setFont(new java.awt.Font("微软雅黑",1,10));
			}
	}
	
	public void identify(){
		 int j=0;
		 int k=0;
		 try {
			FileInputStream r=new FileInputStream(System.getProperty("user.dir")+"\\data\\wehi.dll");
			//C:\\Users\\LJL\\Desktop\\1.txt
			for(int i=r.read();i!=-1;i=r.read())
			{
				k++;
				String b=String.valueOf((char)i);
				if(b.equals("A")){
					j++;
				}
			}
			r.close();
			//System.out.println(a);
		} catch (FileNotFoundException e) {
	
		} catch (IOException e) {
			
		}
		 System.out.println(j);//3169
		 System.out.println(k);//68104
		if(j!=3169||k!=68104){
			JOptionPane.showMessageDialog(null, "文件似乎遭遇破坏 错误代码:500");
			System.exit(0);
		}
		
	}
	
	public void run(){
		
		
		for(;;){
		 switch(week){
		 case 0:day.setText("星期日");break;
		 case 1:day.setText("星期一");break;
		 case 2:day.setText("星期二");break;
		 case 3:day.setText("星期三");break;
		 case 4:day.setText("星期四");break;
		 case 5:day.setText("星期五");break;
		 case 6:day.setText("星期六");break;
		 }
		 int index=0;
		// identify();
		 for(int i=0;i<time.size();i++){
			 if(time_label[i].getText().indexOf("本周停更")!=-1){
//				 time_label[i].setText("<html><s>"+time_label[i].getText()+"</s>");
//				 name_label[i].setText("<html><s>"+name_label[i].getText()+"</s>");
				 name_label[i].setBackground(Color.pink);
				 time_label[i].setBackground(Color.pink);
			 }
			 if(time.get(i).indexOf("已更新")==-1&&index==0){
				 name_label[i].setBackground(new Color(30,128,194));
				 time_label[i].setBackground(new Color(30,128,194));
				 record=i;
				 index++;
			 }
		 }
		 Calendar c = Calendar.getInstance();
		 int second=c.get(Calendar.SECOND);
		 int hour=c.get(Calendar.HOUR_OF_DAY);
		 int minute=c.get(Calendar.MINUTE);
		 int hour1=(int)(hour/10);
		 int hour2=(int)(hour%10);
		 int minute1=(int)(minute/10);
		 int minute2=(int)(minute%10);
		 int year=c.get(Calendar.YEAR);
		 int month=c.get(Calendar.MONTH)+1;
		 int day=c.get(Calendar.DAY_OF_MONTH);
		 if(second<10) calendar.setText(year+"年"+month+"月"+day+"日        "+hour1+hour2+" : "+minute1+minute2+" : "+"0"+second);
		 else  calendar.setText(year+"年"+month+"月"+day+"日        "+hour1+hour2+" : "+minute1+minute2+" : "+second);
//		 if(t==true){
//			 t=false;
//			 calendar.setBackground(Color.blue);
//		 }
//		 else if(t==false){
//			 t=true;
//			 calendar.setBackground(Color.black);
//		 }
		 try {
			Thread.sleep(1000);
			synchronized(this) {
                while(t) {
                   wait();
                   Listener();
                }
		}} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		 
	}
	 /**
     * 暂停
     */
     void suspend(){
       t= true;
    }
     
     /**
      * 继续
      */
     synchronized void resume(){
         t = false;
         notify();
     }
	public void week(){
		week=g.get(Calendar.DAY_OF_WEEK) - 1;
		if(week==7) week=0;
	}
	
	public void sort_out(){
		for(int i=0;i<name_get[week].length;i++){
			if(name_get[week][i]!=null){
				name.add(name_get[week][i]);
				time.add(time_get[week][i]);
				url.add(url_get[week][i]);
			}
			//System.out.print(time.size());
		}
	}
	
}
