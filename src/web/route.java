package web;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class route {
public static String executeCmd(String strCmd) throws Exception {
Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
StringBuilder sbCmd = new StringBuilder();
BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GB2312"));//这里很重要，设置GB2312解决乱码！！！
//我NetBeans默认用UTF8
String line;
while ((line = br.readLine()) != null) {
sbCmd.append(line + "\n");
}
InputStream in = p.getInputStream();
byte[] b = new byte[1000];
in.read(b);
String msg =new String(b);;//用GB2312解释这堆字节，就可以组装成一个正常的String了
//如果上边不写GB2312，等于这里用UTF8组装，结果一样
return sbCmd.toString();


}
public static boolean connAdsl(String adslTitle, String adslName, String adslPass) throws Exception {
System.out.println("正在建立连接");
String adslCmd = "rasdial " + adslTitle + " " + adslName + " "
+ adslPass;
String tempCmd = executeCmd(adslCmd);
// 判断是否连接成功
if (tempCmd.indexOf("已连接") > 0) {
System.out.println("已成功建立连接.");
return true;
} else {
System.err.println(tempCmd);
System.err.println("建立连接失败");
return false;
}
}
public static boolean cutAdsl(String adslTitle) throws Exception {
String cutAdsl = "rasdial " + adslTitle + " /disconnect";
String result = executeCmd(cutAdsl);
if (result.indexOf("没有连接")!=-1){
System.err.println(adslTitle + "连接不存在!");
return false;
} else {
System.out.println("连接已断开");
return true;
}
}
public static void main(String[] args) throws Exception {
connAdsl("宽带","75620152067@jluzh.gd","03304514");
//Thread.sleep(1000);
//cutAdsl("宽带");
//Thread.sleep(1000);
////再连，分配一个新的IP
//connAdsl("宽带","hzhz**********","******");
}
}