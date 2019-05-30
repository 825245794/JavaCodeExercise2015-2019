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

public class Lingqu {
   static String path = "/Users/LJL/Desktop/img/"; 
   static Connection con;
   Response rs;
   Map<String, String> datas;
  public static void main(String[] args)throws Exception {
    
    Lingqu jli=new Lingqu();
  jli.loginfirst();
  

   //输入的用户名，和密码
   
  }
  /**
   * 模拟登陆
   * 
   * @param userName 用户名
   * @param pwd 密码
 * @throws Exception 
   * 
   * **/
//获取img标签正则  
  public void loginfirst() throws Exception{
	   con=Jsoup.connect("http://www.cengfan8.com/i/");//获取连接
    //第一次请求
	  con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//配置模拟浏览器
       rs= con.execute();//获取响应
        Document d1=Jsoup.parse(rs.body());//转换为Dom树
 	    List<Element> et= d1.select("form");//获取form表单，可以通过查看页面源码代码得知
 	    
 	   //获取，cooking和表单属性，下面map存放post时的数据 
 	  datas=new HashMap<>();
     for(Element e:et.get(0).getAllElements()){
       if(e.attr("placeholder").equals("领取码")){
         e.attr("value","223366");//设置用户名
       }
       
       if(e.attr("name").length()>0){//排除空值表单属性
         datas.put(e.attr("name"), e.attr("value"));  
       }
       
     }
     login();
  }
  public void login()throws Exception{
	
     
     
     /**
      * 第二次请求，post表单数据，以及cookie信息
      * 
      * **/
     Connection con2;
     Response login;
     for(int i=10000;i<10000;i++){
    	 
    		con2=Jsoup.connect("http://bangumi.tv/calendar");
   con2=Jsoup.connect("http://www.cengfan8.com/ajax.php?code="+i+"&typename=3");
    con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
     //设置cookie和post上面的map数据
 	  login=con2.ignoreContentType(false).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
 	   //打印，登陆成功后的信息
 	 System.out.println(login.body());
 	  String body=String.valueOf(login.body());
 	   int begin=body.indexOf("\uff1a");
 	   if(begin==-1){
 		continue;
 	  }
 	 
 	  if(begin!=-1){
 		  String index;
 	  int end=body.indexOf("\\u");
 	 index=body.substring(begin,end);
 		 System.out.println(index);
 		  body=body.substring(body.length()-25);
 	  begin=body.indexOf("\uff1a");
	   end=body.indexOf("}")-1;
 	index=body.substring(begin, end);
 	break;
 	  }
 	 
 	
     }
// 	   //登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
// 	   Map<String, String> map=login.cookies();
// 	   for(String s:map.keySet()){
// 		   System.out.println(s+"      "+map.get(s));
// 	   }
 	
  }
  
  
  
  

  
}