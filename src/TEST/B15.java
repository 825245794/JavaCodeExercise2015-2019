package TEST;

import java.awt.Frame;

import javax.swing.JPanel;

public class B15 {
	Frame frame=new Frame();
	JPanel panel=new JPanel();
	public B15(){
		
	}
	void GUI(){
		frame.setSize(640, 320);
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B15 a=new B15();
	}

}
