package ex1;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class hello {

	public static void main(String[] args) {
		
		
	System.out.println("hello");
	String str=new String("abc");
	String str1="abc";
	String str2=new String("abc");
	System.out.println(str==str1);
	System.out.println(str==str2);
	System.out.println(str1==str2);
	System.out.println(str.equals(str1));
	javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 

	fsv.getHomeDirectory();     //这便是读取桌面路径的方法了   
	 
	System.out.println(fsv.getDefaultDirectory()); //这便是读取我的文档路径的方法 
	File f=new File(fsv.getDefaultDirectory()+"\\bagu_img\\");
	if(!f.exists()){
		f.mkdirs();
	}
	f.delete();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
