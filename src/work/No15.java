/**  
* @Title: No15.java
* @Package work
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2018年10月15日 下午7:23:57
* @version V1.0  
*/
package work;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * @ClassName: No15
 * @Description:
 * @author LJL
 * @date 2018/10/15 19:23:57
 *
 */
public class No15 {

    /**
    * @Title: main
    * @Description: 
    * @param @param args
    * @return void 
    * @throws
    */
    String text[] = {"陈楚楚的温度计","转换","<html><font style=\"font-size:16px;\">华氏温度为: %s℉</font></html>"};
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton(text[1]);
    JLabel show = new JLabel(String.format(text[2],""));
    JTextPane input = new JTextPane();
    JLabel labelBackgroung;
    String imagePath[] = {"spring.jpg","summer.jpg","autumn.jpg","winter.jpg"};
    String path=System.getProperty("user.dir")+"\\src\\work\\";
    String music = path+"music.wav";//E:\Java\src\work
    public No15(){
    	try {
    		System.out.println(music);
    		File f = new File(music); 
       	 URI uri = f.toURI();
       	 URL url = uri.toURL();  //解析地址
       	 AudioClip aau; 
       	 aau = Applet.newAudioClip(url);
       	aau.play();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	 
    	
        Container container = new Container();
        JPanel panel1 = new JPanel();
        frame.setTitle(text[0]);
        frame.setSize(600, 800);
        frame.setLayout(null);
        panel1.setLayout(null);
        panel.setLayout(null);
        panel.setSize(600, 800);
        panel.setBounds(0, 50, frame.getWidth(), frame.getHeight()-50);
        panel1.setBounds(0, 0, frame.getWidth(), 50);
        panel1.setBackground(Color.green);
        input.setBounds(350, 10, 150, 20);
        button.setBounds(250, 10, 70, 20);
        show.setBounds(0, 0, 150, 50);
        ImageIcon background = new ImageIcon(path+imagePath[0]);
        Image image=background.getImage().getScaledInstance(panel.getWidth(),750,background.getImage().SCALE_DEFAULT);  
        background=new ImageIcon(image); 
        labelBackgroung = new JLabel(background);
        labelBackgroung.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel1.add(input);
        panel1.add(show);
        panel1.add(button);
        panel.add(labelBackgroung);
        frame.add(panel);
        frame.add(panel1);
        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                JButton e1=(JButton)e.getSource();
                double j = 0;
                try{
                    j = Double.parseDouble(input.getText());
                    show.setText(String.format(text[2],String.valueOf(j*9/5+32)));
                    String s ="";
                    if(j<=5){
                        s = imagePath[3];
                    }else if(j>5&&j<15){
                        s = imagePath[0];
                    }else if(j>=15&&j<25){
                        s = imagePath[2];
                    }else if(j>=25){
                        s = imagePath[1];
                    }
                    String paths = path+s;
                    ImageIcon background = new ImageIcon(paths);
                    Image image=background.getImage().getScaledInstance(panel.getWidth(),750,background.getImage().SCALE_DEFAULT);  
                    background=new ImageIcon(image); 
                    labelBackgroung.setIcon(background);
                }catch(Exception exception){
                    show.setText("Error");
                }
            }
            
        });
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        No15 temp = new No15();

    }

}
