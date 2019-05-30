package ww;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel implements ActionListener{

	private Color color;
	private int r = 30;
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	private JPanel panel;
	
	Image image = new ImageIcon("C:\\Users\\LJL\\Desktop\\1.png").getImage();  
	
	Timer t= new Timer(100,this);
	Timer t1= new Timer(1000,this);
	public void paint(Graphics g){

		g.drawImage(image, 0, 0,68, 84, panel);
		
		}
	public Ball(Color color, int r, int x, int y, int xSpeed, int ySpeed,
			JPanel panel) {
		super();
		this.color = color;
		this.r = r;
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.panel = panel;
		
		
		this.setBounds(x, y, r, r);
		t.start();
		
	}
	public void actionPerformed(ActionEvent e){
		x= getX() + xSpeed;
		y= getY() + ySpeed;
		
		if (x<0 ||(x + r)  > panel.getWidth() ){
			xSpeed = -xSpeed;
			if(x<0){
				x=0;
			}else{
				x= panel.getWidth() - r;
			}
		}
		if (y<0 || (y + r) > panel.getHeight()){
			ySpeed = -ySpeed;
			if(y<0){
				y=0;
			}else{
				y= panel.getHeight() - r;
			}
		}
		setLocation(x, y);
		int c=((int)(Math.random()*73000)+2);
		switch(c){
		case 10:panel.setBackground(new Color(188,148,24));break;
		case 20:panel.setBackground(new Color(155,36,42));break;
		case 30:panel.setBackground(new Color(150,127,215));break;
		case 40:panel.setBackground(new Color(22,79,182));break;
		case 50:panel.setBackground(new Color(99,156,167));break;
		}
		
	}
	
	

}
