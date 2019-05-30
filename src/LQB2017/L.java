package LQB2017;

import java.util.Arrays;
import java.util.Scanner;

public class L {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        boolean f =true;
        int origin[] = new int[n];
        for(int i=0;i<origin.length;i++){
        	origin[i] = input.nextInt();
        }
        Arrays.sort(origin);
        if(k<n){
        	System.out.println(origin[k-1]);
        	f=false;
        }
        if(f){
        	System.out.println("-1");
        }
	}

}
