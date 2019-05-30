package TEST;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SJapanese {
	static int i=0,j=1;
	int arr,arrt=0;
	char in[];
	String put,trans[];
	JTextField d=new JTextField("",20);
	JTextField d1=new JTextField("",20);
	public SJapanese()
	{
		JFrame a=new JFrame("Japanes-LJL");
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(350, 480);
		Container b=a.getContentPane();
		b.setLayout(new BoxLayout(b,BoxLayout.Y_AXIS));
		JLabel[] c={new JLabel("日语罗马音转换器"),new JLabel("默认平假名，输入途中可以输入1或2来切换平假名与片假名"),new JLabel("例：konnichiha,2sekai"),new JLabel("转换后：こんにちは,セカイ"),new JLabel("自动复制到右键粘贴")};
		JPanel z=new JPanel();
		z.setLayout(new FlowLayout());
		b.add(z);
		z.add(c[0]);
		z.add(c[1]);
		z.add(c[2]);
		z.add(c[3]);
		
		
		JPanel z1=new JPanel();
		z.setLayout(new FlowLayout());
		JButton e=new JButton();
		e=new JButton("Translate");	
		e.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			JButton e=(JButton)g.getSource();
			put=d.getText();
			put=put.toLowerCase();
			Arrsize();
			Search();
			String t="";
			for(String c:trans)
			{
				if(c==null)
					break;
				t+=c;
			}
			java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();//获取系统剪切板
			StringSelection selection = new StringSelection(t);//构建String数据类型
			clipboard.setContents(selection, selection);//添加文本到系统剪切
			d1.setText(t);
			clear();
		}
		});
		b.add(z1);
		z1.add(d);
		z1.add(e);
		
	
		JPanel z2=new JPanel();
		z2.setLayout(new FlowLayout());
		d1.setEditable(false);
		b.add(z2);
		z2.add(c[4]);
		z2.add(d1);
		
		a.setVisible(true);
	}
	
	public void clear()
	{
		for(int i=0;i<trans.length;i++)
		{
			in[i]=' ';
			put=null;
			trans[i]=null;
		}
		i=0;
		j=1;
		arr=0;
		arrt=0;
	}
	public void Arrsize()
	{
//		System.out.print(put);
		in=new char[put.length()];
		trans=new String[put.length()];
		for(arr=0;arr<in.length;arr++)
		{
			in[arr]=put.charAt(arr);
		}
//		System.out.print(put.length());
//		System.out.print(in.length);
//		System.out.print(trans.length);
	}
	
	public void Search()
	{
		while(i!=put.length())
		{
			if(in[i]=='1'){j=1;i++;}
			if(in[i]=='2'){j=2;i++;}
			///////////////////////
			if(in[i]=='a')
			{
				if(j==1)
				{
					trans[arrt]="あ";
					arrt++;
					i++;
					continue;
				}
				if(j==2)
				{
					trans[arrt]="ア";
					arrt++;
					i++;
					continue;
				}
			}
		///////////////////////////
			else if(in[i]=='i')
			{
				if(j==1)
				{
					trans[arrt]="い";
					arrt++;
					i++;
					continue;
				}
				if(j==2)
				{
					trans[arrt]="イ";
					arrt++;
					i++;
					continue;
				}

			}
	
			/////////////////////////////////
			else if(in[i]=='u')
			{
				if(j==1)
				{
					trans[arrt]="う";
					arrt++;
					i++;
					continue;
				}
				if(j==2)
				{
					trans[arrt]="ウ";
					arrt++;
					i++;
					continue;
				}

			}
			
		//////////////////////////////	

			else if(in[i]=='e')
			{
				if(j==1)
				{
					trans[arrt]="え";
					arrt++;
					i++;
					continue;
				}
				if(j==2)
				{
					trans[arrt]="エ";
					arrt++;
					i++;
					continue;
				}
			}
			////////////////////////
			else if(in[i]=='o')
			{
				if(j==1)
				{
					trans[arrt]="お";
					arrt++;
					i++;
					continue;
				}
				if(j==2)
				{
					trans[arrt]="オ";
					arrt++;
					i++;
					continue;
				}
			}
			//////////////////////////c
			else if(in[i]=='c')
			{
				i++;
				if(j==1&&in[i]=='c')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='c')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
			if(j==1&&in[i]=='h'&&in[i+1]=='i')
			{
				trans[arrt]="ち";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==2&&in[i]=='h'&&in[i+1]=='i')
			{
				trans[arrt]="チ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
			{
				trans[arrt]="ちゃ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
			{
				trans[arrt]="チャ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
			{
				trans[arrt]="ちゅ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
			{
				trans[arrt]="チュ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
			{
				trans[arrt]="ちょ";
				arrt++;
				i++;
				i++;
				continue;
			}
			if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
			{
				trans[arrt]="チョ";
				arrt++;
				i++;
				i++;
				continue;
			}
			}
			////////////////////////k
			else if(in[i]=='k')
			{
				i++;
				if(j==1&&in[i]=='k')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='k')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="きゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="キャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="きゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="キュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="きょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="キョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="か";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="カ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="き";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="キ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="く";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ク";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="け";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ケ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="こ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="コ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////////s
			else if(in[i]=='s')
			{
				i++;
				if(j==1&&in[i]=='s')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='s')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="しゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="シャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="しゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="シュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="しょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ショ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="さ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="サ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='h'&&in[i+1]=='i')
				{
					trans[arrt]="し";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='h'&&in[i+1]=='i')
				{
					trans[arrt]="シ";
					arrt++;
					i++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="す";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ス";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="せ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="セ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="そ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ソ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
		////////////////////////////////////////t	
			else if(in[i]=='t')
			{
				i++;
				if(j==1&&in[i]=='t')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='t')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="てゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="テャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="てゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="テュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="てょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="テョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="た";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="タ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='s'&&in[i+1]=='u')
				{
					trans[arrt]="つ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='s'&&in[i+1]=='u')
				{
					trans[arrt]="ツ";
					arrt++;
					i++;
					i++;
					continue;
				}				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="て";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="テ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="と";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ト";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////////n
			else if(in[i]=='n')
			{
				i++;
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="な";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ナ";
					arrt++;
					i++;
					continue;
				}	
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="にゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ニャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="にゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ニュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="にょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ニョ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="に";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ニ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ぬ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ヌ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="ね";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ネ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="の";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ノ";
					arrt++;
					i++;
					continue;
				}
				else
				{
				
					if(j==1)
					{
					trans[arrt]="ん";
					arrt++;
					continue;
					}
					if(j==2)
					{
					trans[arrt]="ン";
					arrt++;
					continue;
					}
				}
			}
			
			////////////////////////////////h
			else if(in[i]=='h')
			{
				i++;
				if(j==1&&in[i]=='h')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='h')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ひゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ヒャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ひゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='y'&&in[i+1]=='u')
				{
					trans[arrt]="ヒュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ひょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='y'&&in[i+1]=='o')
				{
					trans[arrt]="ヒョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="は";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ハ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="ひ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ヒ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ふ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="フ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="ヘ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="へ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ほ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ホ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			////////////////////////////m
			else if(in[i]=='m')
			{
				i++;
				if(j==1&&in[i]=='m')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='m')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="みゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='y'&&in[i+1]=='a')
				{
					trans[arrt]="ミャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='y'&&in[i+1]=='u')
				{
					trans[arrt]="みゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='y'&&in[i+1]=='u')
				{
					trans[arrt]="ミュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='y'&&in[i+1]=='o')
				{
					trans[arrt]="みょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ミョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ま";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="マ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="み";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ミ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="む";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ム";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="め";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="メ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="も";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="モ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			////////////////////////y
			else if(in[i]=='y')
			{
				i++;
				if(j==1&&in[i]=='y')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='y')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="や";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ヤ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="い";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="イ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ゆ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ユ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="え";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="エ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="よ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ヨ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			/////////////////////r
			else if(in[i]=='r')
			{
				i++;
				if(j==1&&in[i]=='r')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='r')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="りゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="リャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="りゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="リュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="りょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="リョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ら";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ラ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="り";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="リ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="る";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ル";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="れ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="レ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ろ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ロ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			/////////////w
			
			else if(in[i]=='w')
			{
				i++;
				if(j==1&&in[i]=='w')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='w')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="わ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ワ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="い";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="イ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="う";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ウ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="え";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="エ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="を";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ヲ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			////////////////////////////////g
			else if(in[i]=='g')
			{
				i++;
				if(j==1&&in[i]=='g')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='g')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ぎゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ギャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ぎゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='y'&&in[i+1]=='u')
				{
					trans[arrt]="ギュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ぎょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ギョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="が";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ガ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="ぎ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ギ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ぐ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="グ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="げ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ゲ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ご";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ゴ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////z
			else if(in[i]=='z')
			{
				i++;
				if(j==1&&in[i]=='z')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='z')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ザゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="じャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ザゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="じュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ザょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="じョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ざ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ザ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="じ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ジ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ず";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ズ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="ぜ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ゼ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ぞ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ゾ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////d
			else if(in[i]=='d')
			{
				i++;
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ぢゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ヂャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ぢゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ヂュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ぢょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ヂョ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='d')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='d')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="だ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ダ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="ぢ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ヂ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="づ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ヅ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="で";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="デ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ど";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ド";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////b
			else if(in[i]=='b')
			{
				i++;
				if(j==1&&in[i]=='b')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='b')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="びゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ビャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="びゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ビュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="びょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ビョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ば";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="バ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="び";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ビ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ぶ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ブ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="べ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ベ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ぼ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ボ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////p
			
			
			else if(in[i]=='p')
			{
				i++;
				if(j==1&&in[i]=='p')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='p')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="パゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ぴャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="パゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='y'&&in[i+1]=='u')
				{
					trans[arrt]="ぴュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="パょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ぴョ";
					arrt++;
					i++;
					i++;
					continue;
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ぱ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="パ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="ぴ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="キ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ピ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="プ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="ぺ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ペ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ぽ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ポ";
					arrt++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////x
			else if(in[i]=='x')
			{
				i++;
				if(j==1&&in[i]=='x')
				{
					trans[arrt]="っ";
					arrt++;
					i++;
					
				}
				if(j==2&&in[i]=='x')
				{
					trans[arrt]="ッ";
					arrt++;
					i++;
					
				}
			 if(j==1&&in[i]=='a')
				{
					trans[arrt]="ぁ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='a')
				{
					trans[arrt]="ァ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='i')
				{
					trans[arrt]="ぃ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='i')
				{
					trans[arrt]="ィ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='u')
				{
					trans[arrt]="ぅ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='u')
				{
					trans[arrt]="ゥ";
					arrt++;
					i++;
					continue;
				}
				
				if(j==1&&in[i]=='e')
				{
					trans[arrt]="ぇ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='e')
				{
					trans[arrt]="ェ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='o')
				{
					trans[arrt]="ぉ";
					arrt++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='o')
				{
					trans[arrt]="ォ";
					arrt++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='a'||j==1&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ゃ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='a'||j==2&&in[i]=='h'&&in[i+1]=='a')
				{
					trans[arrt]="ャ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='u'||j==1&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ゅ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='u'||j==2&&in[i]=='h'&&in[i+1]=='u')
				{
					trans[arrt]="ュ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==1&&in[i]=='y'&&in[i+1]=='o'||j==1&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ょ";
					arrt++;
					i++;
					i++;
					continue;
				}
				if(j==2&&in[i]=='y'&&in[i+1]=='o'||j==2&&in[i]=='h'&&in[i+1]=='o')
				{
					trans[arrt]="ョ";
					arrt++;
					i++;
					i++;
					continue;
				}
				else
				{
					trans[arrt]=String.valueOf(in[i-1]);
					arrt++;
					trans[arrt]=String.valueOf(in[i]);
					arrt++;
					i++;
					continue;
				}
			}
			///////////////////////else
			else
			{
				trans[arrt]=String.valueOf(in[i]);
				arrt++;
				i++;
				continue;
			}
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SJapanese a=new SJapanese();
	}

}
