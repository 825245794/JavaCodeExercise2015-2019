package LQB_2016;

public class NO6 {
	static int[][] a=new int[3][4];
	static int c=0;
	public NO6(){
		a[0][0]=-100;
		a[2][3]=-100;
		sort();
	}
	
	public void sort(){
		a[0][0]=-100;
		a[2][3]=-100;
		for(int i=100000000;i<=999999999;i++){
			for(int j=0;j<10;j++){
				String s=String.valueOf(i)+j;
				if(i<200000000)
				remain(s);
				if(containRepeatChar(s)==false){
					continue;
				}
						a[0][1]=Integer.parseInt(s.substring(0, 1));
						a[0][2]=Integer.parseInt(s.substring(1, 2));
						a[0][3]=Integer.parseInt(s.substring(2, 3));
						a[1][0]=Integer.parseInt(s.substring(3, 4));
						a[1][1]=Integer.parseInt(s.substring(4, 5));
						a[1][2]=Integer.parseInt(s.substring(5, 6));
						a[1][3]=Integer.parseInt(s.substring(6, 7));
						a[2][0]=Integer.parseInt(s.substring(7, 8));
						a[2][1]=Integer.parseInt(s.substring(8, 9));
						a[2][2]=Integer.parseInt(s.substring(9));
				cal(s);
			}
			
		}
		
	}
	
	public void remain(String s){
		s=s.substring(1);
		s="0"+s;
		if(containRepeatChar(s)==true){
					a[0][1]=Integer.parseInt(s.substring(0, 1));
					a[0][2]=Integer.parseInt(s.substring(1, 2));
					a[0][3]=Integer.parseInt(s.substring(2, 3));
					a[1][0]=Integer.parseInt(s.substring(3, 4));
					a[1][1]=Integer.parseInt(s.substring(4, 5));
					a[1][2]=Integer.parseInt(s.substring(5, 6));
					a[1][3]=Integer.parseInt(s.substring(6, 7));
					a[2][0]=Integer.parseInt(s.substring(7, 8));
					a[2][1]=Integer.parseInt(s.substring(8, 9));
					a[2][2]=Integer.parseInt(s.substring(9));
				cal(s);	
				}
		}
	
	 public static boolean containRepeatChar(String str){
	        if(str==null||str.isEmpty()){
	            return false;
	        }
	        char[] elements=str.toCharArray();    
	        for(char e:elements){
	            if(str.indexOf(e)!=str.lastIndexOf(e)){
	                return false;
	            }
	        }
	        return true;
	    }
	public boolean identify(){
	
		for(int x=0;x<3;x++){
			for(int y=0;y<4;y++){
				if((x==0||y==0)&&(x==2||y==3)){
					
					continue;
					}
				try{
					
					if(Math.abs(a[x][y]-a[x][y-1])==1){
						
						return false;
					}
				}catch(Exception e){}
				
				
				try{
					
					if(Math.abs(a[x][y]-a[x][y+1])==1){
					
						return false;
					}
				}catch(Exception e){}
				try{
				
					if(Math.abs(a[x][y]-a[x-1][y])==1){
						
						return false;
					}
				}catch(Exception e){}
			
				try{
					if(Math.abs(a[x][y]-a[x+1][y])==1){
						return false;
					}
				}catch(Exception e){}
				
				
				
			
				try{
					
					if(Math.abs(a[x][y]-a[x+1][y-1])==1){
						
						return false;
					}
				}catch(Exception e){}
				
				
				try{
					
					if(Math.abs(a[x][y]-a[x+1][y+1])==1){
					
						return false;
					}
				}catch(Exception e){}
				
				try{
				
					if(Math.abs(a[x][y]-a[x-1][y-1])==1){
						return false;
					}
				}catch(Exception e){}
				
				try{
				
					if(Math.abs(a[x][y]-a[x-1][y+1])==1){
						return false;
					}
				}catch(Exception e){}
			}
		}
		
		return true;
	}
	public void cal(String s){
		if(identify()==true){
			c++;
			//System.out.println(c+"   "+s);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NO6 a=new NO6();
		System.out.println(c);
	}

}
