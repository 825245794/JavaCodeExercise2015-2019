package LQBMONI;

import java.util.Arrays;

public class NO7 {
	private static int[] w={11, 8, 11, 16, 1, 2, 6, 10, 17, 10, 6, 5, 2, 19, 4, 7, 5, 5, 15, 3, 15, 11,  
            9, 17, 9, 4, 10, 12, 17, 19, 20, 11, 10, 20, 3 };  
	public static boolean dfs(int n,int wid,int k){
		if(wid==0){
			System.out.println(k);
			return true;
		}
		if(n==w.length||wid<0){return false;}
		for(int i=n;i<w.length;i++){
			if(dfs(i+1,wid-w[n],k+1)){
				return true;
			}
				
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.sort(w);
		dfs(0,100,0);
	}

}
