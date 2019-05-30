package ex10;
import java.io.FileOutputStream;
import java.io.IOException;
public class Outputfile {
	int Layer,i,j,space,arr=0;
	
	String a[];
	public void setLayer(int layer) {
		Layer = layer;
	}
	
	public void Triangle()
	{
		a=new String[100*Layer];
		System.out.println(a.length);
		try{
		for(i=Layer;i>=1;i--){
			for(space=0;space<Layer-i;space++)
			{
				System.out.print(" ");
				a[arr]=" ";
				++arr;
			}
			for(j=i;j<=2*i-1;j++)
			{
				System.out.print("*");
				a[arr]="*";
				++arr;
			}
			for(j=0;j<i-1;j++)
			{
				System.out.print("*");
				a[arr]="*";
				++arr;
			}
				System.out.println();
				a[arr]="\r\n";
				++arr;
			
			
		}
		}
		catch(Exception e){
			System.out.print("error");
		}
		
	}
	
	public void Clearnull()
		{
			i=0;
			while(i!=a.length)
			{
			if(a[i]==null)
				a[i]="";
			    i++;
			}
		}

	public void Write()
	{
		Triangle();
		Clearnull();
		String d ="";
		try{
			FileOutputStream g=new FileOutputStream("d:\\triangle.txt");
			for(String c:a)
			{
				d+=c;	
			}
			byte[] b=d.getBytes();
			g.write(b);
			g.flush();
			g.close();
			}
		catch(IOException e)
		{
			System.err.print("IO error");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outputfile a=new Outputfile();
		a.setLayer(7);
		a.Write();
	}

}
//1-100-8-92
//2-200-13-187
//3-300-15-285
//4-400-14-386
//5-500-10-490



//a[arr]="\"";
//++arr;
//a[arr]="r";
//++arr;
//a[arr]="\"";
//++arr;
//a[arr]="n";
//++arr;
