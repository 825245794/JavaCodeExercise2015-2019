package TEST;


import java.util.Scanner;

public class A33 {

	/**
	 * @param args
	 */
	Scanner input=new Scanner(System.in);
	int total=0;
	int record=0;
	String save[];
	String sentence;
	
	public A33(){
		start();
	}
	public void start(){
		System.out.print("Input: ");
		sentence=input.nextLine();
		for(int i=0;i<sentence.length();i++){
			String a=String.valueOf(sentence.charAt(i));
			//System.out.println(sentence);
			if(a.equals(" ")||a.equals("@")||a.equals("!")||a.equals(",")){
				total++;
				continue;
			}
			if(a.equals(".")||a.equals(",")){
				a=String.valueOf(sentence.charAt(i-1));
				if(a.equals(" "))
				total--;}
				else
					continue;
			
		}
		save=new String [total+20];
		for(int i=0;i<save.length;i++)
			{save[i]="";}
		//System.out.println("Total: "+(total+1));
		sort();
	}
	public void sort(){
		int j=0;
		for(int i=0;i<sentence.length();i++){
			String a=String.valueOf(sentence.charAt(i));
			if(a.equals(" ")){
				save[j]=sentence.substring(record, i);
				record=i+1;
				j++;
				continue;
			}
			else if(a.equals(",")||a.equals("@")||a.equals("!")){
				save[j]=sentence.substring(record, i);
				record=i+1;
				j++;
				save[j]=String.valueOf(sentence.charAt(i));
				record=i+1;
				j++;
//				String b=save[j];
//				save[j]=save[j-1];
//				save[j-1]=b;
				continue;
			}
			else if((a.equals(".")||a.equals("?")||a.equals("!"))&&i==sentence.length()-1){
				save[j]=sentence.substring(record,i);
				record=i;
				j++;
				save[j]=sentence.substring(i);
				record=i;
				j++;
				continue;
			}
			
			else if(i==sentence.length()-1){
				
				save[j]=sentence.substring(record);
				record=i;
				j++;
			}
		}
		reversal();
	}
	public void reversal(){
		for(int i=save.length-1;i>-1;i--){
			if(save[i].equals(""))
				continue;
			System.out.print(save[i]+" ");
		}
		input.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A33 a=new A33();
	}

}
