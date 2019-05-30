package Contra;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Contra {
	public Contra()
	{
		JFrame frame=new JFrame();
		Container contain=frame.getContentPane();
		JPanel panel[]={new JPanel(),new JPanel()};
		frame.setSize(800,600);
		panel[0].setSize(800,600);
		panel[0].setOpaque(true);
		panel[0].setBackground(Color.black);
		String path=System.getProperty("user.dir")+"/src/Contra/A.png";
		System.out.print(System.getProperty("user.dir")+"/src/Contra/A.png");
		ImageIcon background = new ImageIcon(path);
		Image image=background.getImage().getScaledInstance(panel[0].getWidth(),panel[0].getHeight(),background.getImage().SCALE_DEFAULT);  
		background=new ImageIcon(image);
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, 800, 600);
		panel[0].add(label);
		frame.add(panel[0]);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contra a=new Contra();
	}

}
