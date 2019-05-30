package LQB;

import java.util.Scanner;
import java.util.Vector;

public class NOseven {
	static Scanner input=new Scanner(System.in);
	static Vector<String> v=new Vector<String>();
	static Vector<Integer> num=new Vector<Integer>();
	static int a=input.nextInt();
	static String b[]=new String[a];
	static int index=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.length;i++){
			b[i]=input.next();
		}
		for(int i=0;i<b.length;i++){
			String text=b[i];
			while(!text.equals("-1")){
				if(text.length()>=6){	
					v.add(text.substring(0, 6));
					//System.out.println(text);
					text=text.substring(6);
					
			}
				else{
					v.add(text.substring(0,text.length()));
					//System.out.println(text);
					text="-1";
					
				}
			}
			for(int j=0;j<v.size();j++){
				String s=v.get(j);
				//System.out.println(s);
				if(index==0){
					for(int k=0;k<s.length();k++){
						num.add(Integer.parseInt(String.valueOf((int)s.charAt(k))));	
						index++;
					}
				}
				else{
					int p=0;
					for(int k=0;k<s.length();k++){
						
						 p=num.get(k)+Integer.parseInt(String.valueOf((int)s.charAt(k)));
					
						num.set(k,p);
					}
				}
			}
			for(int d=0;d<num.size();d++){
				String f=String.valueOf(num.get(d));
				int g=num.get(d);
				//System.out.println(g);
				while(f.length()!=1){
					g=0;
					for(int l=0;l<f.length();l++){
						if(l==f.length()-1){
							g=g+Integer.parseInt(f.substring(l));
						}
						else{
						g=g+Integer.parseInt(f.substring(l,l+1));
						}
					}
					//System.out.println(g1);
					f=String.valueOf(g);
				}
				num.set(d, Integer.parseInt(f));
			}
			for(int u=0;u<num.size();u++){
				System.out.print(num.get(u));
			}
			System.out.println();
			num.removeAllElements();
			v.removeAllElements();
			index=0;}
	}

}
