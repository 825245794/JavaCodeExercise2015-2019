package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * 使用Jsoup模拟登陆Iteye
 * 
 * 
 * 大体思路如下:
 * 
 * 第一次请求登陆页面，获取页面信息，包含表单信息，和cookie（这个很重要），拿不到，会模拟登陆不上
 * 
 * 
 * 第二次登陆，设置用户名，密码，把第一次的cooking，放进去，即可
 * 
 * 怎么确定是否登陆成功？
 * 
 * 登陆后，打印页面，会看见欢迎xxx，即可证明
 * 
 * 
 * @date 2014年6月27日
 * @author qindongliang
 * 
 * 
 * **/

public class jsouptest {
   static String path = "/Users/LJL/Desktop/img/"; 
   static Connection con;
   
  
  public static void main(String[] args)throws Exception {
    
    jsouptest jli=new jsouptest();
    con=Jsoup.connect("http://www.cengfan8.com/y/");//获取连接
                         /*把要下载的图片存档在img文件夹下*/
    File dir = new File(path);
    if(!dir.exists())
         dir.mkdir();                                                /*如果目录不存在则创建目录*/
    path +="CheckCode.aspx";
    jli.download("http://jw.jluzh.com/CheckCode.aspx",path);
   

   //输入的用户名，和密码
   
  }
  /**
   * 模拟登陆
   * 
   * @param userName 用户名
   * @param pwd 密码
   * 
   * **/
//获取img标签正则  
  private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";  
  public void connect(){
	   
    
  }
  public void login(String userName,String pwd,String code)throws Exception{
    
    //第一次请求
	  con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//配置模拟浏览器
        Response rs= con.execute();//获取响应
        Document d1=Jsoup.parse(rs.body());//转换为Dom树
 	    List<Element> et= d1.select("#form1");//获取form表单，可以通过查看页面源码代码得知
 	    
 	   //获取，cooking和表单属性，下面map存放post时的数据 
       Map<String, String> datas=new HashMap<>();
     for(Element e:et.get(0).getAllElements()){
       if(e.attr("id").equals("txtUserName")){
         e.attr("value", userName);//设置用户名
       }
       
       if(e.attr("id").equals("TextBox2")){
         e.attr("value",pwd); //设置用户密码
       }
      
       if(e.attr("id").equals("txtSecretCode")){
           e.attr("value",code); //设置验证码
         }
       
       if(e.attr("name").length()>0){//排除空值表单属性
         datas.put(e.attr("name"), e.attr("value"));  
       }
     }
 	    
     
     /**
      * 第二次请求，post表单数据，以及cookie信息
      * 
      * **/
   // Connection con2=Jsoup.connect("http://jw.jluzh.com");
    // con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
     //设置cookie和post上面的map数据
 	   Response login=con.ignoreContentType(false).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
 	   //打印，登陆成功后的信息
 	   System.out.println(login.body());
 	   
 	   //登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
 	   Map<String, String> map=login.cookies();
 	   for(String s:map.keySet()){
 		   System.out.println(s+"      "+map.get(s));
 	   }
 	
  }
  
  
  
  public void download(String strUrl,String path){
      URL url = null;
      try {
             url = new URL(strUrl);
      } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return;
      }


      InputStream is = null;
       try {
           is = url.openStream();
       } catch (IOException e1) {
           e1.printStackTrace();
           return;
       }


       OutputStream os = null;
       try{
           os = new FileOutputStream(path);
           int bytesRead = 0;
           byte[] buffer = new byte[8192];
           while((bytesRead = is.read(buffer,0,8192))!=-1){               /*buffer数组存放读取的字节，如果因为流位于文件末尾而没有可用的字节，则返回值-1，以整数形式返回实际读取的字节数*/
           os.write(buffer,0,bytesRead);
      }
      }catch(FileNotFoundException e){
          e.printStackTrace();
          return;
      } catch (IOException e) {
          e.printStackTrace();
          return;
     }
       try {
    	   Scanner input=new Scanner(System.in);
           String code=input.next().trim();
           login("04151010", "A21210000+*",code);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
  private List<String> getImageUrl(String HTML) {  
      Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);  
      List<String> listImgUrl = new ArrayList<String>();  
      while (matcher.find()) {  
          listImgUrl.add(matcher.group());  
      }  
      return listImgUrl;  
  }  

  
}