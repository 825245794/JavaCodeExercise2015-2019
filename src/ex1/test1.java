package ex1;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test1 extends JFrame{
	JTextField comp[]={new JTextField("C o n g r a t u l a t i o n s"),
			           new JTextField("期望数值"),new JTextField(),
			           new JTextField("总人次"),new JTextField(),
			           new JTextField("时间"),new JTextField(),
			           new JTextField("起始时间"),new JTextField("终止时间"),
			           new JTextField(),new JTextField(),
			           };
	
	public test1(){
		JFrame app=new JFrame("congratulations");
		Container c=app.getContentPane();
		GridBagLayout gbl=new GridBagLayout();
		app.setBackground(Color.BLACK);
		c.setLayout(null);
		JPanel JP=new JPanel();
		JP.setLayout(null);
		JP.setBackground(Color.BLACK);
		int []gx={0,  0, 200, 0,200, 0,200, 0,200, 0,200,  0,  200,   0};
		int []gy={0,  80, 80, 160,160, 240,240, 320,320, 400,400,  6,  7,  10};
		int []gw={400,200,200, 200,200, 200,200, 200,200, 200,200, 10, 10,  10};
		int []gh={50, 50,50,   50,50, 50,50, 50,50, 50,50, 50,  50,   6};
		
		GridBagConstraints gc=new GridBagConstraints();
		for(int i=0;i<comp.length;i++){
			//gc.gridx=gx[i];
			//gc.gridy=gy[i];
			//gc.gridwidth=gw[i];
			//gc.gridheight=gh[i];
			//gc.fill=GridBagConstraints.BOTH;
			
			//gbl.setConstraints(comp[i], gc);
			comp[i].setBounds(gx[i], gy[i], gw[i], gh[i]);
			JP.add(comp[i]);
		}
		
		c.add(JP);
		app.setSize(550,600);
		c.setSize(550, 600);
		app.setLocation(500,200);
		JP.setBounds(0, 0, app.getWidth(), app.getHeight());
		JP.setSize(app.getWidth(), app.getHeight());
		app.setVisible(true);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args)
	{
		new test1();
		
	}

}