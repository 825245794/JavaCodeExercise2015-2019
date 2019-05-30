package TEST;

	import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
public class A47 extends JFrame implements DocumentListener {

	/**
	 * @param args
	 */
	    Random rand=new Random();
		JPanel panel=new JPanel(null);
		JFrame frame=new JFrame("URL");
		JTextField text=new JTextField();
		TextArea ta=new TextArea();
		JLabel label=new JLabel("Input URL:");
		JLabel title=new JLabel("");
		String []URL=new String[100000];
		int urlnum=0;
		String a="";
		String save[]=new String[10];
		public A47(){
			GUI();
			removenull();
			int index=0;
			while(index!=URL.length){
			text.setText("生成 URL:"+(index+1)+"/"+URL.length);
			random();
			index++;
			}
			title.setText("生成URL:完成");
			text.setText("");
			text.setEnabled(true);
			text.setBackground(Color.white);
			Document doc=text.getDocument();
			doc.addDocumentListener(this);
		}
		public void GUI(){
			frame.setSize(480,640);
			frame.setBackground(Color.white);
			title.setBounds(150, 10, 200, 20);
			label.setBounds(60, 30, 80, 20);
			text.setBounds(120, 30, 270, 20);
			ta.setBounds(60, 80, 360, 500);
			text.setEnabled(false);
			ta.setEditable(false);
			text.setText("");
			frame.add(panel);
			panel.add(text);
			panel.add(title);
			panel.add(label);
			panel.add(ta);
			frame.setVisible(true);
//			text.addActionListener(new ActionListener()
//			{
//			public void actionPerformed(ActionEvent g) {
//				search();
//				for(int i=0;i<10;i++){
//				ta.setText(save[i]);}
//			}
//			});
		}
		public void insertUpdate(DocumentEvent g){
			search();
			for(int i=0;i<10;i++){
			a=save[i]+"\n";
			ta.append(a);}
		}
		public void removeUpdate(DocumentEvent g){
			search();
			for(int i=0;i<10;i++){
			a=save[i]+"\n";
			ta.append(a);}
		}
		public void changedUpdate(DocumentEvent g){
			search();
			for(int i=0;i<10;i++){
			a=save[i]+"\n";
			ta.append(a);}
		}
		public void removenull(){
			for(int i=0;i<URL.length;i++){
				if(URL[i]==null)
					URL[i]="";
			}
		}
		public void search(){
			int j=0;
			ta.setText("");
			for(int i=0;i<URL.length;i++){
				if(URL[i].indexOf(text.getText())!=-1){
					save[j]=URL[i];
					j++;
				}
				if(j>9){
					break;
				}
			}
		}
		public void random(){
			for(int i=0;i<7;i++){
				int j=(int)((Math.random()*26)+97);
				URL[urlnum]+=String.valueOf((char)j);
			}
			URL[urlnum]="www."+URL[urlnum]+".com";
			urlnum++;
			System.out.print(URL[urlnum-1]);
			System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A47 a=new A47();
	}

}
