package LQB;

import java.util.Scanner;

public class sixtoeight {
	static String[][]sixteen=new String[2][16];
	static String[][]eight=new String[2][16];
	static void sixteen(){
		int a=0;
		int p=0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++){
					for(int l=0;l<2;l++){
						sixteen[1][a]=String.valueOf(i)+String.valueOf(j)+String.valueOf(k)+String.valueOf(l);
						if(p==10){sixteen[0][a]="A"; p++; a++; continue;}
						if(p==11){sixteen[0][a]="B"; p++; a++; continue;}
						if(p==12){sixteen[0][a]="C"; p++; a++; continue;}
						if(p==13){sixteen[0][a]="D"; p++; a++; continue;}
						if(p==14){sixteen[0][a]="E"; p++; a++; continue;}
						if(p==15){sixteen[0][a]="F"; p++; a++; continue;}
						sixteen[0][a]=String.valueOf(p);
						p++;
						a++;
					}
				}
			}
		}
	}
	
	static void eight(){
		int a=0;
		int p=0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<2;k++){
						eight[1][a]=String.valueOf(i)+String.valueOf(j)+String.valueOf(k);
						eight[0][a]=String.valueOf(p);
						p++;
						a++;
				}
			}
		}
	}
	static public void sort(String d){
		String q="";
		try{
		for(int i=d.length();i>0;){
			if(i==0){break;};
			if(i<2){d="0"+d;};
			if(i<3){d="0"+d;};
			for(int j=0;j<8;j++){
				if(eight[1][j].equals(d.substring(i-3))){
					//System.out.println(d.substring(i-3));
					q+=eight[0][j];
				}
			}
			d=d.substring(0,i-3);
			i=d.length();
			
		}}catch(Exception e){}
		
		for(int i=q.length()-1;i>-1;i--){
			if(i==q.length()-1){
				if(q.charAt(i)=='0')continue;
			}
			System.out.print(q.charAt(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sixteen();
		eight();
		Scanner input=new Scanner(System.in);
		int o=input.nextInt();
		String[] a=new String[o];
		String d="";
		for(int i=0;i<a.length;i++){
			a[i]=input.next();
		}
		for(int i=0;i<a.length;i++){
			String s=a[i];
			for(int j=0;j<s.length();j++){
				if(String.valueOf(s.charAt(j)).equals("A")){d+=sixteen[1][10];continue;};
				if(String.valueOf(s.charAt(j)).equals("B")){d+=sixteen[1][11];continue;};
				if(String.valueOf(s.charAt(j)).equals("C")){d+=sixteen[1][12];continue;};
				if(String.valueOf(s.charAt(j)).equals("D")){d+=sixteen[1][13];continue;};
				if(String.valueOf(s.charAt(j)).equals("E")){d+=sixteen[1][14];continue;};
				if(String.valueOf(s.charAt(j)).equals("F")){d+=sixteen[1][15];continue;};
				d+=sixteen[1][Integer.parseInt(String.valueOf(s.charAt(j)))];
			}
			sort(d);
			d="";
		}
	}

}
