package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Calendar;

class MyRecevier implements Runnable {  
    Calendar c;  
  
    public MyRecevier() {  
        c = Calendar.getInstance();  
    }  
  
    @Override  
    public void run() {  
  
        DatagramSocket dSocket = null;  
  
        try {  
            dSocket = new DatagramSocket(5656);  
        } catch (SocketException e1) {  
            e1.printStackTrace();  
        }  
        ;  
  
        byte[] buf = new byte[1024];  
  
        DatagramPacket dPacket = new DatagramPacket(buf, buf.length);  
  
        while (true) {  
            try {  
                dSocket.receive(dPacket);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
  
            String string = new String(dPacket.getData(), 0,  
                    dPacket.getLength());  
  
            // ----------------本机显示测试------------------//  
            String date = "Time:" + c.get(Calendar.YEAR) + "年"  
                    + (c.get(Calendar.MONTH) + 1) + "月"  
                    + c.get(Calendar.DAY_OF_MONTH) + "日" + c.get(Calendar.HOUR)  
                    + "时" + c.get(Calendar.MINUTE) + "分";  
  
            MyFrame.receField.append(date + "\r\n" + string + "\r\n");  
            MyFrame.receField.setText(date+"\r\n"+string);  
  
            // ----------------本机测试------------------//  
  
        }  
  
        // dSocket.close();  
  
    }  
}  