package tests;

import java.util.ArrayList;


public class MuscTests {

	public static void main(String[] args) {
		
		ArrayList<Dog> a = new ArrayList<Dog>();
		
		a.add(new Dog("Fido"));
		a.add(new Dog("Firulais"));
		a.add(new Dog("Manchas"));
		ArrayList<Dog> b = new ArrayList<Dog>(a);
		
		for(int i=0; i<a.size(); i++)
			System.out.println(a.get(i).getName());
		System.out.println();
		change(b);
		
		for(int i=0; i<a.size(); i++)
			System.out.println(a.get(i).getName());
		for(int i=0; i<b.size(); i++)
			System.out.println(b.get(i).getName());
	}
	
	public static void change(ArrayList<Dog> b){
		ArrayList c = b;
		b.get(1)
	}
	
}
class Dog{
		String name;
		Collar collar;
		
		public Dog(Dog d, String color){
			name = d.name;
			collar = new Collar(color);
		}
		
		public Dog(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

class Collar{
	String color;
	
	public Collar(String color){
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}