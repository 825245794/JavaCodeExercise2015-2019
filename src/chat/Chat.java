package chat;

public class Chat {  
    public static void main(String[] args) {  
        new MyFrame();  
  
        new MyEvent();  
  
        Thread thread = new Thread(new MyRecevier());  
        thread.start();  
  
    }  
  
}  
  
