package LQB2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int a = input.nextInt();
		int max = 0;
		//StringBuffer sb =new StringBuffer();

		List<String> s = new ArrayList<String>();
		List<Integer> j = new ArrayList<Integer>();
		for(int i=0;i<a;i++){
			//String s1 = input.next();
			s.add(input.next());
			j.add(0);
			//s1[i]=sb.append(s[i]).reverse().toString();
			//sb.delete(0,sb.length());
		}
		for(int i=0;i<s.size();i++){
			if(j.get(i)==1) continue;
			for(int k=0;k<s.size();k++){
				if(j.get(k)==1) continue;
				if(i==k) continue;
				if(s.get(i).equals(new StringBuffer(s.get(k)).reverse().toString())){
					max++;
					j.set(i, 1);
					j.set(k, 1);
					//sb.delete(0, sb.length());
				}
			}
		}
        System.out.println(max);
	}

}
