package ex1;

public class text_2 {
	
		public static boolean identify(String o){
			if(o.charAt(0)==o.charAt(3)&&o.charAt(2)==o.charAt(1)){
				return true;}
			return false;
		}
		public static void main(String args[]){
			
			for(int i=1000;i<2000;i++){
				String p=String.valueOf(i);
				p="0"+p.substring(1);
				if(identify(p)){
					System.out.println(p);
				}
			}
			
			for(int i=1000;i<10000;i++){
				String o=String.valueOf(i);
				if(identify(o)){
					System.out.println(o);
				}
				
			}
		}
	}


