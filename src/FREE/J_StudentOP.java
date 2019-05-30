package FREE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Student implements Serializable{
	static final long serialVersionUID = 14041002L;
	String name;
	int GradeC;
	int GradeJava;
	int average;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGradeC() {
		return GradeC;
	}
	public void setGradeC(int gradeC) {
		GradeC = gradeC;
	}
	public int getGradeJava() {
		return GradeJava;
	}
	public void setGradeJava(int gradeJava) {
		GradeJava = gradeJava;
	}
	public void average(){
		average=(GradeJava+GradeC)/2;
	}
	public int getAverage(){
		return average;
	}
	public String toString(){
		return "����: " + name+",C�ɼ�: " 
				+GradeC+",Java�ɼ�: " +GradeJava;
	}

}

public class J_StudentOP {
	ArrayList<Student> st=new ArrayList<Student>();


	
	public void inputStudents(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������ѧ������");
		try{
			int n=sc.nextInt();
			for(int i=0;i<n;i++){
				
			}
		}catch(Exception e){
			System.out.print(e);
		}

	}

	//��ѧ������д��ָ�����ļ���
	public void writeStudent(String file){
		ObjectOutputStream f_out=null;
		try{
			//���б�д���ļ�
		}catch(Exception ex){
			System.out.print(ex);
		}
	}
	
	//���ļ��ж�����������
	public ArrayList<Student> readStudents(String file) throws FileNotFoundException{
		ObjectInputStream f;

		try {
			//���ļ����ȡ��Ϣ���������д������б���
		} catch (Exception e) {
			System.out.print(e);
		}
		return st;   
	}

	//����ƽ���ɼ�
	public void averageStudent(){
		//����ƽ���ɼ�������С���к������
	}
	
	public void printStudent(){
		for (Student s:st){
			System.out.println(s);
		}
	}

}
