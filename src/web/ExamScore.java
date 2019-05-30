package web;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;  
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;  
import web.SalUtils;  
  
  
public class ExamScore implements Runnable{  
    private final static  String URL = "https://j.choyri.com/edu/score";  
    
    public static void main(String[] args) throws IOException {  
    	ExamScore es=new ExamScore();
        Thread thread=new Thread(es);
        thread.start(); 
    }  
    public void connection() throws UnsupportedEncodingException, IOException {  
    	try {
			SalUtils.ignoreSsl();
		} catch (Exception e) {
			e.printStackTrace();
		}  
    	URL url = new URL(URL);
    	URLConnection rulConnection = url.openConnection();
    	HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;   
    	httpUrlConnection.setRequestMethod("POST");    
    	httpUrlConnection.setRequestProperty("Accept", "*/*");   
    	httpUrlConnection.setDoOutput(true);       
    	httpUrlConnection.setDoInput(true);    
    	httpUrlConnection.setUseCaches(false);     
    	httpUrlConnection.setRequestProperty("Content-type", "application/json");    
    	httpUrlConnection.setRequestProperty("Connection", "keep-alive"); 
    	httpUrlConnection.setRequestProperty("Content-Length", "62"); 
    	httpUrlConnection.setRequestProperty("User-agent","Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_3 like Mac OS X) AppleWebKit/603.3.8 (KHTML, like Gecko) Mobile/14G60 MicroMessenger/6.6.1 NetType/4G Language/zh_HK"); 
    	httpUrlConnection.connect(); 
        DataOutputStream out = new DataOutputStream(httpUrlConnection.getOutputStream());  
        JSONObject obj = new JSONObject();  
        obj.element("id", "04151010");  
        obj.element("pwd", "A21210000+*");  
        obj.element("year", "2016");  
        obj.element("semester", "1");  
        out.write(obj.toString().getBytes("UTF-8"));  
        out.flush();  
        out.close();  
        InputStream inputStream = httpUrlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer buffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
       obj = JSONObject.fromObject(buffer.toString());
       bufferedReader.close();
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(df.format(new Date()));
       for(int i=0;i<obj.getJSONArray("data").size();i++){
    	  JSONObject json = new JSONObject();
    	  json = JSONObject.fromObject(obj.getJSONArray("data").getString(i).toString());
    	  System.out.printf("%-10s",json.getString("name"));
    	  System.out.printf(json.getString("score")+"\n");
      }
     System.out.println();
    }

	/*
	* Title: run
	* Description: 
	* @see java.lang.Runnable#run()
	*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				connection();
				Thread.sleep(60000);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			}
		}
	}
  
    
    
  
} 