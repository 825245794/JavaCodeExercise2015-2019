package ex1;

public class Tom {
 private float weight;
private static String name;
public float getWeight() {
	return weight;
}

public void setWeight(float weight) {
	this.weight = weight;
}
public void out(){
	System.out.println(weight);
}
public static void main(String[] args) {
	Tom.name=":TOM";
	Tom cat=new Tom();
	cat.setWeight(20);
	cat.out();
}
}
