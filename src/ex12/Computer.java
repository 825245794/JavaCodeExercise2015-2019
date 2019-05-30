package ex12;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Computer {
	
	public Computer()
	{
		JFrame a=new JFrame("Calculator");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(640, 120);
		Container b=a.getContentPane();
		b.setLayout(new FlowLayout());
		JLabel[] c=new JLabel[2];
		JTextField[] d=new JTextField[3];
		JButton e=new JButton();
		String[] s={"+","-","*","/"};
		JComboBox h=new JComboBox(s);
		d[0]=new JTextField("",8);
		d[1]=new JTextField("",8);
		d[2]=new JTextField("",16);
		c[0]=new JLabel("+");
		e=new JButton("=");	
		e.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			if(h.getSelectedIndex()==0)
				d[2].setText(""+(Double.parseDouble(d[0].getText())+Double.parseDouble(d[1].getText())));
			if(h.getSelectedIndex()==1)
				d[2].setText(""+(Double.parseDouble(d[0].getText())-Double.parseDouble(d[1].getText())));
			if(h.getSelectedIndex()==2)
				d[2].setText(""+(Double.parseDouble(d[0].getText())*Double.parseDouble(d[1].getText())));
			if(h.getSelectedIndex()==3)
				d[2].setText(""+(Double.parseDouble(d[0].getText())/Double.parseDouble(d[1].getText())));
		}
		});
		b.add(d[0]);
		b.add(h);
		b.add(d[1]);
		b.add(e);
		b.add(d[2]);
		a.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer a=new Computer();
	}

}
