package comodinAnimal.main;
import java.util.ArrayList;
import java.util.List;

import comodinAnimal.accions.AnimalTrainer;
import comodinAnimal.animal.Animal;
import comodinAnimal.animal.Bird;
import comodinAnimal.animal.Cat;

public class AppComodin {
	
	public static void main(String[] args) {

		AnimalTrainer animalTrainer = new AnimalTrainer();
		
		//Test 1
		List<Animal> animalList = new ArrayList<>();
		animalList.add(new Cat("cat1"));
		animalList.add(new Bird("bird1"));
		
		animalTrainer.act(animalList);	//ok
		
		//Test 2
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		
		animalTrainer.act(catList);		//No se puede compilar
		/**
		 * No compila la utlima linea por el método creado en AnimalTrainer
		 * - public void act(List<Animal> list)
		 * ya que deberia ser.
		 * - public void act(List<? extends Animal> list)
		 * asi funcionaría.
		 */
		
		
		
		
	}

}
