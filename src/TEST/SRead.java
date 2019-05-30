package TEST;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class SRead {
	String forntsix[]=new String[3465];
	String area[]=new String[3465];
	String input;
	int i;
	private int Year;
	static int are;
	private int identify=0;
	String path="/Volumes/LJL/1.txt";
	String path2="/Volumes/LJL/loggl.ini";
	String save1="/Volumes/LJL/savve.ini";
	public void save()
	{
		try {
			
			FileReader r=new FileReader(save1);
			path="";
			for(int j=r.read();j!=-1;j=r.read())
			{	
				path+=(char)j;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void idetify()
	{
		try {
			FileInputStream r=new FileInputStream(path2);
			for(int j=r.read();j!=-1;j=r.read())
			{
				identify=(char)j;
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SRead(int Year)
	{
		idetify();
		save();
		Readfile();
		this.Year=Year;
		JFrame jf=new JFrame("身份证生成器");
		jf.setSize(800, 650);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c1=jf.getContentPane();
		c1.setLayout(null);
		JPanel JS1=new JPanel();
		JS1.setLayout(null);
		JS1.setBounds(1, 1, 400, 600);
		c1.add(JS1);
		JTextArea jt=new JTextArea();
		JScrollPane JS=new JScrollPane(jt);
		jt.setEditable(false);
		jt.setLineWrap(true);
		jt.setAutoscrolls(true);
		jt.setBounds(1, 1, 400, 600);
		JS.setBounds(1, 1, 400, 600);
		JS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		JS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		//JS1.add(jt);
		JS1.add(JS);
		
		JPanel JS2=new JPanel();
		JS2.setLayout(null);
		JS2.setBounds(400, 1, 400, 600);
		//JS2.setBackground(Color.YELLOW);//
		c1.add(JS2);
		JRadioButton[] jr={new JRadioButton("按地区选择"),new JRadioButton("按号码选择")};
		ButtonGroup rg=new ButtonGroup();
		jr[0].setSelected(true);
		rg.add(jr[0]);
		rg.add(jr[1]);
		final JComboBox[] jc1 ={ new JComboBox(area),new JComboBox(forntsix)};
		JLabel jl=new JLabel();
		JLabel[] tip={new JLabel("地区"),new JLabel("性别"),new JLabel("出生年月"),new JLabel("合法信息")};
		
		jr[0].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub	
				jc1[0].setBounds(30, 100, 350, 40);
				jc1[0].setVisible(true);
				jc1[1].setVisible(false);
				jl.setText("地区号码："+forntsix[jc1[0].getSelectedIndex()]);
			}});

		jr[1].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub	
				jc1[1].setBounds(30, 100, 350, 40);
				jc1[0].setVisible(false);
				jc1[1].setVisible(true);
				jl.setText("地区："+area[jc1[1].getSelectedIndex()]);
			}});
		
		jc1[0].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub	
				jl.setText("地区号码："+forntsix[jc1[0].getSelectedIndex()]);
			}});

		jc1[1].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent g) {
				// TODO Auto-generated method stub	
				jl.setText("地区："+area[jc1[1].getSelectedIndex()]);
			}});
	    String []sjc2={"全部","男","女"};
		JComboBox jc2 =new JComboBox(sjc2);
		String[] year=new String[100];
		String[] month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String[] day=new String[31];
		String[] info={"全部","仅显示合法"};
		for(int i=0;i<100;i++)
			year[i]=""+(i+1960);
		for(int i=0;i<31;i++)
		{	if(i<9)
			day[i]="0"+(i+1);
			else
	     	day[i]=""+(i+1);
		}
		JComboBox cyear =new JComboBox(year);
		JComboBox cmonth =new JComboBox(month);
		JComboBox cday =new JComboBox(day);
		JComboBox cinfo =new JComboBox(info);
		JTextField cpath=new JTextField(path,16);
		JTextField zhuce=new JTextField("已注册",8);
		JButton[] jb={new JButton("查询"),new JButton("生成"),new JButton("导出"),new JButton("注册")};
		jb[0].setBounds(30, 10, 120, 40);
	    tip[0].setBounds(35, 50, 100, 30);
		jr[0].setBounds(30, 70, 100, 30);
		jr[1].setBounds(120, 70, 100, 30);
		jc1[0].setBounds(30, 100, 350, 40);
		jl.setBounds(35, 130, 200, 40);
		tip[1].setBounds(35, 150, 100, 30);
		jc2.setBounds(30, 170, 350, 40);
		tip[2].setBounds(35, 200, 100, 30);
		cyear.setBounds(30, 220, 100, 40);
		cmonth.setBounds(130, 220, 90, 40);
		cday.setBounds(220, 220, 90, 40);
		tip[3].setBounds(35, 250, 100, 30);
		cinfo.setBounds(30, 270, 130, 40);
		jb[1].setBounds(30, 320, 120, 40);
		jb[2].setBounds(30, 390, 120, 40);
		jb[3].setBounds(250, 500, 120, 40);
		zhuce.setBounds(250, 550, 120, 20);
		jb[3].setEnabled(false);
		cpath.setBounds(150, 400,200, 20);
		zhuce.setEditable(false);
		if(identify==0)
		{
			jb[2].setEnabled(false);
			cpath.setEnabled(false);
			cpath.setText("注册后可使用");
			jb[3].setEnabled(true);
			zhuce.setText("未注册");
		}
		
		cpath.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JTextField cpath=(JTextField)g.getSource();
			try {
				FileWriter w=new FileWriter(save1);
				String a=cpath.getText();
				w.write(a);
				w.flush();
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}});
		
		jb[3].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			
			 double i=Math.random()*10000000+88888888;
			 double j=((int)i+87654+12345)*3*4;
			String zc=JOptionPane.showInputDialog("您的随机八位序列码:"+(int)i,"输入激活码");
			
			try{
			
			double k=Double.parseDouble(zc);
			if((int)k==(int)j)
			{
				String a="1";	
				byte[] b=a.getBytes();
				FileOutputStream w;
				try {
					w = new FileOutputStream(path2);
					w.write(b);
			     	w.flush();
			    	w.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				new SRead(Year);
				JOptionPane.showMessageDialog(null, "注册成功");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "注册失败，激活码不正确");
			}

			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "注册失败，激活码不正确");
			}
			}});
		
		jb[2].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			String fornt="";
			JButton jb=(JButton)g.getSource();
	    	String save=jt.getText();
	    	byte[]b=save.getBytes();
	    	try {
				FileOutputStream w=new FileOutputStream(cpath.getText());
				w.write(b);
				w.flush();
				JOptionPane.showMessageDialog(null, "已导出到 "+cpath.getText());
				w.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
			try {
				FileOutputStream w=new FileOutputStream(save1);
				String a=cpath.getText();
				byte c[]=a.getBytes();
				w.write(c);
				w.flush();
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}});
		jb[1].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			String fornt="";
			JButton jb=(JButton)g.getSource();
			if(jr[0].isSelected()==true)
			fornt=(forntsix[jc1[0].getSelectedIndex()]+cyear.getSelectedItem()+cmonth.getSelectedItem()+cday.getSelectedItem());
			if(jr[1].isSelected()==true)
			fornt=(forntsix[jc1[1].getSelectedIndex()]+cyear.getSelectedItem()+cmonth.getSelectedItem()+cday.getSelectedItem());
			String[] firstsave=new String[100000];
			String[] lastsave=new String[100000];
			int s=0,f=0;
			for(int q=0;q<1000;q++)
			{	input=fornt;
				if(q<10)
				{		
					firstsave[f]=input+"00"+q+"0";
					f++;
					firstsave[f]=input+"00"+q+"1";
					f++;
					
					firstsave[f]=input+"00"+q+"2";
					f++;
					
					firstsave[f]=input+"00"+q+"3";
					f++;
					
					firstsave[f]=input+"00"+q+"4";
					f++;
					
					firstsave[f]=input+"00"+q+"5";
					f++;
					
					firstsave[f]=input+"00"+q+"6";
					f++;
					
					firstsave[f]=input+"00"+q+"7";
					f++;

					firstsave[f]=input+"00"+q+"8";
					f++;
					firstsave[f]=input+"00"+q+"9";
					f++;
					firstsave[f]=input+"00"+q+"x";
					f++;
				}
				if(q>9&&q<100)		
				{
					
					firstsave[f]=input+"0"+q+"0";
					f++;
					
					firstsave[f]=input+"0"+q+"1";
					f++;
					
					firstsave[f]=input+"0"+q+"2";
					f++;
					
					firstsave[f]=input+"0"+q+"3";
					f++;
					
					firstsave[f]=input+"0"+q+"4";
					f++;
					
					firstsave[f]=input+"0"+q+"5";
					f++;
					
					firstsave[f]=input+"0"+q+"6";
					f++;
					
					firstsave[f]=input+"0"+q+"7";
					f++;
					
					firstsave[f]=input+"0"+q+"8";
					f++;
					
					firstsave[f]=input+"0"+q+"9";
					f++;
					
					firstsave[f]=input+"0"+q+"x";
					f++;
				}
				if(q>99&&q<1000)		
				{
					firstsave[f]=input+""+q+"0";
					f++;
					
					firstsave[f]=input+""+q+"1";
					f++;
					
					firstsave[f]=input+""+q+"2";
					f++;
					
					firstsave[f]=input+""+q+"3";
					f++;
					
					firstsave[f]=input+""+q+"4";
					f++;
					
					firstsave[f]=input+""+q+"5";
					f++;
					
					firstsave[f]=input+""+q+"6";
					f++;
					
					firstsave[f]=input+""+q+"7";
					f++;
					
					firstsave[f]=input+""+q+"8";
					f++;
					
					firstsave[f]=input+""+q+"9";
					f++;
					
					firstsave[f]=input+""+q+"x";
					f++;
				}

					input="";
				}
			int j=0;
			if(jc2.getSelectedIndex()==0)
			{
			for(int i=0;i<firstsave.length;i++)
			{
				input=firstsave[i];
				if(input==null)
					break;
				if(both()==true)
				{
					lastsave[j]=input;
					j++;
				}
			}
			}
			if(jc2.getSelectedIndex()==1)
			{
			for(int i=0;i<firstsave.length;i++)
			{
				input=firstsave[i];
				if(input==null)
					break;
				String sex=input.substring(14, 17);
				int se=Integer.parseInt(sex);
				if(se%2!=0&&both()==true)
				{
					lastsave[j]=input;
					j++;
				}
			}
			}
			if(jc2.getSelectedIndex()==2)
			{
			for(int i=0;i<firstsave.length;i++)
			{
				input=firstsave[i];
				if(input==null)
					break;
				String sex=input.substring(14, 17);
				int se=Integer.parseInt(sex);
				if(se%2==0&&both()==true)
				{
					lastsave[j]=input;
					j++;
				}
			}
			}
			if(cinfo.getSelectedIndex()==1)
			{
				for(int i=0;i<lastsave.length;i++)
				{
					input=lastsave[i];
					if(input==null)
						continue;
					if(last()==false)
					{
						lastsave[i]=null;
					}
				}
			}
			String hh="\n";
			String b1="";
			for(String b:lastsave)
			{
				if(b==null)
				continue;
				b1+=b+hh;
			}
			
			jt.setText(b1);
		}});
		jb[0].addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton jb=(JButton)g.getSource();
			input=JOptionPane.showInputDialog(null,"输入18位号码");
			
			boolean k=false,k1=false,k2=false;
			while(k!=true||k1!=true)
			{
			if(input.length()>18||input.length()==0)
			{
				JOptionPane.showMessageDialog(null, "错误");
				break;
			}
			k=Checkfont();
			k1=both();
			k2=last();
			if(k==false||k1==false)
			{
				JOptionPane.showMessageDialog(null, "错误");
				k=Checkfont();
				k1=both();
				break;
			}
			}
			String q=input.substring(6, 10);
			String q1=input.substring(10, 12);
			String q2=input.substring(12, 14);
			String sex=input.substring(14, 17);
			int s1=Integer.parseInt(q);
			int s=Integer.parseInt(sex);
			String t=("地区:"+area[are]+"\r\n"+"出生:"+q+"."+q1+"."+q2+"\r\n"+"年龄:"+(Year-s1)+"\r\n"+"性别:"+(s%2==0?"女":"男")+"\r\n"+"合法:"+(last()?"是":"否"));
			jt.setText(t);
			
		}
		});
		for(int i=0;i<3;i++)
		JS2.add(jb[i]);
		JS2.add(jc1[0]);
		JS2.add(jc1[1]);
		JS2.add(jc2);
		JS2.add(jl);
		JS2.add(jr[0]);
		JS2.add(jr[1]);
		JS2.add(tip[0]);
		JS2.add(tip[1]);
		JS2.add(tip[2]);
		JS2.add(tip[3]);
		JS2.add(cyear);
		JS2.add(cmonth);
		JS2.add(cday);
		JS2.add(cinfo);
		JS2.add(cpath);
		JS2.add(jb[3]);
		JS2.add(zhuce);
		jf.setVisible(true);
	}
	
	public void Readfile()
	{
		try
		{
			String a="D:\\JavaEX\\LJL\\src\\TEST\\xml\\1.xls";
		Workbook book=
		Workbook.getWorkbook(new File("/Volumes/LJL/JavaEX/LJL/src/TEST/xml/1.xls"));//获得第一个工作表对象
		Sheet sheet=book.getSheet(0);//单元格第一页
		Cell[] cellfornt=new Cell[forntsix.length];
		Cell[] cellarea=new Cell[area.length];
		for(i=0;i<forntsix.length;i++)
		{
		cellfornt[i]=sheet.getCell(0,i+1);
		cellarea[i]=sheet.getCell(1,i+1);
		forntsix[i]=cellfornt[i].getContents();//数组加入第一列的单元格
		area[i]=cellarea[i].getContents();//数组加入第二列的单元格
		//System.out.println(area[i]);
		}
		book.close();
		}catch(Exception e)
		{
			Workbook book;
			try {
				book = Workbook.getWorkbook(new File("/Volumes/LJL/JavaEX/LUJIALE04151010/src/TEST/xml/1.xls"));//获得第一个工作表对象
				Sheet sheet=book.getSheet(0);//单元格第一页
				Cell[] cellfornt=new Cell[forntsix.length];
				Cell[] cellarea=new Cell[area.length];
				for(i=0;i<forntsix.length;i++)
				{
					cellfornt[i]=sheet.getCell(0,i+1);
					cellarea[i]=sheet.getCell(1,i+1);
					forntsix[i]=cellfornt[i].getContents();//数组加入第一列的单元格
					area[i]=cellarea[i].getContents();//数组加入第二列的单元格
				}
				book.close();
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		}
	
		
	}
	
	public void Input()
	{//
		boolean k=false,k1=false,k2=false;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter your ID:");
		input=scanner.next();
		while(k!=true||k1!=true)
		{
		if(input.length()>18||input.length()==0)
		{
			System.out.println("Error ID");
			System.out.print("Enter your ID:");
			input=scanner.next();
			continue;
		}
		k=Checkfont();
		k1=both();
		k2=last();
		if(k==false||k1==false)
		{
			System.out.println("Error ID");
			System.out.print("Enter your ID:");
			input=scanner.next();
			k=Checkfont();
			k1=both();
			continue;
		}
		}
		scanner.close();
	}
	
	public boolean Checkfont()
	{try{
		String k=input.substring(0, 6);
		for(i=0;i<forntsix.length;i++)
		{
			if(forntsix[i].equals(k))
			{
				are=i;
				return true;
			}
		}
		return false;}catch(Exception e)
	{
			return false;
	}
	}
	
	public boolean both()
	{
		try{
		String k=input.substring(6, 10);
		String k1=input.substring(10, 12);
		String k2=input.substring(12, 14);
		int s=Integer.parseInt(k);
		int s1=Integer.parseInt(k1);
		int s2=Integer.parseInt(k2);
		if(k1.equals("01")||k1.equals("02")||k1.equals("03")||k1.equals("04")||k1.equals("05")||k1.equals("06")||k1.equals("07")||k1.equals("08")||k1.equals("09")||k1.equals("010")||k1.equals("11")||k1.equals("12"))
		{
			 if((k1.equals("04")||k1.equals("05")||k1.equals("06")||k1.equals("09")||k1.equals("11"))&&s2<=30)
		{
			return true;
		}
		else if((k1.equals("01")||k1.equals("03")||k1.equals("07")||k1.equals("08")||k1.equals("10")||k1.equals("12"))&&s2<=31)
		{
			return true;
		} 
		}
		if(k1.equals("02"))
		{
			if((s%4==0)&&(s%100!=0||s%400==0)&&(s2<30))
			{
				return true;
			}	
			else if(s2<29)
			{
			return true;
			}	
		}
		return false;}catch(Exception e)
		{
			return false;
		}
	}
	public boolean last()
	{
		int  []a=new int[17];
		double []b=new double[17];
		double d=0;
		try{
		for(i=0;i<input.length()-1;i++)
		{
			a[i]=Integer.parseInt(input.substring(i, i+1));	
		}
		}catch(Exception e)
		{
			for(i=0;i<=input.length()-2;i++)
			{
				a[i]=Integer.parseInt(input.substring(i, i+1));	
			}
		}
		for(i=0;i<17;i++)
		{
			b[i]=Math.pow((double)2, (double)(i+1));
		}
		for(i=0;i<17;i++)
		{
			d+=a[i]*b[16-i];
		}
		
		int k=(int)d%11;
		try{
		int e=Integer.parseInt(input.substring(17));
		 if(k==0&&e==1)
		{
				return true;
		}
		else if(k==1&&e==0)
		{
			return true;
		}
		else if((k==2&&input.substring(17).equals("x"))||(k==2&&input.substring(17).equals("X")))
		{
				return true;
			
		}
		else if(k==3&&e==9)
		{
				return true;
		}
		else if(k==4&&e==8)
		{
				return true;
		}
		else if(k==5&&e==7)
		{
				return true;
		}
		else if(k==6&&e==6)
		{
				return true;
		}
		else if(k==7&&e==5)
		{
				return true;
		}
		else if(k==8&&e==4)
		{
				return true;
		}
		else if(k==9&&e==3)
		{
				return true;
		}
		else if(k==10&&e==2)
		{
				return true;
		}
		}
		catch(Exception d1)
	   {	
			 if(k==2&&input.substring(17).equals("x")||k==2&&input.substring(17).equals("X"))
						return true;	
	   }
		
			return false;
		
	}
	public void print()
	{
		Readfile();
  		Input();
		String k=input.substring(6, 10);
		String k1=input.substring(10, 12);
		String k2=input.substring(12, 14);
		String sex=input.substring(14, 17);
		int s1=Integer.parseInt(k);
		int s=Integer.parseInt(sex);
		System.out.println("地区:"+area[are]);
		System.out.println("出生:"+k+"."+k1+"."+k2);
		System.out.println("年龄:"+(Year-s1));
		System.out.println("性别:"+(s%2==0?"女":"男"));
		System.out.println("合法:"+(last()?"是":"否"));
	}
  	public static void main(String[] args) {
		// TODO Auto-generated method stub
  		Calendar cal = Calendar.getInstance();
  		int year = cal.get(Calendar.YEAR);
  		SRead a=new SRead(year);
 
  		
  	
	}

}
