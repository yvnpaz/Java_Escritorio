package comodinAnimal.animal;

public class Magpie extends Bird {

	public Magpie(String name) {
		super(name);
	}
	
	public void sing(){
		System.out.println(getName() +" can not only eat,but sing");
	}
}
