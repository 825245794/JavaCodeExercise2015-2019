package ex8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Savedata {
	int a[];
	int arr,i;
	public void setArr(int arr) {
		this.arr = arr;
	}
	
	public void input()
	{
		Scanner input=new Scanner(System.in);
		a=new int[arr];
		while(i!=arr)
		{
			System.out.println("NO."+(i+1));
			a[i]=input.nextInt();
			i++;
		}
		input.close();
	}
	public void Save()
	{
		input();
		String g="\r\n";
		byte[] h=g.getBytes();
		try {
			FileOutputStream f=new FileOutputStream("d:\\data.txt");
			for(int b:a)
			{
				String c ="";
				c+=b;
				System.out.println(c);
				byte[] d=c.getBytes();
				try {
					f.write(d);
					f.write(h);
					f.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Savedata a=new Savedata();
		a.setArr(5);
		a.Save();
	}

}
