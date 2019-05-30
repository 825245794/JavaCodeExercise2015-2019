package TEST;

import java.util.Arrays;
import java.util.Scanner;

public class A9 {

	/**
	 * @param args
	 */
	Scanner input=new Scanner(System.in);
	String before;
	int  before_array[];
	String after;
	int  after_array[];
	String TF="True";
	public A9(){
		start();
	}
	public void start(){
		System.out.print("Input 1:");
		before=input.nextLine();
		before_array=new int[before.length()];
		
		System.out.print("Input 2:");
		after=input.nextLine();
		after_array=new int[before.length()];
		
		if(after.length()==before.length()){
			sort();
		}
		else{
			System.out.println("False");
		}
	}
	public void sort(){
		for(int i=0;i<before.length();i++){
			before_array[i]=(int)before.charAt(i);
			after_array[i]=(int)after.charAt(i);
		}
		Arrays.sort(before_array);
		Arrays.sort(after_array);
		compare();
	}
	public void compare(){
		for(int i=0;i<before_array.length;i++){
			if(before_array[i]==after_array[i]){
				continue;
			}
			else{
				TF="False";
				break;
			}
		}
		System.out.println(TF);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A9 a=new A9();
	}

}
