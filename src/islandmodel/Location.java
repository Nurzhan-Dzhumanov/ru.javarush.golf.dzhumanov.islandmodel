package islandmodel;

import islandmodel.animals.Animal;
import islandmodel.animals.herbivores.Duck;
import islandmodel.animals.herbivores.Herbivore;
import islandmodel.animals.herbivores.Horse;
import islandmodel.animals.herbivores.Sheep;
import islandmodel.animals.predators.Bear;
import islandmodel.animals.predators.Predator;
import islandmodel.animals.predators.Wolf;
import islandmodel.plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Location {

    Location() {
        addPredators(new Bear());
        addPredators(new Wolf());
        addPredators(new Duck());
        addHerbivores(new Horse());
        addHerbivores(new Sheep());

    }

    public List<Predator> predators = new ArrayList<>();
    public List<Herbivore> herbivores = new ArrayList<>();
    public List<Plant> plants = new ArrayList<>();

    public void calculate(Location[][] locations, int x, int y) {

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);

            // ЕДИМ
            predator.eatMeat(locations, x, y);

            // РАЗМНОЖАЕМСЯ
            predator.multiplyPredator(locations, x, y);

            // ДВИГАЕМСЯ
            Animal animal = (Animal) predator;
            animal.directionOfMovement(locations,  x, y);
        }

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            // ЕДИМ
            if (herbivore.equals(new Duck())) {
                Duck duck = (Duck) herbivore;
                duck.eatMeat(locations, x, y);
            }
            herbivore.eatPlant(plants);

            // РАЗМНОЖАЕМСЯ
            herbivore.multiplyHerbivore(herbivores);
            // ДВИГАЕМСЯ
            Animal animal = (Animal) herbivore;
            animal.directionOfMovement(locations, x, y);

        }
    }


    @Override
    public String toString() {
        return "Location - " +  predators.toString() + " " + herbivores.toString();
    }

    private void addPredators(Predator predator) {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            predators.add(predator);
        }
    }

    private void addHerbivores(Herbivore herbivore) {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            herbivores.add(herbivore);
        }
    }
}
