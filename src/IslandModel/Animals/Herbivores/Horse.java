package IslandModel.Animals.Herbivores;

import IslandModel.Animals.Animal;
import IslandModel.Animals.Predators.Predator;
import IslandModel.Location;
import IslandModel.Plants.Plant;

import java.util.List;

public class Horse extends Animal implements Herbivore {

    @Override
    public Object multiplyHerbivore(List<Herbivore> predatorList) {
        return new Horse();
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {

    }

    @Override
    public Object dead(List<Predator> predatorList) {
        return null;
    }

    @Override
    public List<?> menuAnimals() {
        return null;
    }

    @Override
    public void eatPlant(List<Plant> plants) {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC0E-Horse";
    }
}
