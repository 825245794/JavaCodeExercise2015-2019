package ex7;
public class J_String {
	int length;
	String s="www.google.com";
	public int length()
		{
		length=s.length();
		return length;
		}
		
		public int  geto()
		{
			String s1=s.replaceAll("o", "");
			int replace=s1.length();
			return length-replace;

		}
		public int  getg()
		{
			String s2=s.replaceAll("g", "");
			int replace=s2.length();
			return length-replace;

		}
		public static void main (String args[])
		{
			J_String a=new J_String();
			System.out.println("�ַ����ĳ�����"+a.length());
			System.out.println("o������"+a.geto());
			System.out.println("g������"+a.getg());
			
		}
	}


