package ex1;

import java.util.Scanner;

public class text_3 {
		static String[]a;
		static int hang=0;
		static int lie=0;
		public static void sort(String j){
			String p="";
			for(int i=1;i<=lie-j.length();i++){
				p+=a[i];
			}
			
			p=j+p;
			if(p.length()<=lie){
			System.out.println(p);}else{
				p=p.substring(0,lie);
				System.out.println(p);
			}
				
			
		}
		public static void main(String args[]){
			Scanner input=new Scanner(System.in);
			hang=input.nextInt();
			lie=input.nextInt();
			a=new String[26];
			int p=65;
			for(int i=0;i<26;i++){
				a[i]=String.valueOf((char)p);
				p++;
			}
			int k=0;
			while(k!=hang){

				String j="";
				for(int i=k;i>-1;i--){
					j+=a[i];
				}
				k++;
				
				sort(j);
			}
			
			
			
		}
	}

