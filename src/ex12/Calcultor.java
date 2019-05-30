package ex12;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calcultor {
	public Calcultor()
	{
		JFrame a=new JFrame("Calculator");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(320, 240);
		Container b=a.getContentPane();//
		b.setLayout(new FlowLayout());//
		JTextField d=new JTextField("0",8);
		b.add(d);
		JPanel d1=new JPanel();//
		d1.setLayout(new GridLayout(4,16));
		JButton[] c=new JButton[16];
		b.add(d1);
     	c[0]=new JButton("7");
		c[1]=new JButton("8");		
		c[2]=new JButton("9");
		c[3]=new JButton("+");	
		c[4]=new JButton("4");
		c[5]=new JButton("5");	
		c[6]=new JButton("6");
		c[7]=new JButton("-");	
		c[8]=new JButton("1");
		c[9]=new JButton("2");
		c[10]=new JButton("3");
		c[11]=new JButton("*");	
		c[12]=new JButton("0");	
		c[13]=new JButton(".");
		c[14]=new JButton("=");	
		c[15]=new JButton("/");
		for(int i=0;i<16;i++)
		{
			d1.add(c[i]);
		}
		JPanel d2=new JPanel(new GridLayout(1,1));//
		d2.setLayout(new FlowLayout());//
		JButton d3=new JButton("CE/C");
		b.add(d2);
		d2.add(d3);
		a.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calcultor a=new Calcultor();
	}

}
