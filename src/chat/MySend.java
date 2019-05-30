package chat;

import java.awt.Button;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.Frame;  
import java.awt.Label;  
import java.awt.TextArea;  
import java.awt.TextField;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;  
import java.net.SocketException;  
import java.util.Calendar;  
  
import javax.swing.JOptionPane;  
  

class MySend{  
  
    public MySend() throws Exception {  
  
        DatagramSocket dSocket = new DatagramSocket(10000);  
        Calendar c = Calendar.getInstance();  
  
        byte[] buf = ("from IP:" + InetAddress.getLocalHost() + "\r\n" + MyEvent.myText)  
                .getBytes();  
  
        System.out.println("收到内容：" + MyEvent.myText);  
  
        DatagramPacket dPacket = new DatagramPacket(buf, buf.length,  
                InetAddress.getByName(MyEvent.myIp), 5656);// 自定义  
        //  
//         DatagramPacket dPacket1= new DatagramPacket(buf, buf.length,InetAddress.getByName("183.58.253.209"),8888);//本机测试  
//  
//        dSocket.send(dPacket1);  
//        dSocket.close();  
  
        // 显示自己发的信息  
        // ----------------本机显示测试------------------//  
        String date = "Time:" + c.get(Calendar.YEAR) + "年"  
                + (c.get(Calendar.MONTH) + 1) + "月"  
                + c.get(Calendar.DAY_OF_MONTH) + "日" + c.get(Calendar.HOUR)  
                + "时" + c.get(Calendar.MINUTE) + "分";  
  
        MyFrame.receField.append(date + "\r\nME:" + MyEvent.myText + "\r\n");  
        // MyFrame.receField.setText(date+"\r\n"+string);  
  
        // ----------------本机测试------------------//  
        // System.out.println(dPacket);  
  
    }  
}  
  

  

  

