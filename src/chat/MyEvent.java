package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

class MyEvent {  
	  
    static String myIp = "";  
    static String myText;  
    String myReceText;  
  
    public MyEvent() {  
  
        // 提交  
        MyFrame.btnPost.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
  
                myIp = MyFrame.ipField.getText().toString().trim();  
  
                String[] strings = myIp.split("\\.");  
                boolean t = true;  
  
                if (strings.length != 4) {  
                    t = false;  
                    JOptionPane.showMessageDialog(null, "请输入正确的IP地址！");  
                } else {  
                    for (int i = 0; i < strings.length; i++) {  
  
                        // 告知此字符串是否匹配给定的正则表达式。  
                        if (!strings[i]  
                                .matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")) {  
                            t = false;  
                            JOptionPane.showMessageDialog(null, "带有非数字字符！");  
                            break;  
  
                        } else if (Integer.parseInt(strings[i]) > 255  
                                || Integer.parseInt(strings[i]) < 0) {  
                            t = false;  
                            JOptionPane.showMessageDialog(null, "请输入正确的IP地址！");  
                            break;  
                        }  
  
                    }  
                }  
                if (t) {  
                    myIp = MyFrame.ipField.getText().toString().trim();  
                    System.out.println("目标IP:" + myIp);  
                    JOptionPane.showMessageDialog(null, "提交成功！");  
                }  
            }  
        });  
  
        // 清除  
        MyFrame.btnCancel.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
  
                MyFrame.inputField.setText(" ");  
  
            }  
        });  
  
        // 发送并清除编辑内容  
        MyFrame.btnSend.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
  
                myText = MyFrame.inputField.getText().toString().trim();  
  
                if (myIp.equals("")) {  
                    JOptionPane.showMessageDialog(null, "请输入目标IP并提交！");  
                } else if (myText.equals("")) {  
                    JOptionPane.showMessageDialog(null, "请输入内容再发送！");  
  
                } else {  
  
                    System.out.println("发送内容：" + myText);  
                    MyFrame.inputField.setText(" ");  
  
                    try {  
  
                        new MySend();  
  
                    } catch (Exception e1) {  
                        e1.printStackTrace();  
                    }  
                }  
  
            }  
        });  
  
        // 刷新聊天记录  
        MyFrame.btnRecord.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                // TODO Auto-generated method stub  
  
            }  
        });  
  
    }  
  
}  