package TEST;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testpoint {
	int x=0,y=0;
	public testpoint()
	{
		JFrame frame=new JFrame();
		Container c=frame.getContentPane();
		JPanel panel=new JPanel();
		c.add(panel);
		panel.setSize(480, 320);
		frame.setSize(480, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
		for(int x=0;x<480;x++){
			y++;
		}
		
	}
	
	

}
