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

public class Get {
   static Connection con;
   Response rs;
   Map<String, String> datas;
  public static void main(String[] args) throws Exception {
    Get jli=new Get();
  jli.loginfirst();
   
  }

//获取img标签正则  
  public void loginfirst() throws Exception{
	   con=Jsoup.connect("http://www.cengfan8.com/y/");//获取连接
	   
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

     Connection con2;
     Response login;
    		 con2=Jsoup.connect("http://bangumi.bilibili.com/anime/timeline");
    // con2=Jsoup.connect("http://www.cengfan8.com/ajax.php?code="+i+"&typename=1");
    con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
     //设置cookie和post上面的map数据
 	  login=con2.ignoreContentType(false).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
 	   //打印，登陆成功后的信息
 	 System.out.println(login.body());
 	 String index = null;
 	  String body=String.valueOf(login.body());
 	   int begin=body.indexOf("<p>");
 	   if(begin==-1){
 		
 	  }
 	 int end=body.indexOf("			</ul>");
 	  if(begin!=-1){
 	 index=body.substring(begin+3,end);
 	body=body.substring(begin+3,end);
 		 System.out.println(index);
 		  
 	  }
 	 end=body.indexOf("</p>");
 	index=body.substring(0,end);
 	body=body.substring(end+7);
 	 System.out.println(index);
 	 index=index.substring(end);
 
 	end=body.indexOf("</p>");
 	index=body.substring(0,end);
 	body=body.substring(end+7);
 	 System.out.println(index);
 	 index=index.substring(end);
 	 
 	end=body.indexOf("</p>");
 	index=body.substring(0,end);
 	 System.out.println(index);
 	 index=index.substring(end);
     }

  }
  
  
  
  

  
