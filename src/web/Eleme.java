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
  
  
public class Eleme implements Runnable{  
    private final static  String URL = "https://h5.ele.me/restapi/marketing/promotion/weixin/oEGLvjtwPd9N1zeQa2981HxLVtMQ";  
    
    public static void main(String[] args) throws IOException {  
    	Eleme es=new Eleme();
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
    	httpUrlConnection.setRequestProperty("User-agent","Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36 MicroMessenger/6.0.0.54_r849063.501 NetType/WIFI"); 
    	httpUrlConnection.connect(); 
        DataOutputStream out = new DataOutputStream(httpUrlConnection.getOutputStream());  
        JSONObject obj = new JSONObject();  
        obj.element("method", "phone");  
        obj.element("group_sn", "29ea8338cf2a545e");  
        obj.element("sign", "66b889b84fd483dce0525518db0c341b");  
        obj.element("phone", "");  
        obj.element("device_id", "");  
        obj.element("hardware_id", "");  
        obj.element("platform", "4");  
        obj.element("track_id", "undefined");  
        obj.element("weixin_avatar", "http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL574bGDoic7uyiaF5Nibx4uuWe3otKaA5aHZlZWl4NibWDVuqUDe26tv7JDe8a7rXZ2DfJrqb1w6qeBw/132");  
        obj.element("weixin_username", "慧怡Test1");  
        obj.element("unionid", "o_PVDuImUss31riuagvoP-B3_jTs");  
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
       System.out.println(obj.toString());
//       for(int i=0;i<obj.getJSONArray("data").size();i++){
//    	  JSONObject json = new JSONObject();
//    	  json = JSONObject.fromObject(obj.getJSONArray("data").getString(i).toString());
//    	  System.out.printf("%-10s",json.getString("name"));
//    	  System.out.printf(json.getString("score")+"\n");
//      }
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