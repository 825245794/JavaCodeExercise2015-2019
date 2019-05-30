package LQB;

public class NOeight {
	  static int qian[]={1,6};
	  static int zhao[]={2,4};
	  static int sun[]={3,7};
	  static int li=5;
	  static int zhou[]={1,4,6};
	  static int wu[]={2,5};
	  static int chen[]={3,6,7};
	  static int total[]=new int[7];
	  
	  public static boolean f(int a){
		  for(int i=0;i<total.length;i++){
			  if(a==total[i]){
				  return false;
			  }
		  }
		  return true;
	  }
	  
	  public static void c(int a){
		  for(int i=a;i<total.length;i++){
			  total[i]=0;
		  }
	  }
	public static void main(String[] args) {
		System.out.println("李     钱     赵      孙     周     吴     陈");
		total[0]=li;
	   for(int i=0;i<qian.length;i++){
		   c(1);
		   if(f(qian[i])==true){
	    	total[1]=qian[i];
		   }
		   else{
			   continue;
		   }
		   for(int j=0;j<zhao.length;j++){
			   c(2);
			   if(f(zhao[i])==true){
		    	total[2]=zhao[j];
			   }
			   else{
				   continue;
			   }
			   for(int k=0;k<sun.length;k++){
				   c(3);
				   if(f(sun[k])==true){
			    	total[3]=sun[k];
				   }
				   else{
					   continue;
				   }
				   for(int l=0;l<zhou.length;l++){
					   c(4);
					   if(f(zhou[l])==true){
				    	total[4]=zhou[l];
					   }
					   else{
						   continue;
					   }
					   for(int s=0;s<wu.length;s++){
						   c(5);
						   if(f(wu[s])==true){
					    	total[5]=wu[s];
						   }
						   else{
							   continue;
						   }
						   for(int q=0;q<chen.length;q++){
							   c(6);
							   if(f(chen[q])==true){
						    	total[6]=chen[q];
						    	for(int p=0;p<total.length;p++){
						    		switch(total[p]){
						    		case 1:System.out.print("星期一 ");break;
						    		case 2:System.out.print("星期二 ");break;
						    		case 3:System.out.print("星期三 ");break;
						    		case 4:System.out.print("星期四 ");break;
						    		case 5:System.out.print("星期五 ");break;
						    		case 6:System.out.print("星期六 ");break;
						    		case 7:System.out.print("星期日 ");break;
						    		}
						    	
						    
						    	}
						    	System.out.println();
							   }
							   
						     }
					     }
				     }
			     }
		     }
	     }
	   }
	}