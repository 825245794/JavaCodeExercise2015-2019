package ex1;

import ex1.testin.CanCry;

public class Animal {
	void makecry(CanCry c)
	{
		c.cry();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog a=new Dog();
		Cat b=new Cat();
		Animal c=new Animal();
			c.makecry(a);
			c.makecry(b);
	}

}
