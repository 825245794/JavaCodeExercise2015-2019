package LQBMONI;

import java.util.Scanner;
import java.util.Vector;

public class NO8 {
	static Vector<String> insert_name=new Vector<String>();
	static Vector<String> insert_score=new Vector<String>();
	public static void insert(String name,String score){
		for(int i=0;i<insert_name.size();i++){
			if(insert_name.get(i).equals(name)){
				if(Integer.parseInt(insert_score.get(i))<=Integer.parseInt(score)){
					insert_score.set(i, score);
				}
				return;
			}
		}
		insert_name.add(name);
		insert_score.add(score);
	}
	public static String find(String name){
		for(int i=0;i<insert_name.size();i++){
			if(insert_name.get(i).equals(name)){
				return insert_score.get(i);
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		String o="";
		String s="";
		while(o.equals("end")==false){
			o=input.nextLine();
			if(o.indexOf("insert")!=-1){
				o=o.substring(7);
				int a=o.indexOf(" ");
				String name=o.substring(0, a);
				String score=o.substring(a+1);
				insert(name,score);
			}
			if(o.indexOf("find")!=-1){
				o=o.substring(5);
				if(find(o)!=null)
				s+=find(o)+"\n";
				else s+="-1"+"\n";
			}
		}
		System.out.print(s);
	}

}
