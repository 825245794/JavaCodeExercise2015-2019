package ex7;

public class J_string_array {
	String a=("ABCD");
	char[] b=new char[4];
	public J_string_array()
	{
		
	}
	public void array()
	{
		for(int i=0;i<b.length;i++)
		{
			b[i]=a.charAt(i);
		}
	}
	public void print()
	{
		array();
		String s=b[0]+""+b[1]+b[2]+"";
		System.out.println(s);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J_string_array a=new J_string_array();
		a.print();
	}

}
