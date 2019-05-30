package web;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class URLTest {
	public URLTest() throws IOException
	{
		    JFrame frame=new JFrame("手机号归属地查询");
		    Container contain=frame.getContentPane();
		    JButton button=new JButton("查询");
		    JPanel panel=new JPanel(null);
		    panel.setSize(320,240);
		    JTextField text=new JTextField("输入手机号码");
		    JLabel label[]={new JLabel(),new JLabel(),new JLabel()};
			frame.setSize(320, 240);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			text.setBounds(40, 25, 160, 25);
			button.setBounds(200, 25,60, 25);
			label[0].setBounds(60, 60, 160, 25);
			label[1].setBounds(60, 80, 160, 25);
			label[2].setBounds(60, 100, 160, 25);
			panel.add(text);
			panel.add(button);
			panel.add(label[0]);
			panel.add(label[1]);
			panel.add(label[2]);
			frame.add(panel);
			frame.setVisible(true);
		    button.addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent g){
				// TODO Auto-generated method stub	
				if(text.getText().length()<11)
				JOptionPane.showMessageDialog(null, "号码不正确");
				else {
				 
					try {
						String strURL = "http://www.00cha.com/114.asp?t="+text.getText();  
				    URL url;
						url = new URL(strURL);
						HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
					    InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "gb2312");  
					    BufferedReader bufReader = new BufferedReader(input);  
					    String line = "";  
					    StringBuilder contentBuf = new StringBuilder();  
					    while ((line = bufReader.readLine()) != null) {  
					        contentBuf.append(line);
					    }
						String buf = contentBuf.toString();
				    String index;
				    System.out.println("卡号:"+text.getText());
				    label[0].setText("卡号:"+text.getText());
				    int beginIx = buf.indexOf("归属地：");
				    int end=buf.indexOf("</b></font>&nbsp;");
				    index=buf.substring(beginIx+23,end);
				    System.out.println("归属地:"+index);
				    label[1].setText("归属地:"+index);
				    beginIx = buf.indexOf("卡 类 型：");
				    end=buf.indexOf("</b></font><br><div id=myDiv></div>");
				    index=buf.substring(beginIx+25,end);
				    System.out.print("卡类型："+index);
				    label[2].setText("卡类型："+index);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}
				
			    }});
	  
		     
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URLTest a=new URLTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
