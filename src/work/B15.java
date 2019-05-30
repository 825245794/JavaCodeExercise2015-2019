package work;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Document;


public class B15 implements MouseListener {
	JFrame frame=new JFrame("通讯录");
	JPanel panel=new JPanel();
	Point origin = new Point(); 
	JPanel panel_addition=new JPanel();
	DefaultListModel defaultListModel = new DefaultListModel();
	JTextField search=new JTextField("搜索");
	TextArea show=new TextArea();
	String name[];
	String code[];
	String place[];
	String number[];
	JList list=new JList();
	JScrollPane jsp;
	JScrollPane jslp = new JScrollPane(show); 
	 File filed;
	JTextField name_show=new JTextField();
	JTextField code_show=new JTextField();
	JTextField place_show=new JTextField();
	JTextField number_show=new JTextField();
	JLabel name_=new JLabel("姓名: ");
	JLabel username=new JLabel();
	JLabel code_=new JLabel("邮编: ");
	JLabel place_=new JLabel("住址: ");
	JLabel number_=new JLabel("号码: ");
	JButton changeuser=new JButton("注销");
	JButton add=new JButton("增加");
	JButton edit=new JButton("编辑");
	JButton delete=new JButton("删除");
	JButton changeword=new JButton("修改密码");
	JButton exit=new JButton("退出");
	String filename;
	String userpassword;
	JLabel usernum=new JLabel();
	boolean flag=false;
	public B15(){
		Listener();
		login();
	}
	
	public void start(){
		file();
		GUI();
		
	}
 	public void GUI(){
 		
 		jsp = new JScrollPane(list);
 		jsp.updateUI();
		frame.setLayout(null);
		frame.setSize(960, 560);
		frame.setResizable(true);
		panel.setLayout(null);
		panel_addition.setLayout(null);
		panel.setBounds(0, 0, (int)(frame.getWidth()*0.4),frame.getHeight());
		panel_addition.setBounds((int)(frame.getWidth()*0.4), 0, (int)(frame.getWidth()*0.6), frame.getHeight());
		frame.setUndecorated(true);
		
		int windowWidth = frame.getWidth();
		 int windowHeight = frame.getHeight(); 
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidth = screenSize.width; 
		 int screenHeight = screenSize.height;
		 frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		
		//Show
		jslp.setVisible(false);
		jslp.setBounds(7,50, (int)(frame.getWidth()*0.392),60);
		jslp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	    jslp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
		//Search
		search.setBounds(0,0, (int)(frame.getWidth()*0.4),35);
		search.setForeground(Color.gray);
		
		//List
		list.setFont(new Font("黑体",java.awt.Font.PLAIN,15));
		list.setFixedCellHeight(35);
		jsp.setBounds(0, 35,(int)(frame.getWidth()*0.4),frame.getHeight()-63);
	    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	    //info
	    changeuser.setFont(new Font("黑体",java.awt.Font.PLAIN,12));
	    changeuser.setForeground(Color.red);
	    changeuser.setBounds(30, 320, 60, 25);
	    
	    exit.setFont(new Font("黑体",java.awt.Font.PLAIN,12));
	    exit.setForeground(Color.red);
	    exit.setBounds(100, 320, 60, 25);
	    exit.setBackground(null);
	    
	    usernum.setFont(new Font("黑体",java.awt.Font.PLAIN,13));
	    usernum.setBounds(30, 368,200, 20);
	    usernum.setText("当前联系人"+name.length+"个");
	    
	    username.setFont(new Font("黑体",java.awt.Font.PLAIN,13));
	    username.setBounds(30, 298,200, 20);
	    username.setText("当前登陆用户： "+filename);
	    
	    name_.setFont(new Font("黑体",java.awt.Font.PLAIN,15));
	    name_.setBounds(30, 45,50, 20);
	    name_show.setBounds(80, 46,350, 20);
	    name_show.setEditable(false);
	    name_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
	    
	    
	    code_.setFont(new Font("黑体",java.awt.Font.PLAIN,15));
	    code_.setBounds(30, 100,50, 20);
	    code_show.setBounds(80, 102,350, 20);
	    code_show.setEditable(false);
	    code_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
	    
	    place_.setFont(new Font("黑体",java.awt.Font.PLAIN,15));
	    place_.setBounds(30, 155,70, 20);
	    place_show.setBounds(80, 156,350, 20);
	    place_show.setEditable(false);
	    place_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
	    
	    number_.setFont(new Font("黑体",java.awt.Font.PLAIN,15));
	    number_.setBounds(30, 210,70, 20);
	    number_show.setBounds(80,211,350, 20);
	    number_show.setEditable(false);
	    number_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
	    
	    
	    add.setFont(new Font("黑体",java.awt.Font.PLAIN,13));
	    add.setForeground(Color.blue);
	    add.setBounds(30, 295, 80, 25);
	    add.setBounds(310, 295, 80, 25);
	     
	   
	    edit.setFont(new Font("黑体",java.awt.Font.PLAIN,13));
	    edit.setForeground(Color.blue);
	    edit.setBounds(450, 295, 80, 25);
	    edit.setEnabled(false);
	    
	    delete.setFont(new Font("黑体",java.awt.Font.PLAIN,13));
	    delete.setForeground(Color.blue);
	    delete.setBounds(310, 355, 80, 25);
	    delete.setEnabled(false);
	    
	    changeword.setFont(new Font("黑体",java.awt.Font.PLAIN,10));
	    changeword.setForeground(Color.blue);
	    changeword.setBounds(450, 355, 80, 25);
	    //add
		frame.add(panel);
		frame.add(panel_addition);
		panel.add(jslp);
		panel.add(jsp);
		panel.add(search);
		panel_addition.add(name_show);
		panel_addition.add(code_show);
		panel_addition.add(place_show);
		panel_addition.add(number_show);
		panel_addition.add(name_);
		panel_addition.add(code_);
		panel_addition.add(place_);
		panel_addition.add(number_);
	    panel_addition.add(add);
	    panel_addition.add(edit);
	    panel_addition.add(delete);
	    panel_addition.add(changeword);
	    panel_addition.add(username);
	    panel_addition.add(changeuser);
	    panel_addition.add(usernum);
	    panel_addition.add(exit);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}
 	private void addMouseMotionListener(MouseMotionAdapter mouseMotionAdapter) {
		// TODO Auto-generated method stub
		
	}

	private void addMouseListener(MouseAdapter mouseAdapter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		search.setText("");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void Listener(){
		search.getDocument().addDocumentListener(new  DocumentListener(){
			
			@Override
			
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				defaultListModel.removeAllElements();
				int j=0;
				if(search.getText()==null){
					search.setText("搜索");
					for(int i=0;i<name.length;i++){
							defaultListModel.add(j, name[i]);
							j++;
					}
				}
				else{for(int i=0;i<name.length;i++){
					if(name[i].indexOf(search.getText())!=-1){
						defaultListModel.add(j, name[i]);
						j++;
					}
				}
				}
				list.setModel(defaultListModel);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				defaultListModel.removeAllElements();
				int j=0;
					for(int i=0;i<name.length;i++){
					if(name[i].indexOf(search.getText())!=-1){
						defaultListModel.add(j, name[i]);
						j++;
					}
				}
				
				list.setModel(defaultListModel);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				defaultListModel.removeAllElements();
				int j=0;
				if(search.getText()==""){
					search.setText("搜索");
					for(int i=0;i<name.length;i++){
						defaultListModel.add(j, name[i]);
						j++;
					}
				}
				else{for(int i=0;i<name.length;i++){
					if(name[i].indexOf(search.getText())!=-1){
						defaultListModel.add(j, name[i]);
						j++;
					}
				}
				}
				list.setModel(defaultListModel);
			}
			
			

		});
		
		search.addMouseListener(this);
		
		

	
		
		edit.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			if(edit.getText().equals("编辑")){
				 edit.setText("完成");
				 name_show.setEditable(true);
				 name_show.setBorder(new MatteBorder(1,1,1,1,Color.blue));
				 code_show.setEditable(true);
				 code_show.setBorder(new MatteBorder(1,1,1,1,Color.blue));
				 place_show.setEditable(true);
				 place_show.setBorder(new MatteBorder(1,1,1,1,Color.blue));
				 number_show.setEditable(true);
				 number_show.setBorder(new MatteBorder(1,1,1,1,Color.blue));
				
			}
			else if(edit.getText().equals("完成")){
				if(name_show.getText().equals("")){
					JOptionPane.showMessageDialog(null, "输入姓名");
					name_show.setBorder(new MatteBorder(1,1,1,1,Color.red));
					}
				else{
				edit.setText("编辑");
				 System.gc();
				 deleteDir("c:\\resource"+"\\"+filename+"\\"+name[list.getSelectedIndex()]);
				 name_show.setEditable(false);
				 name_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
				 code_show.setEditable(false);
				 code_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
				 place_show.setEditable(false);
				 place_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
				 number_show.setEditable(false);
				 number_show.setBorder(new MatteBorder(0,0,0,0,Color.black));
				 
				 try {
						File file = new File("c:\\resource"+"\\"+filename+"\\"+name_show.getText());
						file.mkdir();
						FileOutputStream o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_show.getText()+"\\"+"code.txt");
						o.write(code_show.getText().getBytes());
						o.flush();
						o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_show.getText()+"\\"+"number.txt");
						o.write(number_show.getText().getBytes());
						o.flush();
						o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_show.getText()+"\\"+"place.txt");
						o.write(place_show.getText().getBytes());
						o.flush();
						o.close();
						defaultListModel.removeAllElements();
						file();
					
						}
					catch(Exception y){}
			}		
		}}
		});
		
		changeword.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			changepassword();
		}
		});
		
		exit.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		});
		
		changeuser.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			frame.dispose();
			new B15();
		}
		});
		
		add.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			addcontactGUI();
			 panel_addition.repaint();
		}
		});
		
		list.addListSelectionListener(new ListSelectionListener()
		{
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			try{
				delete.setEnabled(true);
				edit.setEnabled(true);
			place_show.setText(place[list.getSelectedIndex()]);
			name_show.setText(name[list.getSelectedIndex()]);
			code_show.setText(code[list.getSelectedIndex()]);
			number_show.setText(number[list.getSelectedIndex()]);}catch(Exception w){}
		}
		});
		
		
		delete.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			System.gc();
			deleteDir("c:\\resource"+"\\"+filename+"\\"+name[list.getSelectedIndex()]);
			defaultListModel.removeAllElements();
			  file();
			  panel_addition.repaint();
		}
		});
	}
	public void clear(){
		for(int i=0;i<name.length;i++){
		name[i]=null;
		place[i]=null;
		code[i]=null;
		number[i]=null;}
	}
	
	public void deleteDir(String a){
		System.gc();
		File dir=new File(a);
		  if(dir.isDirectory()){
		   File[] files = dir.listFiles();
		   for(int i=0; i<files.length; i++) {
		    deleteDir(String.valueOf(files[i]));
		   }
		  }
		  if(!dir.delete()){
			  JOptionPane.showMessageDialog(null, "失败！再试一次！");
		  }
		 
		
		 }
	public void addcontactGUI(){
		final JFrame frame_addition=new JFrame("新增联系人");
		JPanel panel_addtion=new JPanel();
		frame_addition.setLayout(null);
		frame_addition.setSize(480, 320);
		panel_addtion.setBackground(Color.white);
		
		panel_addtion.setLayout(null);
		panel_addtion.setSize(480, 320);
		JButton addbutton=new JButton("确定");
		
		final JTextField name_showadd=new JTextField();
		final JTextField code_showadd=new JTextField();
		final JTextField place_showadd=new JTextField();
		final JTextField number_showadd=new JTextField();
		JLabel name_add=new JLabel("姓名: ");
		JLabel code_add=new JLabel("邮编: ");
		JLabel place_add=new JLabel("住址: ");
		JLabel number_add=new JLabel("号码: ");
		
		name_add.setBounds(10, 10, 50, 20);
		name_showadd.setBounds(60, 10, 320, 20);
		name_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		code_add.setBounds(10, 70, 50, 20);
		code_showadd.setBounds(60, 70, 320, 20);
		code_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		place_add.setBounds(10, 130, 50, 20);
		place_showadd.setBounds(60, 130, 320, 20);
		place_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		number_add.setBounds(10, 190, 60, 20);
		number_showadd.setBounds(60, 190, 320, 20);
		number_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		addbutton.setBounds(180, 230, 80, 30);
		addbutton.setBackground(Color.white);
		
		frame_addition.add(panel_addtion);
		panel_addtion.add(addbutton);
		panel_addtion.add(name_showadd);
		panel_addtion.add(code_showadd);
		panel_addtion.add(place_showadd);
		panel_addtion.add(number_showadd);
		panel_addtion.add(name_add);
		panel_addtion.add(code_add);
		panel_addtion.add(place_add);
		panel_addtion.add(number_add);
		frame_addition.dispose();
		frame_addition.setVisible(true);
		
		addbutton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			if(name_showadd.getText().equals("")){
				JOptionPane.showMessageDialog(null, "输入姓名");
				}
			else{
			try {
				
				File file = new File("c:\\resource"+"\\"+filename+"\\"+name_showadd.getText());
				if(file.exists()){
				JOptionPane.showMessageDialog(null, "联系人已存在");
				}
				else{
				file.mkdirs();
				FileOutputStream o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_showadd.getText()+"\\"+"code.txt");
				o.write(code_showadd.getText().getBytes());
				o.flush();
				o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_showadd.getText()+"\\"+"number.txt");
				o.write(number_showadd.getText().getBytes());
				o.flush();
				o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\"+name_showadd.getText()+"\\"+"place.txt");
				o.write(place_showadd.getText().getBytes());
				o.flush();
				JOptionPane.showMessageDialog(null, "创建完成");
				o.close();
				defaultListModel.removeAllElements();
				file();
			
				frame_addition.dispose();
				}}
			catch(Exception y){}
		}}});
	}
	
	public void login(){
		final JFrame frame_addition=new JFrame("用户登录");
		JLabel title =new JLabel("通讯录登陆");
		JPanel panel_addtion=new JPanel();
		frame_addition.setLayout(null);
		frame_addition.setSize(320, 240);
		frame_addition.setResizable(false);
		panel_addtion.setBackground(Color.white);
		frame_addition.setUndecorated(true);
		
		int windowWidth = frame_addition.getWidth();
		 int windowHeight = frame_addition.getHeight(); 
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidth = screenSize.width; 
		 int screenHeight = screenSize.height;
		 frame_addition.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		panel_addtion.setLayout(null);
		panel_addtion.setSize(320, 240);
		JButton addbutton=new JButton("确定");
		JButton register=new JButton("注册");
		
		final JTextField name_showadd=new JTextField();
		final JPasswordField code_showadd=new JPasswordField();
		JTextField place_showadd=new JTextField();
		JPasswordField number_showadd=new JPasswordField();
		JLabel name_add=new JLabel("用户名: ");
		JLabel code_add=new JLabel("密码: ");
		
		title.setBounds(100, 20, 120, 30);
		title.setBackground(Color.white);
		title.setFont(new Font("黑体",java.awt.Font.PLAIN,20));
	    
		
		name_add.setBounds(10, 50, 80, 20);
		name_showadd.setBounds(90, 50, 140, 20);
		name_showadd.requestFocus();
		
		
		code_add.setBounds(10, 110, 80, 20);
		code_showadd.setBounds(90, 110, 140, 20);
		
	
		
		addbutton.setBounds(30, 140, 80, 30);
		addbutton.setBackground(Color.white);
		
		register.setBounds(140, 140, 80, 30);
		register.setBackground(Color.white);
		
		exit.setBounds(240, 200, 60, 30);
		exit.setBackground(Color.white);
		exit.setFont(new Font("黑体",java.awt.Font.PLAIN,12));
	    exit.setForeground(Color.red);
		
		frame_addition.add(panel_addtion);
		panel_addtion.add(addbutton);
		panel_addtion.add(name_showadd);
		panel_addtion.add(code_showadd);
		panel_addtion.add(name_add);
		panel_addtion.add(code_add);
		panel_addtion.add(register);
		panel_addtion.add(title);
		panel_addtion.add(exit);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_addition.setVisible(true);
		
		addbutton.addActionListener(new ActionListener()
		{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
		try {
			FileInputStream r=new FileInputStream("c:\\resource"+"\\"+name_showadd.getText()+"\\password.txt");
			String password="";
			for(int j=r.read();j!=-1;j=r.read())
			{
				password+=(char)j;
			}
			if(password.equals(code_showadd.getText())){
				filename=name_showadd.getText();
				System.out.println("succeed");
				userpassword=password;
				frame_addition.dispose();
				
				start();
			}
			else{
			JOptionPane.showMessageDialog(null, "密码错误");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "用户名不存在");
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "读写错误");
				e.printStackTrace();
			}
		}
		});
		

		register.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			registerGUI();
		}});
	}
	
	
	@SuppressWarnings("resource")
	public void file(){
		File file = new File("c:\\resource"+"\\"+filename);
		 File[] files =file.listFiles();
		  name=new String[files.length-1];
		  code=new String[files.length-1];
		  place=new String[files.length-1];
		  number=new String[files.length-1];
		  BufferedReader bre = null;
		  InputStreamReader read = null;
		  FileInputStream r = null;
		  int k=0;
		  try {
		  for(int i=0;i<files.length;i++){
			  String a=String.valueOf(files[i]);
			 
				 if(a.indexOf(".txt")!=-1||a==null){
					 continue;
				 }
				 
				    String b="";
				    String path=a+"\\"+"place.txt";
					 File f = new File(path);
					 bre = null;
					 if(!f.exists()){ f.createNewFile();}
					 read = new InputStreamReader(new FileInputStream(path), "GBK");
					for(int j=read.read();j!=-1;j=read.read())
					{
						b+=(char)j;
					}
					place[k]=b;
					 
				    b="";
				    f = new File(a+"\\"+"number.txt");
				    bre = null;
				    if(!f.exists()){ f.createNewFile();}
					r = new FileInputStream(a+"\\"+"number.txt");
					bre = new BufferedReader(new FileReader(a+"\\"+"number.txt"));
					while ((b = bre.readLine())!= null) 
					{
					number[k]=b;
					}
				    
					 b="";
					 bre = null;
					 f = new File(a+"\\"+"code.txt");
						 if(!f.exists()){ f.createNewFile();}
						 r = new FileInputStream(a+"\\"+"code.txt");
							 file.createNewFile();
						bre = new BufferedReader(new FileReader(a+"\\"+"code.txt"));
						while ((b = bre.readLine())!= null) 
						{
						code[k]=b;
						}
						
					k++;
					 
		  }}catch (Exception e) {
					file();
				}
		  k=0;
		 for(int i=0;i<files.length;i++){
			 String a=String.valueOf(files[i]);
			 if(a.indexOf(".txt")!=-1){
				 continue;
			 }
			 else{
				 name[k]=a;
				 for(int j=name[k].length();j>-1;j--){
					 String b=String.valueOf(name[k].charAt(j-1));
					 if(b.equals("\\")){
						 name[k]=name[k].substring(j);
						 k++;
						 break;
					 }
				 }
			 }
		 }try{
		 bre.close();
			r.close();
			read.close();}catch(Exception e){}
		 for(int i=0;i<name.length;i++){
		 defaultListModel.add(i,name[i]);
		 }
		 list.setModel(defaultListModel);
	}
	public void registerGUI(){
		final JFrame frame_addition=new JFrame("用户注册");
		JPanel panel_addtion=new JPanel();
		frame_addition.setLayout(null);
		frame_addition.setSize(320, 240);
		panel_addtion.setBackground(Color.white);
		frame_addition.setResizable(false);
		panel_addtion.setLayout(null);
		panel_addtion.setSize(320, 240);
		JButton addbutton=new JButton("确定");
	
		
		final JTextField name_showadd=new JTextField();
		final JTextField code_showadd=new JTextField();
		final JTextField code_showadd2=new JTextField();
		JTextField place_showadd=new JTextField();
		JTextField number_showadd=new JTextField();
		JLabel name_add=new JLabel("用户名: ");
		JLabel code_add=new JLabel("密码: ");
		JLabel code_add2=new JLabel("确认密码: ");
		name_add.setBounds(10, 10, 80, 20);
		name_showadd.setBounds(90, 10, 140, 20);
		//name_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		code_add.setBounds(10, 60, 80, 20);
		code_showadd.setBounds(90, 60, 140, 20);
		//code_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
	
		code_add2.setBounds(10, 110, 80, 20);
		code_showadd2.setBounds(90,110, 140, 20);
		
		addbutton.setBounds(100, 150, 80, 30);
		addbutton.setBackground(Color.white);
		
		frame_addition.add(panel_addtion);
		panel_addtion.add(addbutton);
		panel_addtion.add(name_showadd);
		panel_addtion.add(code_showadd);
		panel_addtion.add(name_add);
		panel_addtion.add(code_add);
		panel_addtion.add(name_add);
		panel_addtion.add(code_add2);
		panel_addtion.add(code_showadd2);
		frame_addition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame_addition.setVisible(true);
		
		addbutton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			
			if(!code_showadd2.getText().equals(code_showadd.getText())){
				JOptionPane.showMessageDialog(null, "两次密码不相同");
				}
			else{
			try {
			
				File file = new File("c:\\resource"+"\\"+name_showadd.getText());
				if(file.exists()){
				JOptionPane.showMessageDialog(null, "用户已存在");
				}
				else{
				file.mkdirs();
				FileOutputStream o=new FileOutputStream("c:\\resource"+"\\"+name_showadd.getText()+"\\password.txt");
				o.write(code_showadd2.getText().getBytes());
				o.flush();
				JOptionPane.showMessageDialog(null, "创建完成");
				frame_addition.dispose();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				File file = new File("c:\\resource"+"\\"+name_showadd.getText());
				if(file.exists()){
				JOptionPane.showMessageDialog(null, "用户已存在");
				}
				else{
				file.mkdirs();}
				
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
		}
		});
	}
	
	public void changepassword(){
		final JFrame frame_addition=new JFrame("修改密码");
		JPanel panel_addtion=new JPanel();
		frame_addition.setLayout(null);
		frame_addition.setSize(320, 240);
		frame_addition.setResizable(false);
		panel_addtion.setBackground(Color.white);
		panel_addtion.setLayout(null);
		panel_addtion.setSize(320, 240);
		JButton addbutton=new JButton("确定");
		
		
		final JTextField oldpassword=new JTextField();
		final JTextField newpassword2=new JTextField();
		final JTextField newpassword=new JTextField();

		JLabel oldpassword_name=new JLabel("旧密码: ");
		JLabel newpassword_name=new JLabel("新密码: ");
		JLabel newpassword_name2=new JLabel("确认新密码: ");
		
		oldpassword_name.setBounds(10, 10, 80, 20);
		oldpassword.setBounds(90, 10, 140, 20);
		//oldpassword.setBorder(new MatteBorder(0,0,1,0,Color.black));
		
		newpassword_name.setBounds(10, 70, 80, 20);
		newpassword.setBounds(90, 70, 140, 20);
		//code_showadd.setBorder(new MatteBorder(0,0,1,0,Color.black));
	
		newpassword_name2.setBounds(10, 110, 80, 20);
		newpassword2.setBounds(90, 110, 140, 20);
		
		addbutton.setBounds(80, 150, 80, 30);
		addbutton.setBackground(Color.white);
		
		
		frame_addition.add(panel_addtion);
		panel_addtion.add(addbutton);
		panel_addtion.add(oldpassword);
		panel_addtion.add(newpassword2);
		panel_addtion.add(newpassword);
		panel_addtion.add(oldpassword_name);
		panel_addtion.add(newpassword_name);
		panel_addtion.add(newpassword_name2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_addition.setVisible(true);
		
		addbutton.addActionListener(new ActionListener()
		{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
		try {
			if(!userpassword.equals(oldpassword.getText())){
				JOptionPane.showMessageDialog(null, "旧密码错误");
				frame_addition.dispose();
			}
			else{
			if(newpassword.getText().equals(newpassword2.getText())){
			FileOutputStream o=new FileOutputStream("c:\\resource"+"\\"+filename+"\\password.txt");
			o.write(newpassword2.getText().getBytes());
			o.flush();
			o.close();
			frame_addition.dispose();
			JOptionPane.showMessageDialog(null, "修改成功");}
			else{JOptionPane.showMessageDialog(null, "两次密码不一样");}}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "用户名不存在");
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "读写错误");
				e.printStackTrace();
			}
		}
		});}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B15 a=new B15();
	}

}
//"c:\\resource"+"\\"+name_showadd.getText()+"\\password.txt"