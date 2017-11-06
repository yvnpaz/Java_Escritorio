package comodinAnimal.accions;

import java.util.List;

import comodinAnimal.animal.Animal;
import comodinAnimal.animal.Bird;
import comodinAnimal.animal.Cat;
import comodinAnimal.animal.Magpie;

public class AnimalTrainer {
	public void act(List<? extends Animal> list) {
		for (Animal animal : list) {
			animal.eat();
		}
	}
	
	/*
	 * Da error: una lista no sabe que es algo que extiende de animal.
	 */
//	public void testAdd(List<? extends Animal> list){
//		list.add(new Cat("Cat"));
//	}
	
	public void testAddBird(List<? super Bird> list){
		list.add(new Bird("bird"));
		list.add(new Magpie("magpie"));
	}
	
}
