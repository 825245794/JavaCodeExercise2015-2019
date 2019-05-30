package ex1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class 学生信息管理系统2 extends JFrame implements ActionListener{
	JButton dl;
	JButton zc;
	JFrame zcjm=new JFrame();
	JFrame dljm=new JFrame();
	public 学生信息管理系统2(){
		super();
		
		//getContentPane().setBackground(Color.cyan);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bt=new JLabel("学生信息管理系统");
		bt.setFont(new Font("黑体",Font.BOLD,18));
		bt.setBounds(100, 20, 200, 20);
		
		JLabel yhm=new JLabel("用户名　:");
		yhm.setBounds(100, 70, 60, 20);
		
		JTextField txt1=new JTextField();
		txt1.setBounds(160, 70, 100, 20);
		
		JLabel mm=new JLabel("密　码　:");
		mm.setBounds(100, 120, 60, 20);
		
		JPasswordField txt2=new JPasswordField();
		txt2.setBounds(160, 120, 100, 20);
		
		
		JLabel yhlx=new JLabel("用户类型:");
		yhlx.setBounds(100, 170, 60, 20);
		
		JComboBox cd=new JComboBox();
		cd.setModel(new DefaultComboBoxModel(new String[]{"---学生---","---老师---"}));
		cd.setBounds(160, 170, 100, 20);
		
		dl=new JButton("登录");
		dl.setBounds(100, 220, 60, 30);
		dl.setBackground(Color.ORANGE);
		dl.addActionListener(this);
			
		zc=new JButton("注册");
		zc.setBounds(200, 220, 60, 30);
		zc.setBackground(Color.ORANGE);
		zc.addActionListener(this);
		
		getContentPane().add(bt);
		getContentPane().add(yhm);
		getContentPane().add(txt1);
		getContentPane().add(mm);
		getContentPane().add(txt2);
		getContentPane().add(yhlx);
		getContentPane().add(cd);
		getContentPane().add(dl);
		getContentPane().add(zc);
		setSize(380,400);
		getContentPane().setLayout(null);
		
		String path=System.getProperty("user.dir")+"/img/AR.jpg";
		ImageIcon background = new ImageIcon(path);
		Image image=background.getImage().getScaledInstance(getWidth(),getHeight(),background.getImage().SCALE_DEFAULT);  
		background=new ImageIcon(image);
		
		JLabel label = new JLabel(background);
		
		label.setBounds(0, 0, getWidth(), this.getHeight());
		add(label);
		
		setLocation(500,200);
		setTitle("学生管理系统");
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		学生信息管理系统2 a=new 学生信息管理系统2();
	}

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==dl){
				dljm.setSize(380,400);
				dljm.setLocation(500,200);
				JPanel jm1=new JPanel();
				dljm.setTitle("登录");
				
				JLabel xx=new JLabel("请链接网路再重试！！");			
				xx.setFont(new Font("黑体",Font.BOLD,18));
				xx.setBounds(200, 100, 60, 20);
				
				dljm.add(jm1);
				jm1.add(xx);
				dljm.setVisible(true);
			}
			
			
			if(e.getSource()==zc){
				zcjm.setSize(380,400);
				zcjm.setLocation(500,200);
				JPanel JP=new JPanel(new GridLayout(8,1));
				JPanel JP1=new JPanel();
				JPanel JP2=new JPanel();
				JPanel JP3=new JPanel();
				JPanel JP4=new JPanel();
				JPanel JP5=new JPanel();
				JPanel JP6=new JPanel();
				JPanel JP7=new JPanel();
				
				JP.add(JP1);
				JP.add(JP2);
				JP.add(JP3);
				JP.add(JP4);
				JP.add(JP5);
				JP.add(JP6);
				JP.add(JP7);
				
				zcjm.setTitle("用户注册");
				zcjm.setVisible(true);
				
				
				JLabel xszc=new JLabel("学生注册");
				xszc.setFont(new Font("黑体",Font.BOLD,18));
				
				JLabel xh=new JLabel("学　　号：");
				JTextField txt1=new JTextField(10);
				JLabel xm=new JLabel("姓　　名：");
				JTextField txt2=new JTextField(10);
				JLabel nl=new JLabel("年　　龄：");
				JTextField txt3=new JTextField(10);
				JLabel mm1=new JLabel("密　　码：");
				JPasswordField txt4=new JPasswordField(10);
				JLabel qrmm=new JLabel("确认密码：");	
				JPasswordField txt5=new JPasswordField(10);
				
				JLabel xb=new JLabel("性别：");
				ButtonGroup dx=new ButtonGroup();
				JRadioButton nan=new JRadioButton("男");
				JRadioButton nv=new JRadioButton("女");
				dx.add(nan);
				dx.add(nv);			
				
				zcjm.add(JP);
				JP1.add(xszc);
				JP2.add(xh);   JP2.add(txt1);
				JP3.add(xm);   JP3.add(txt2);
				JP4.add(nl);   JP4.add(txt3);
				JP5.add(mm1);   JP5.add(txt4);
				JP6.add(qrmm);   JP6.add(txt5);
				JP7.add(xb);
				JP7.add(nan);
				JP7.add(nv);
				
				
				
			}
			
		}
	

}