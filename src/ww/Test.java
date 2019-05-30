package ww;

import java.awt.Color;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Test {
	public static void main(String[] args) {
		JFrame win = new JFrame("");
		win.setUndecorated(true);
		win.setSize(960, 640);
		win.setVisible(true);
		win.setAlwaysOnTop(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point origin = new Point(); 
		JPanel panel = new JPanel();
		panel.setSize(win.getWidth(), win.getHeight());
		panel.setOpaque(true);
		panel.setBackground(new Color(151,126,217));
		panel.setLayout(null);
		win.add(panel);
		PopupMenu popupMenu1 = new PopupMenu();
	    MenuItem menuItem1 = new MenuItem();
	    menuItem1.setLabel("Quit");
	    popupMenu1.add(menuItem1);
		Ball ball[] = new Ball[70];
		for(int i=0;i<ball.length;i++){
			int r=(int)(Math.random()*50+10);
			int x=(int)(Math.random()*10);
			int y=(int)(Math.random()*150);
			int xSpeed=(int)(Math.random()*10);
			int ySpeed=(int)(Math.random()*10);
			ball[i]=new Ball(new Color(255,255,255,136),68,x,y,xSpeed,ySpeed,panel);
			panel.add(ball[i]);
		}
	charts charts=new charts();
	panel.add(charts);
	
		
		 win.addMouseListener(new MouseAdapter() {
				
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
				
	      
	       
			win.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) { 					
					Point p = win.getLocation(); 
					win.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
							- origin.y);
				}
			
			
			 
	   });  
			menuItem1.addActionListener(new java.awt.event.ActionListener() { //菜单1的事件监听
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        	});
	}
	
}
