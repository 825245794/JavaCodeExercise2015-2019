package ex11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Studentscore {

	/**
	 * @param args
	 */
	String name;
	int javascore;
	int cscore;
	public Studentscore()
	{
		Scanner scanner =new Scanner(System.in);
		System.out.println("name:");
		name=scanner.next();
		System.out.println("java score:");
		javascore=scanner.nextInt();
		System.out.println("C score:");
		cscore=scanner.nextInt();
		save("/Volumes/LJL/rename/chengji.txt");
	}
	
	public void save(String path)
	{
		String a="\r\n";
		String b="";
		try {
			FileWriter w=new FileWriter(path,true);
			b+="name:"+name+a+"java score:"+javascore+a+"C score:"+cscore+a;
			w.write(b);
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studentscore[] StudentInfo=new Studentscore[3];
		for(int i=0;i<StudentInfo.length;i++)
		StudentInfo[i]=new Studentscore();
			

	}

}
//D:\\chengji.txt