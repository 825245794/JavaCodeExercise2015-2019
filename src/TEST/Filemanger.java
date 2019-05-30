package TEST;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Filemanger {
	File[] file;
	FileOutputStream wr;
	FileInputStream re;
	File f;
	String path;
	
	public Filemanger(String path)
	{
		this.path=path;
		f=new File(path);
		file=f.listFiles();
		System.out.println("Filepath:"+path);
		System.out.println("help -h");
		int i=0;
		System.out.println("Num"+"\t"+"Files or Directory"+"\t"+"Name");
		for(File a:file)
		{
			System.out.println(+i+"\t"+"\t"+(a.isFile()?"F":"D")+"\t"+"\t"+a.getName());
		    i++;		
		}
		Input();
	}
	
	public void help()
	{
		System.out.println("Filemanger imformation:");
		System.out.println("-p[SystemPath]\t\tRePath");
		System.out.println("-r[Num]\t\t\tRenameFiles");
		System.out.println("-c[Num]\t\t\tCopyFiles");
		System.out.println("-d[Num]\t\t\tDeleteFiles");
		System.out.println("-x[Num]\t\t\tCutFiles");
		System.out.println("-o[Num]\t\t\tRun");
		System.out.println("-h\t\t\tGetHelp");
		Input();
	}
	public void Repath(String path)
	{
		new Filemanger(path);
	}
	
	public void Input()
	{
		System.out.print("Enter:");
		Scanner scanner=new Scanner(System.in);
		String a=scanner.next();
		try{
		String b=a.substring(0, 2);
		String c=a.substring(2);
		int i=Integer.parseInt(c);
		if(b.equals("-d"))
		{
			delete(i);
		}
		if(b.equals("-o"))
		{
			open(i);
		}
		if(b.equals("-c"))
		{
			copy(i);
		}
		if(b.equals("-r"))
		{
			Rename(i);
		}
		
		else
		{
			System.out.println("error");
			Input();
		}
		}catch(Exception e)
		{
		String b=a.substring(0, 2);
		String c=a.substring(2);
		try{
		if(b.equals("-p"))
		{
			Repath(c);
		}}
		catch(Exception d)
		{
			System.out.println("Path error");
		}
		if(b.equals("-h"))
		{
			help();
		}
		else
		{
			System.out.println("error");
			Input();
		}}
	}
	
	public void open(int i)
	{
		Runtime r=Runtime.getRuntime();
		Process p=null;
		try {
			r.exec(file[i].getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Rename(int i)
	{
		System.out.print("Enter new name:");
		Scanner scanner=new Scanner(System.in);
		String newname=scanner.next();
		String oldname=file[i].getName();
		if(!oldname.equals(newname)){ 
            File oldfile=new File(path+"/"+oldname); 
            File newfile=new File(path+"/"+newname); 
            if(!oldfile.exists()){
            	System.out.println("File not exists,try against");
            	new Filemanger(path);
            }
            if(newfile.exists())
            { System.out.println(newname+"has exists！"); 
            new Filemanger(path);}
            else{ 
                oldfile.renameTo(newfile); 
                System.out.println("Rename success");
                new Filemanger(path);
            } 
        }else{
            System.out.println("新文件名和旧文件名相同");
            new Filemanger(path);
        }
	}
	public void delete(int i)
	{
		file[i].deleteOnExit();
		System.out.println(file[i].getName()+" delete:"+file[i].delete());
		System.out.println();
		new Filemanger(path);
	}
	
	public void copy(int i)
	{
		System.out.println("Path:"+file[i].getPath());
		System.out.println("Filename:"+file[i].getName());
		System.out.println("Size:"+file[i].length()*0.0009766+"KB");
		System.out.print("TO Path:");
		Scanner scanner=new Scanner(System.in);
		String a=scanner.next();
		a+="/"+file[i].getName();
		if(file[i].isFile()){		
		try {
			wr=new FileOutputStream(a);
			re=new FileInputStream(file[i].getPath());
			FileInputStream t=new FileInputStream(file[i].getPath());
			FileReader r=new FileReader(file[i].getPath());
		    FileWriter w=new FileWriter(a,true);
//			FileOutputStream w=new FileOutputStream(a);
			float k=t.available();
			int q=0;
			System.out.println("Copying....");
			for(int j=r.read();j!=-1;j=r.read())
			{
				float d=(100-(t.available()/k*100));
			    if(q!=(int)d&&(int)d%10==0)
				{
				System.out.println("Finshed:"+(int)d+"%");
				q=(int)d;
				}
			    else
			    {
				w.write(j);
				w.flush();
			    }
			}
			System.out.println(file[i].getName()+": copy success");
			new Filemanger(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(file[i].getName()+": copy fail");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(file[i].getName()+": copy fail");
			e.printStackTrace();
		}
		}
		else
		{
				try {
					File n=new File(a);
					n.mkdir();
					File d=new File(file[i].getPath());
					File[] q=d.listFiles();
					for(File t:q)
					{
						if(t.isDirectory())
						{
						File m=new File(String.valueOf(a+"/"+t.getName()));
						m.mkdir();
						}
						else
						{
						FileWriter w=new FileWriter(a+"/"+t.getName());
						
						FileReader r=new FileReader(file[i].getPath()+"/"+t.getName());
						for(int j=r.read();j!=-1;j=r.read())
						{
							w.write((char)j);
							w.flush();
						}
						}
					}System.out.println(file[i].getName()+": copy success");
					new Filemanger(path); 
				}
				catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println(file[i].getName()+": copy fail");
						e1.printStackTrace();
					}		
					
		
			
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Filemanger a=new Filemanger("/Users/lujiale/documents");
	
	}

}


//FileInputStream r=new FileInputStream(file[i].getPath());
//FileOutputStream w=new FileOutputStream(a,true);
//FileReader r=new FileReader(file[i].getPath());
//FileWriter w=new FileWriter(a,true);
