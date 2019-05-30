package bangumi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import sun.misc.BASE64Decoder;      
import sun.misc.BASE64Encoder;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;      
import java.io.ByteArrayOutputStream;
public class test_image {
	 static BASE64Encoder encoder = new sun.misc.BASE64Encoder();      
	    static BASE64Decoder decoder = new sun.misc.BASE64Decoder(); 
	    static String a="";
	    BufferedImage bi1l=null;
	    public test_image(){
	    	
	    }
	static  public String getImageBinary(){      
	        File f = new File("C:\\Users\\LJL\\Desktop\\2.jpg");             
	        BufferedImage bi;      
	        try {      
	            bi = ImageIO.read(f);      
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();      
	            ImageIO.write(bi, "jpg", baos);      
	            byte[] bytes = baos.toByteArray();      
	                  
	            return encoder.encodeBuffer(bytes).trim();      
	        } catch (IOException e) {      
	            JOptionPane.showMessageDialog(null, "Fetal Error code:505");
	        }      
	       
	        return null;      
	    }      
	 
	static public int read(){
		 int j=0;
		 int k=0;
		 try {
			FileInputStream r=new FileInputStream("C:\\Users\\LJL\\Desktop\\1.txt");
			for(int i=r.read();i!=-1;i=r.read())
			{
				k++;
				String b=String.valueOf((char)i);
				
				
				if(b.equals("A")){
					j++;
				}
				a+=(char)i;
			}
			byte[] b=a.getBytes();
			r.close();
			System.out.println(a);
		} catch (FileNotFoundException e) {
			return 0;
		} catch (IOException e) {
			return 0;
		}
		 
		// System.out.println(j);//3198
		 System.out.println(j);//3198
		 System.out.println(k);//70226
		 return j;
	 }
	 
	public void base64StringToImage(String base64String){      
	        try {      
	            byte[] bytes1 = decoder.decodeBuffer(base64String);      
	                  
	            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);      
	            BufferedImage bi1 =ImageIO.read(bais);      
	            File w2 = new File("C:\\Users\\LJL\\Desktop\\test.jpg");//可以是jpg,png,gif格式  
	          
	            //ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动      
	        } catch (IOException e) {      
	            e.printStackTrace();      
	        }      
	    }      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
		//System.out.println(getImageBinary());
		
	}

}
