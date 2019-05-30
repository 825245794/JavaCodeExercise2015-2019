package ex1;

import java.util.Scanner;

public class text_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int r=input.nextInt();
		input.close();
		double b=r*r*Math.PI;
		System.out.println(String.format("%.7f",b));
	}

}
