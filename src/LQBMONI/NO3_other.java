package LQBMONI;

public class NO3_other {
	      
	    private static int n=9,c=0;  
	      
	    private static int[] a={1,2,3,4,5,6,7,8,9};  
	      
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        perm(0);  
	        System.out.println(c);  
	    }  
	      
	    private static void perm(int k) {  
	        // TODO Auto-generated method stub  
	          
	        if(k==n){  
	            if(judge()){  
	                c++;  
	            }  
	            return;  
	        }  
	          
	        for(int i=k;i<n;i++){  
	            swap(k, i);  
	            perm(k+1);  
	            swap(k, i);  
	        }  
	          
	    }  
	      
	    private static void swap(int x,int y){  
	        int t=a[x];  
	        a[x]=a[y];  
	        a[y]=t;  
	    }  
	      
	    //判断是否符合规则  
	    private static boolean judge(){  
	        int t=a[0]+a[1]+a[2];         
	        if(t!=a[3]+a[4]+a[5]  
	                ||t!=a[6]+a[7]+a[8]  
	                        ||t!=a[0]+a[3]+a[6]  
	                                ||t!=a[1]+a[4]+a[7]  
	                                        ||t!=a[2]+a[5]+a[8]  
	                        ){  
	            return false;  
	        }         
	        return true;  
	    }  
	  
	}  

