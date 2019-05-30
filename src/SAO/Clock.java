package SAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * 时间类
 * *
 */
public class Clock extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 141453156;
    static Point origin = new Point(); 
    PopupMenu popupMenu1 = new PopupMenu();
    MenuItem menuItem1 = new MenuItem();
    MenuItem menuItem2 = new MenuItem();
    public Clock() {
    	
    	this.setUndecorated(true); 
    	this.setOpacity(0.67f);
        ClockPaint cp = new ClockPaint(20, 20, 70);
        this.setBackground(Color.gray);
        this.add(cp);
        add(popupMenu1);
        this.setSize(190, 170);
        this.setResizable(false);
        this.setLocation(260, 120);
        this.setVisible(true);
        menuItem1.setLabel("Set");
        menuItem2.setLabel("Quit");
        popupMenu1.add(menuItem1);
        popupMenu1.add(menuItem2);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    
        menuItem1.addActionListener(new java.awt.event.ActionListener() { //菜单1的事件监听
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        	});
        menuItem2.addActionListener(new java.awt.event.ActionListener() { //菜单2的事件监听
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        	});
    
        //拖动窗体
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
			
      
       
		this.addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged
			// 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) { 														
				// 当鼠标拖动时获取窗口当前位置
				Point p = getLocation(); 
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
						- origin.y);
			}
		
		
		 
   });  
    }

    public static void main(String[] s) {
    	
        new Clock();
    }
}

class ClockPaint extends JPanel implements Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int x, y, r;
    int h, m, s,hour,minute;// 小时，分钟，秒
    double rad = Math.PI / 180;
   
    public ClockPaint(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        setOpaque(false); 
        this.setLayout(null);
       
        
        Calendar now = new GregorianCalendar();
        s = now.get(Calendar.SECOND) * 6;// 获得秒转换成度数
        m = now.get(Calendar.MINUTE) * 6;// 获得分钟
        h = (now.get(Calendar.HOUR_OF_DAY) - 12) * 30
                + now.get(Calendar.MINUTE) / 12 * 6;// 获得小时
        
        Thread t = new Thread(this);
        t.start();
        
    
    
    }
   	
    public void paint(Graphics g) {
        // 清屏
    	super.paint(g);
    	
        g.setColor(Color.black);
      g.fillRect(0, 0, r * 3, r * 3);
        // 画圆
//        g.setColor(Color.WHITE);
//        g.drawOval(x, y, r * 2, r * 2);
//        // 秒针
//        g.setColor(Color.RED);
//        g.setColor(Color.orange);
        int x1 = (int) ((r - 10) * Math.sin(rad * s));
        int y1 = (int) ((r - 10) * Math.cos(rad * s));
//        g.drawString(".", x + r, y + r);
//        g.drawLine(x + r, y + r, x + r + x1, y + r - y1);
//     
        // 分针
//        g.setColor(Color.BLUE);
//        x1 = (int) ((r - r / 2.5) * Math.sin(rad * m));
//        y1 = (int) ((r - r / 2.5) * Math.cos(rad * m));
//        g.drawLine(x + r, y + r, x + r + x1, y + r - y1);
//        // 时针
//        g.setColor(Color.CYAN);
//        x1 = (int) ((r - r / 1.5) * Math.sin(rad * h));
//        y1 = (int) ((r - r / 1.5) * Math.cos(rad * h));
//        g.drawLine(x + r, y + r, x + r + x1, y + r - y1);
        // 数字
        g.setColor(Color.darkGray);
        int d = 29;
//        for (int i = 1; i <= 12; i++) {
//            x1 = (int) ((r - 10) * Math.sin(rad * d));
//            y1 = (int) ((r - 10) * Math.cos(rad * d));
//            g.drawString(i + "", x + r + x1 - 4, x + r - y1 + 5);
//            d += 30;
//        }
        // 小点
        d = 0;
        Calendar c = Calendar.getInstance();
        int second=c.get(Calendar.SECOND);
        int d1=s;
        for (int i = 0; i < 60; i++) {
            x1 = (int) ((r - 2) * Math.sin(rad * d));
            y1 = (int) ((r - 2) * Math.cos(rad * d));
         g.setFont(new java.awt.Font("SAO UI", Font.BOLD,24));
            g.drawString(".", x + r + x1 - 1, x + r - y1 + 1);
            
            d += 6;
        }
        g.setColor(Color.white);
        g.setFont(new java.awt.Font("SAO UI", Font.BOLD,40));
       
		 hour=c.get(Calendar.HOUR_OF_DAY);
		 minute=c.get(Calendar.MINUTE);
		 
		 int hour1=(int)(hour/10);
		 int hour2=(int)(hour%10);
		 int minute1=(int)(minute/10);
		 int minute2=(int)(minute%10);
        g.drawString(hour1+""+hour2+":"+minute1+minute2, 46, 105);
        
        g.setFont(new java.awt.Font("SAO UI", Font.BOLD,24));
    	g.setColor(Color.cyan);
         //d1=second*6;
         x1 = (int) ((r - 2) * Math.sin(rad * d1));
         y1 = (int) ((r - 2) * Math.cos(rad * d1));
        g.drawString(".", x + r + x1 - 1, x + r - y1 + 1);
        
    }

    public void run() {
        while (true) {
            try {
            	
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            s += 6;
            if (s >= 360) {
                s = 0;
                m += 6;
                if (m == 72 || m == 144 || m == 216 || m == 288) {
                    h += 6;
                }
                if (m >= 360) {
                    m = 0;
                    h += 6;
                }
                if (h >= 360) {
                    h = 0;
                }
            }
            this.repaint();
        }
    }
}