package web;
import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import org.apache.commons.httpclient.Cookie;

import org.apache.commons.httpclient.HttpClient;

import org.apache.commons.httpclient.NameValuePair;

import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.commons.httpclient.methods.PostMethod;

/**

* Http请求工具

*

*/

public class HttpUtil {

// 基础地址

public String URL_BASE = "http://jw.jluzh.com";

// 验证码地址

public static final String URL_CODE = "http://jw.jluzh.com/CheckCode.aspx";

// 登陆地址

public static final String URL_LOGIN = "http://jw.jluzh.com";

// 登录成功的首地址

public static final String URL_MAIN = "http://jw.jluzh.com/xs_main.aspx?xh=04151010";

public static final String URL_LOGIN2 = "Logon.do?method=logonBySSO";

public static final String URL_CJ = "xszqcjglAction.do?method=queryxscj";

public static final String imageFileName = "./CheckCode.aspx";

private static HttpClient client = new HttpClient();;

public static StringBuffer cookie = null;

public static File imageFile;

public HttpUtil() {

load();

codeImage();

}

public HttpUtil(String uRL_BASE) {

URL_BASE = uRL_BASE;

load();

codeImage();

}

public void load(){

//登录前获得cookie

GetMethod get = new GetMethod(URL_BASE);

//client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

cookie = new StringBuffer();

try {

client.executeMethod(get);

} catch (IOException e) {

e.printStackTrace();

}

Cookie[] cookies = client.getState().getCookies();

for(Cookie c:cookies){

cookie.append(c.toString());

}

}

public void codeImage(String rand){

GetMethod get = new GetMethod(URL_BASE + URL_CODE + rand);

get.setRequestHeader("Cookie", cookie.toString());

try {

client.executeMethod(get);

InputStream in = get.getResponseBodyAsStream();

imageFile = file_put_contents("./code.jpg",in);

} catch (IOException e) {

e.printStackTrace();

}

}

public void codeImage(){

GetMethod get = new GetMethod(URL_BASE + URL_CODE);

get.setRequestHeader("Cookie", cookie.toString());

try {

client.executeMethod(get);

InputStream in = get.getResponseBodyAsStream();

imageFile = file_put_contents("./code.jpg",in);

} catch (IOException e) {

e.printStackTrace();

}

}

public File file_put_contents(String file_name, InputStream is) {

File file = new File(file_name);

OutputStream os = null;

try {

os = new FileOutputStream(file);

byte buffer[] = new byte[4 * 1024];

int len = 0;

while ((len = is.read(buffer)) != -1) {

os.write(buffer, 0, len);

}

os.flush();

} catch (Exception e) {

e.printStackTrace();

} finally {

try {

os.close();

} catch (Exception e) {

e.printStackTrace();

}

}

return file;

}

public void login(String UserName, String PassWord, String Code) {

//第一次

PostMethod post = new PostMethod(URL_BASE + URL_LOGIN);

NameValuePair[] data = {

new NameValuePair("USERNAME",UserName),

new NameValuePair("PASSWORD",PassWord),

new NameValuePair("useDogCode",""),

new NameValuePair("useDogCode",""),

new NameValuePair("RANDOMCODE",Code),

new NameValuePair("x",+(int)(Math.random()*1000%62)+""),

new NameValuePair("y",+(int)(Math.random()*1000%22)+"")

};

post.setRequestHeader("Cookie",cookie.toString());

post.setRequestBody(data);

try {

client.executeMethod(post);

} catch (IOException e) {

e.printStackTrace();

}

try {

String text = post.getResponseBodyAsString();

if(!text.contains(URL_BASE + URL_MAIN))

{

System.out.println("登陆失败！");

return;

}else{

System.out.println("登陆成功！");

}

} catch (IOException e) {

e.printStackTrace();

}

//第二次

post = new PostMethod(URL_BASE + URL_LOGIN2);

post.setRequestHeader("Cookie",cookie.toString());

try {

client.executeMethod(post);

} catch (IOException e) {

e.printStackTrace();

}

}

public String chenji(){

String text = null;

PostMethod post = new PostMethod(URL_BASE + URL_CJ);

NameValuePair[] data = {

new NameValuePair("kksj",""),

new NameValuePair("kcxz",""),

new NameValuePair("kcmc",""),

new NameValuePair("xsfs","qbcj"),

new NameValuePair("ok","")

};

post.setRequestHeader("Cookie",cookie.toString());

post.setRequestBody(data);

try {

client.executeMethod(post);

} catch (IOException e) {

e.printStackTrace();

}

try {

text = post.getResponseBodyAsString();

} catch (IOException e) {

e.printStackTrace();

}

return text;

}

}