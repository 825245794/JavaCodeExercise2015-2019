package LQBMONI;

public class NO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int x=1;x<300;x++){
			for(int y=1;y<300;y++){
				for(int z=1;z<300;z++){
					if((11*x+13*y+17*z==2471)&&(13*x+17*y+11*z==2739)){
						System.out.println(x+y+z);
					}
				}
			}
		}
	}

}
