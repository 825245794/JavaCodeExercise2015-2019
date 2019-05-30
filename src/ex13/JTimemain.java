package ex13;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JTimemain {
	JFrame a=new JFrame();
	Container b=a.getContentPane();
	JPanel j=new JPanel();
	JLabel[] d={new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
	public JTimemain()
	{
		a.setSize(480,240);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d[8].setBounds(100, 50, 30,50);
		d[0].setBounds(115, 50, 30,50);
		d[1].setBounds(130, 50, 30,50);
		d[2].setBounds(145, 50, 30,50);
		d[3].setBounds(160, 50, 30,50);
		d[4].setBounds(175, 50, 30,50);
		d[5].setBounds(190, 50, 30,50);
		d[6].setBounds(205, 50, 30,50);
		d[7].setBounds(210, 50, 30,50);
		d[9].setBounds(225, 50, 30,50);
		a.add(j);
		for(int i=0;i<d.length;i++)
		{
			d[i].setFont(new java.awt.Font("Dialog",0,30));
			j.add(d[i]);
		}
		a.setVisible(true);
	}
}
