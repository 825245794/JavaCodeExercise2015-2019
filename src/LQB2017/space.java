/**  
* @Title: space.java
* @Package LQB2017
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2017年11月27日 下午3:54:55
* @version V1.0  
*/
package LQB2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: space
 * @Description:
 * @author LJL
 * @date 2017/11/27 15:54:55
 *
 */
public class space {
	static int j=0;
	static boolean f=true;
	static Set<String> set=new HashSet<String>();
	public static void f(String s1,String s[],int begin,int current[],int now,int total){
		if(now==0&&f==true){
			current[now]=begin;
			now++;
			f=false;
			f(s1,s,begin,current,now,total);
		}
		if(begin==s.length-1){
			if(now-1!=0){
				if(current[now-2]+1<s.length){
			current[now-1]=current[now-2]+1;
			f(s1,s,begin,current,now,total);}}
		}
		if(now==total){
			String s2="";
			int k=0;
			for(int i=0;i<s.length;i++){
				if(k<total&&i==current[k]){
					s2+=s[i]+" ";
					k++;
				}else{
					s2+=s[i];
				}
			}

			set.add(s2);
			if(total!=1){
				if(current[now-1]+1<s.length){
				current[now-1]=current[now-1]+1;
				//System.out.println(current[now-1]);
				f(s1,s,begin,current,now,total);}
				else{
					
				}
			}
		}else{
			current[now]=current[now-1]+1;
			now++;
			f(s1,s,begin,current,now,total);
		}
		
		
	}
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("输入字符串");
		System.out.println();
		String s1 = input.next();
		input.close();
		String s[] =new String[s1.length()];
        for(int i=0;i<s1.length();i++){
			s[i] = String.valueOf(s1.charAt(i));
		}
		for(int i=1;i<s1.length();i++){
			for(int k=0;k<s1.length();k++){
				j=k;
				f=true;
				f("",s, k, new int[i], 0,i);
			}
		}
		for(String s3:set){
			if(s3.indexOf(" ")!=-1&&!" ".equals(String.valueOf(s3.charAt(s3.length()-1)))){
				System.out.println(s3);
			}
		}
	}
}
