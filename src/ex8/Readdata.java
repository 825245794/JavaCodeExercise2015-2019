package ex8;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Readdata {
	int a,b;
	public void Read()
	{
		try {
			FileInputStream f=new FileInputStream("d:\\data.txt");
			for(a=f.read();a!=-1;a=f.read())
			{
			System.out.print((char)a);
//			b+=(char)a;
//			System.out.print(b);
			}
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Readdata a=new Readdata();
		a.Read();
		a.print();

	}

}
