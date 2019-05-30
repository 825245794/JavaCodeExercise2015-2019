package work;

	import java.awt.Color;
import java.awt.TextArea;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
public class A47 implements DocumentListener {

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
		String []URL=new String[10];
		int urlnum=0;
		String a="";
		String save[]=new String[10];
		public A47(){
			GUI();
			removenull();
			int index=0;
			while(index!=URL.length){
			text.setText("生成URL:"+(index+1));
			random();
			index++;
			}
			title.setText("URL生成完成");
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
				int j=(int)((Math.random())*97);
				URL[urlnum]+=String.valueOf((char)j);
			}
			URL[urlnum]="www."+URL[urlnum]+".com";
			System.out.println(URL[urlnum]);
			urlnum++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A47 a=new A47();
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	    Document doc = arg0.getDocument();  
        String s = null;
        try {
            s = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);
	}
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	    Document doc = arg0.getDocument();  
        String s = null;
        try {
            s = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);
	}
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	    Document doc = arg0.getDocument();  
        String s = null;
        try {
            s = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);
	}
   

}
