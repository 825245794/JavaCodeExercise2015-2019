package web;
import java.awt.TextArea;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPasswordField;

import javax.swing.JTextField;

public class LoginUI extends JFrame {

/**

*

*/

public Score score;

private static HttpUtil httpUtil= new HttpUtil();

private static final long serialVersionUID = 1L;

public static final int GAME_WIDTH = 400 ;

public static final int GAME_HIGTH = 500 ;

JLabel jlAccount = new JLabel("账户：",JLabel.RIGHT);

JLabel jlPassword = new JLabel("密码：",JLabel.RIGHT);

JLabel jlCode = new JLabel("验证码：",JLabel.RIGHT);

JTextField jtAccount = new JTextField("",20);

JPasswordField jtPassword = new JPasswordField("",20);

JTextField jtCode = new JTextField("",8);

JLabel jlRndomCode=new JLabel();

JButton jbLogin = new JButton("登陆并查成绩");

JLabel jlScore = new JLabel("成绩");

TextArea tResult = new TextArea();

public LoginUI(){

this.setLayout(null);

jtPassword.setEchoChar('*');

jlAccount.setBounds(50,50,80,30);

jlPassword.setBounds(50,100,80,30);

jlCode.setBounds(50, 150, 80, 30);

jtAccount.setBounds(150,50,150,30);

jtPassword.setBounds(150,100,150,30);

jtCode.setBounds(150,150,80,30);

jlRndomCode.setBounds(250, 150, 80, 30);

ImageIcon img = new ImageIcon(HttpUtil.imageFileName);

jlRndomCode.setIcon(img);

jbLogin.setBounds(160, 220, 120, 30);

jlScore.setBounds(120, 260, 80, 30);

tResult.setBounds(50, 300, 300, 120);

tResult.setEditable(false);

add(jlAccount);

add(jlPassword);

add(jlCode);

add(jtCode);

add(jtAccount);

add(jtPassword);

add(jbLogin);

add(jlRndomCode);

add(jlScore);

add(tResult);

this.setTitle("登陆并查成绩");

this.setSize(GAME_WIDTH,GAME_HIGTH);

this.setLocation(350,180);

this.addWindowListener(new WindowAdapter(){

public void windowClosing(WindowEvent e) {

System.exit(0);

}

});

this.setVisible(true);

this.setResizable(false);

jbLogin.addActionListener(new ActionListener() {

@Override

public void actionPerformed(ActionEvent e) {

if(jtAccount.getText().equals("")||new String(jtPassword.getPassword()).trim().equals(""))

{

System.out.println("请输入帐号和密码");

return;

}

if(jtCode.getText().trim().equals(""))

{

System.out.println("请输入验证码");

return;

}

httpUtil.login(jtAccount.getText().trim(),new String(jtPassword.getPassword()).trim(),jtCode.getText().trim());

score = new Score(httpUtil.chenji());

String result = "";

for(int i=0;i<score.courseName.size();i++){

result = result + score.courseName.get(i)+"\t"+score.score.get(i)+"\n";

}

tResult.setText(result);

}

});

}

public static void main(String[] args) {

new LoginUI();

}

}

