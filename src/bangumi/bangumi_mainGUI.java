package bangumi;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebClient;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Scanner; 
public class bangumi_mainGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel[] label;
	int index=0;
	static Point origin = new Point();
	
	int x=0,y=0;
	JLabel jltext[]=new JLabel[30];
	JLabel jltime[]=new JLabel[30];
	Calendar g = Calendar.getInstance();
	int c = g.get(Calendar.DAY_OF_WEEK) - 1;
	//int c=4;
	static String url;
	static int ii=0;
	JPanel panel=new JPanel();
	PopupMenu popupMenu1 = new PopupMenu();
    MenuItem menuItem1 = new MenuItem();
    static int record=-1;
    private static HttpClient httpClient=new DefaultHttpClient();
	public bangumi_mainGUI() throws MalformedURLException,IOException, SAXException{
	

		setSize(280, 420);
		setLayout(null);
		this.setUndecorated(true);
		this.setOpacity(0.58f);
		this.setBackground(new Color(0,0,0,0));
		
		//add(panel);
		for(int i=0;i<30;i++){
			jltext[i]=new JLabel("null");
			jltime[i]=new JLabel("null");
			jltext[i].setFont(new java.awt.Font("微软雅黑",1,11));
			jltime[i].setFont(new java.awt.Font("微软雅黑",1,10));
		}
		addlabeltext();
		int index=0;
		for(int i=0;i<30;i++){
			if(jltext[i].getText().equals("null"))
				continue;
			jltext[i].setBounds(75, i*24, 195, 20);
			jltext[i].setBackground(Color.black);
			jltext[i].setForeground(Color.white);
			jltext[i].setOpaque(true);
			add(jltext[i]);
			
			jltime[i].setBounds(1, i*24, 70, 20);
			jltime[i].setBackground(Color.black);
			jltime[i].setForeground(Color.white);
			
				
			
			jltext[i].addMouseMotionListener(new MouseMotionAdapter() {
				// 拖动
				public void mouseDragged(MouseEvent e) { 														
		
					Point p = getLocation(); 
					
					setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
							- origin.y);
				}
	 
	   });  
			
			if(index==0&&jltime[i].getText().indexOf("已更新")==-1){
				record=i;
				
					
								
				jltime[i].setBackground(Color.red);
				jltext[i].setBackground(Color.red);
				index++;
			}
		
			
			jltime[i].setOpaque(true);
			add(jltime[i]);
		}
		menuItem1.setLabel("Exit");
		popupMenu1.add(menuItem1);
		add(popupMenu1);
		
		setVisible(true);
		
		this.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) { 
					   triggerEvent(e);   
		        	
				origin.x = e.getX(); 
				origin.y = e.getY();
				}
			   public void mouseReleased(MouseEvent event) {   
	                triggerEvent(event);  
	            }  
				private void triggerEvent(MouseEvent event) { 
					int mods=event.getModifiers();
					if((mods&InputEvent.BUTTON3_MASK)!=0){
			           if (event.isPopupTrigger())   
			               popupMenu1.show(event.getComponent(), event.getX(), event.getY());   
			       }  }
   });
			
	
       
//		this.addMouseMotionListener(new MouseMotionAdapter() {
//			// 拖动
//			public void mouseDragged(MouseEvent e) { 														
//	
//				Point p = getLocation(); 
//				
//				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
//						- origin.y);
//			}
//		
//		
//		 
//   });  
		
		
		 menuItem1.addActionListener(new java.awt.event.ActionListener() { //菜单1的事件监听
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        	});
	}

	public void addlabeltext(){
		
			jltext[0].addMouseListener(new MouseAdapter(){
				int j=ii;
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					 
				            
								try {
									Desktop.getDesktop().browse(URI.create("null"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
				        
				    
					
				
				}

				@SuppressWarnings("deprecation")
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if(j!=record){
//						jltext[j].setBackground(new Color(230,156,33));
//						jltime[j].setBackground(new Color(230,156,33));
						jltext[j].setBackground(new Color(30,128,194));
						jltime[j].setBackground(new Color(30,128,194));
					}
					else{
						jltext[j].setBackground(Color.red);
						jltime[j].setBackground(Color.red);
					}
					javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 
					//String path="C:\\Users\\LJL\\Desktop\\img\\";
					//String path=fsv.getDefaultDirectory()+"\\bagu_img\\";
					String path=fsv.getDefaultDirectory()+"/bagu_img/";
					ImageIcon image=new ImageIcon(path+c+String.valueOf(j)+".jpg");
					//"C:\\Users\\LJL\\Desktop\\img\\"+c+String.valueOf(j)+".jpg"
					System.out.println(path+c+String.valueOf(j)+".jpg");
					setOpacity(0.78f);
					jltime[j].setIcon(image);
					jltime[j].setText("");
					jltime[j].resize(75, 48);
					jltext[j].resize(196, 48);
					System.out.println();
//					for(int i=j;i<30;i++){
//						jltime[i+1].setBounds(1,(i+1)*24+24,75, 48);
//						jltext[i+1].setBounds(75,(i+1)*24+24,196, 48);
//						jltime[i+1].repaint();
//					jltext[i+1].repaint();
//					}
					jltime[j].repaint();
					jltext[j].repaint();
				
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if(j!=record){
					jltext[j].setBackground(Color.black);
					jltime[j].setBackground(Color.black);
					}
				else{
					jltext[j].setBackground(Color.red);
					jltime[j].setBackground(Color.red);
				}
					setOpacity(0.58f);
					jltime[j].resize(70, 20);
					jltext[j].resize(196, 20);
					jltime[j].setText(null);
					jltime[j].setIcon(null);
//					for(int i=0;i<30;i++){
//						jltime[i].setBounds(1, i*24, 70, 20);
//						jltext[i].setBounds(75,i*24,195, 20);
//						jltime[i].repaint();
//					jltext[i].repaint();
//					}
					jltime[j].repaint();
					jltext[j].repaint();
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					   triggerEvent(e);   
			        	
						origin.x = e.getX(); 
						origin.y = e.getY();
						}
					   public void mouseReleased(MouseEvent event) {   
			                triggerEvent(event);  
			            }  
						private void triggerEvent(MouseEvent event) { 
							int mods=event.getModifiers();
							if((mods&InputEvent.BUTTON3_MASK)!=0){
					           if (event.isPopupTrigger())   
					               popupMenu1.show(event.getComponent(), event.getX(), event.getY());   
					       }  					 
				}

				
				
			}
		);
		}
		
	}


	
	
	
	
	
	
	

