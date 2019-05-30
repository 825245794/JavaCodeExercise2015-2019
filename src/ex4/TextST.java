package ex4;

public class TextST {
	
public static void main(String[] args) {
	J_Human a=new J_Human();
	a=new J_Student();
    a.print();
	a=new J_Teacher();
	a.print();
	a.setName("Teacher100");
	a.print();
	}

}
