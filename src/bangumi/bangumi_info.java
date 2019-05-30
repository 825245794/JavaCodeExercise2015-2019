package bangumi;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class bangumi_info{
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JPanel[] color_panel=new JPanel[2];
	static String url=null;
	static boolean dis=true;
	static boolean dis1=true;
	static boolean dis2=true;
	static boolean dis3=true;
	static Document document;
	String name;
	String time;
	int week;
	int j;
	JLabel play=new JLabel("Play",JLabel.CENTER);
	public bangumi_info(int x,int y,String name,String time,String url,String zrs,String zfs,String dms,String gxsj,String jj,int week,int j){
		 this.url=url;
		 this.name=name;
		 this.time=time;
		 this.week=week;
		 this.j=j;
		 initialize(x,y);
		 Listener();
		
		 sort_out(name,time,zrs,zfs,dms,gxsj,jj,week,j);
	}
	
	public void Listener(){
		play.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				String a=url;
				// TODO Auto-generated method stub

				try {
					Desktop.getDesktop().browse(URI.create("http://"+a));
					frame.setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
				play.setForeground(new Color(30,128,194));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				play.setForeground(Color.white);
				dis=true;
				
			}
			
		});
		frame.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=true;
				cancel();
			}
			
		});
		
		color_panel[0].addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis1=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis1=true;
				cancel();
			}
			
		});
		
		color_panel[1].addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis2=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis2=true;
				cancel();
			}
			
		});
		
		panel.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis3=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis3=true;
				
			}
			
		});
	}
	
	public void sort_out(String name,String time,String zrs,String zfs,String dms,String gxsj,String jj,int week,int j){
		javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
		ImageIcon image=new ImageIcon(fsv.getDefaultDirectory()+"\\bagu_img\\"+week+String.valueOf(j)+".jpg");
		JLabel image_label=new JLabel();
		image_label.setIcon(image);
		image_label.setSize(72,96);
		image_label.setBounds(40, 120, image_label.getWidth(), image_label.getHeight());
		image_label.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=true;
				
			}
		});
		panel.add(image_label);
		
		JLabel name_label=new JLabel(name);
		name_label.setBounds(132, 100, frame.getWidth(), 30);
		name_label.setForeground(Color.white);
		name_label.setFont(new java.awt.Font("微软雅黑",1,12));
		name_label.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=true;

			}
		});
		panel.add(name_label);
		
		JLabel time_label=new JLabel("更新时间:"+time);
		time_label.setBounds(132, 120, frame.getWidth(), 30);
		time_label.setFont(new java.awt.Font("微软雅黑",1,12));
		time_label.setForeground(Color.white);
		time_label.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=true;
				
			}
		});
		panel.add(time_label);
	
		JLabel zrs_play=new JLabel(zrs);
		zrs_play.setBounds(132, 140, frame.getWidth(), 30);
		zrs_play.setFont(new java.awt.Font("微软雅黑",1,12));
		zrs_play.setForeground(Color.white);
		zrs_play.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dis=false;
			}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		dis=true;

		}
		});
		panel.add(zrs_play);
		
		JLabel gxsj_play=new JLabel(gxsj);
		gxsj_play.setBounds(40, 216, frame.getWidth(), 30);
		gxsj_play.setFont(new java.awt.Font("微软雅黑",1,12));
		gxsj_play.setForeground(Color.white);
gxsj_play.addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=true;
		
	}
		});
		panel.add(gxsj_play);
		
		JLabel zfs_play=new JLabel(zfs);
		zfs_play.setBounds(132, 160, frame.getWidth(), 30);
		zfs_play.setFont(new java.awt.Font("微软雅黑",1,12));
		zfs_play.setForeground(Color.white);
zfs_play.addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=true;
		
	}
		});
		panel.add(zfs_play);
		
		JLabel dms_play=new JLabel(dms);
		dms_play.setBounds(132, 180, frame.getWidth(), 30);
		dms_play.setFont(new java.awt.Font("微软雅黑",1,12));
		dms_play.setForeground(Color.white);
dms_play.addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=true;
		
	}
		});
		panel.add(dms_play);
		
		JLabel jj_play=new JLabel(jj);
		jj_play.setBounds(40, 240, frame.getWidth()-60, 120);
		jj_play.setFont(new java.awt.Font("微软雅黑",1,10));
		jj_play.setForeground(Color.white);
		jj_play=createJLabelWithWrapWidth(frame.getWidth()-50, jj_play);
jj_play.addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=true;
		
	}
		});
		panel.add(jj_play);
		
		JLabel xx=new JLabel("Infomation",JLabel.CENTER);
		xx.setBounds(0, 0, frame.getWidth(),90);
		xx.setFont(new java.awt.Font("微软雅黑",1,30));
		xx.setForeground(new Color(30,128,194));
		xx.setForeground(Color.white);
xx.addMouseListener(new MouseAdapter(){
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=false;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		dis=true;

	}
		});
		color_panel[0].add(xx);
		
		
		play.setBounds(0, 0, frame.getWidth(),90);
		play.setFont(new java.awt.Font("微软雅黑",1,20));
		play.setForeground(Color.white);
		color_panel[1].add(play);
	}
	
	 public JLabel createJLabelWithWrapWidth(int width, JLabel label){  
	        if (width <= 0 || label == null){  
	            return label;  
	        }  
	        String text = label.getText();  
	        if (!text.startsWith("<html>")){  
	            StringBuilder strBuilder = new StringBuilder("<html>");  
	            strBuilder.append(text);  
	            strBuilder.append("</html>");  
	            text = strBuilder.toString();  
	        }  
	        label.setText(text);  
	        View labelView = BasicHTML.createHTMLView(label, label.getText());  
	        labelView.setSize(width, 100);  
	        label.setPreferredSize(new Dimension(width, (int) labelView.getMinimumSpan(View.Y_AXIS)));  
	        return label;  
	    }  
	 
	public void initialize(int x,int y){
		frame.setSize(360, 460);
		frame.setUndecorated(true);
		panel.setOpaque(true);
		frame.setLayout(null);
		panel.setLayout(null);
		frame.setLocation(x, y);
		for(int i=0;i<color_panel.length;i++){
			color_panel[i]=new JPanel();
			color_panel[i].setLayout(null);
			color_panel[i].setOpaque(true);
			color_panel[i].setBackground(new Color(40,40,40));
			panel.add(color_panel[i]);
		}
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setBackground(new Color(62,62,62));
		color_panel[0].setBounds(0, 0, frame.getWidth(), 90);
		color_panel[1].setBounds(0, frame.getHeight()-90, frame.getWidth(), 90);
		frame.setOpacity(0.88f);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void cancel(){
		if(dis==true) {
			Timer timer=new Timer();
			timer.schedule(task, 1,1);
		} 
	}
	TimerTask task = new TimerTask() {   
		public void run() { 
			if(dis==true&&dis1==true&&dis2==true&&dis3==true) {
			frame.dispose();  
			}
		}   
		}; 
	
//	public static void main(String[] args) throws MalformedURLException,IOException, SAXException {
//		 bangumi_info a=new  bangumi_info();
//		
//	}
}
