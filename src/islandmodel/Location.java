package islandmodel;

import islandmodel.animal.Animal;
import islandmodel.animal.herbivore.Duck;
import islandmodel.animal.herbivore.Herbivore;
import islandmodel.animal.herbivore.Horse;
import islandmodel.animal.herbivore.Sheep;
import islandmodel.animal.predator.Bear;
import islandmodel.animal.predator.Predator;
import islandmodel.animal.predator.Wolf;
import islandmodel.plant.*;

import java.util.ArrayList;
import java.util.List;

public class Location {

    Location() {
        addPredators(new Bear());
        addPredators(new Wolf());
        addPredators(new Duck());
        addHerbivores(new Duck());
        addHerbivores(new Horse());
        addHerbivores(new Sheep());
        addPlants(new Fruit());
        addPlants(new Herb());
        addPlants(new Leaf());
        addPlants(new Seed());

    }

    public List<Predator> predators = new ArrayList<>();
    public List<Herbivore> herbivores = new ArrayList<>();
    public List<Plant> plants = new ArrayList<>();

    public void calculate(Location[][] locations, int x, int y) {

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            Animal predatorAnimal = (Animal) predator;
            predatorAnimal.eat(locations, x, y);
            predatorAnimal.multiply(locations, x, y);
            predatorAnimal.directionOfMovement(locations, x, y);
            predatorAnimal.dead(locations, x, y);
        }

        for (int i = 0; i < herbivores.size(); i++) {
            Herbivore herbivore = herbivores.get(i);
            Animal herbivoreAnimal = (Animal) herbivore;
            herbivoreAnimal.eat(locations, x, y);
            herbivoreAnimal.multiply(locations, x, y);
            herbivoreAnimal.directionOfMovement(locations, x, y);
            herbivoreAnimal.dead(locations, x, y);
        }
    }

    @Override
    public String toString() {
        return "Location - " +  predators.toString() + " " + herbivores.toString();
    }

    private void addPredators(Predator predator) {
        int random = (int) (Math.random() * 8);
        for (int i = 0; i < random; i++) {
            predators.add(predator);
        }
    }

    private void addHerbivores(Herbivore herbivore) {
        int random = (int) (Math.random() * 5);
        for (int i = 0; i < random; i++) {
            herbivores.add(herbivore);
        }
    }

    private void addPlants(Plant plant) {
        int random = (int) (Math.random() * 5);
        for (int i = 0; i < random; i++) {
            plants.add(plant);
        }
    }
}
