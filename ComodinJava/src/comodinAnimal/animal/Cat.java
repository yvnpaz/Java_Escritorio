package comodinAnimal.animal;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
	
	public void jump(){
		System.out.println(getName() + " can jump.");
	}
}
