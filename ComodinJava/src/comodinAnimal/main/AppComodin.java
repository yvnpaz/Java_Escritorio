package comodinAnimal.main;
import java.util.ArrayList;
import java.util.List;

import comodinAnimal.accions.AnimalTrainer;
import comodinAnimal.animal.Animal;
import comodinAnimal.animal.Bird;
import comodinAnimal.animal.Cat;
import comodinAnimal.animal.Magpie;

public class AppComodin {
	
	public static void main(String[] args) {

		AnimalTrainer animalTrainer = new AnimalTrainer();
		
		//Test 1
		List<Animal> animalList = new ArrayList<>();
		animalList.add(new Cat("cat1"));
		animalList.add(new Bird("bird1"));
		
		animalTrainer.act(animalList);	//Puede compilar
		
		//Test 2
		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		
		animalTrainer.act(catList);		//No se puede compilar
		
		
		
		
	}

}
