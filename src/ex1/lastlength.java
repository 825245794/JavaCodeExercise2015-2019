package ex1;
import java.util.*;
public class lastlength {
	public static void main(String args[]){
		  Scanner input=new Scanner(System.in);
		   String a=input.nextLine();
		   String b = a;
		   int p=a.length();
		   System.out.println(p==a.length()?"Y":"N");
    if(a.lastIndexOf(" ")==-1){System.out.println(a.length());}
else{
		    while(a.length()-1==a.lastIndexOf(" ")){
		    	if(a.length()==1)break;
		      a=a.substring(0,a.lastIndexOf(" "));
    } 
		     a=a.substring(a.lastIndexOf(" ")+1);
		     System.out.println(p==b.length()?"Y":"N");
		     if(p==a.length())  System.out.println("null");
		     else
		    System.out.println(a.length());
		    
}
		  }
		  }


