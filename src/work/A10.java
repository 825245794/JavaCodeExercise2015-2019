/**  
* @Title: A10.java
* @Package work
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2018年4月6日 上午7:31:07
* @version V1.0  
*/
package work;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: A10
 * @Description:
 * @author LJL
 * @date 2018/04/06 07:31:07
 *
 */
public class A10 {  
    static Set<String> sc = new TreeSet<String>();
    public static void p(char[] a, int index)
    {  
      if (a == null || index < 0)  {
            return;  
      }
      
       if (index == (a.length - 1)){
           sc.add(Arrays.toString(a));
        
       }  
       
                                                                                                                                                                                             
        else {  
            for (int i = index; i < a.length; i++)
            {  
                char temp = a[i];  
                a[i] = a[index];  
               a[index] = temp;
               if(i!=index && a[index]==a[i]) 
                   continue;
               
               p(a, index + 1);
              
              temp = a[i];            
               a[i] = a[index];
              
               a[index] = temp;
               
  
            }          }  
      
    }  
  
    public static void main(String[] args) {  
        
        char [] a=  {'B','A','C'} ;    
        p(a, 0);   
        for(String str : sc){
            System.out.println(str);
        }
   }
  
}  
