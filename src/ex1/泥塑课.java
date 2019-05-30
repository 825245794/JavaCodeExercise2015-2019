package ex1;

import java.util.Scanner;
import java.util.Vector;

public class 泥塑课 {
	 static Vector<Integer>  square = new Vector<Integer>();
	   static Vector<String>   name = new Vector<String>();
	   static Vector<String>   save = new Vector<String>();
	    static Vector<Integer>  count =new Vector<Integer>();
	   static  Vector<Integer>  cache_square =new Vector<Integer>();
	   static Vector<String>   cache_name = new Vector<String>();
	    static int count_max=0;
	   static  int count_min=0;
	   static  int max=0;
	    static int min=0;
	    static int k=0;
	    public static void main(String args[]){
	        Scanner input=new Scanner(System.in);
	        while(input.hasNext()){
	          int c=input.nextInt();
	          if(c==-1){
		            break;
		          }
	          count.add(c);
	         
	          for(int i=0;i<c;i++){
	          String infos=input.next();
	            String infoss=input.next();
	            String infosss=input.next();
	            String names=input.next();
	            int s=Integer.parseInt(infos)*Integer.parseInt(infoss)*Integer.parseInt(infosss);
	          // System.out.println(s);
	            square.add(s);
	            name.add(names);
	          
	          }
	        }
	      for(int i=0;i<count.size();i++){
	        count_max=k+count.get(i);
	        k+=count_max;
	        f(count_min,count_max);
	        count_min=count.get(i);
	      }
	       for(int i=0;i<save.size();i++){
	       System.out.println(save.get(i));
	      }
	    }
	    public static void f(int count_min,int count_max){
	    	//System.out.println("1");
	      max=square.get(count_min);
	      min=square.get(count_min);
	      int maxnum=0;
	      int minnum=0;
	      maxnum=count_min;
	      minnum=count_min;
	      for(int i=count_min;i<count_max;i++){
	        if(square.get(i)>max){
	           max=square.get(i);
	           maxnum=i;
	        }
	        if(square.get(i)<min){
	           min=square.get(i);
	           minnum=i;
	        }
	      }
	       save.add(name.get(maxnum)+" took clay from "+name.get(minnum)+".");
	       int j=(max-min)/2;
	       int lingshi=square.get(maxnum)-j;
	       square.setElementAt(lingshi,maxnum);
	       lingshi=square.get(minnum)+j;
	       square.setElementAt(lingshi,minnum);
	      // System.out.println(lingshi);
	 
	       for(int i=count_min;i<count_max;i++){
	         int p1=square.get(i);
	          if(lingshi!=p1){
	            f(count_min,count_max);
	          }
	          
	      }
	    }
}
