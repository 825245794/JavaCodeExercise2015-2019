package chat;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame {  
	  
    Frame frame;  
    static Button btnSend, btnRecord, btnCancel, btnPost;  
    static TextArea inputField, recordField, receField;  
    static TextField ipField;  
  
    MyFrame() {  
        frame = new Frame("IP聊天");  
        frame.setSize(960, 540);  
        frame.setLayout(null);  
        frame.setLocation(400, 150);  
        frame.setResizable(false);  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
        frame.setVisible(true);  
        frame.setBackground(Color.gray);  
  
        InputFrame();  
    }  
  
    public void InputFrame() {  
        Label label1 = new Label();  
        Label label2 = new Label("Input IP:");  
        label1.setBounds(5, 10, 460, 200);  
        label2.setBounds(8, 465, 80, 30);  
  
        ipField = new TextField();  
        ipField.setBounds(85, 467, 148, 25);  
  
        inputField = new TextArea("", 5, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);  
        recordField = new TextArea("", 5, 10, TextArea.SCROLLBARS_NONE);  
        receField = new TextArea("", 5, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);  
  
        inputField.setBounds(5, 320, 420, 140);  
        inputField.setBackground(Color.cyan);  
        recordField.setBounds(430, 30, 165, 430);  
        recordField.setBackground(Color.cyan);  
        receField.setBounds(5, 30, 420, 285);  
        receField.setBackground(Color.cyan);  
  
        inputField.setFocusable(true);  
        receField.setFocusable(false);  
        recordField.setFocusable(false);  
  
        ipField.setFont(new Font("Monospaced", Font.BOLD, 15));  
        inputField.setFont(new Font("Monospaced", Font.BOLD, 25));  
        receField.setFont(new Font("Monospaced", Font.BOLD, 18));  
        recordField.setFont(new Font("Monospaced", Font.BOLD, 15));  
  
        btnCancel = new Button("Cancel");  
        btnSend = new Button("Send");  
        btnRecord = new Button("Refresh");  
        btnPost = new Button("Post");  
  
        btnCancel.setBounds(295, 465, 60, 30);  
        btnSend.setBounds(360, 465, 60, 30);  
        btnRecord.setBounds(435, 465, 80, 30);  
        btnPost.setBounds(240, 465, 50, 30);  
  
        frame.add(inputField);  
        // frame.add(recordField);  
        frame.add(receField);  
        frame.add(btnCancel);  
        frame.add(btnSend);  
        //frame.add(btnRecord);  
        frame.add(btnPost);  
        frame.add(label1);  
        frame.add(label2);  
        frame.add(ipField);  
  
    }  
  
} 