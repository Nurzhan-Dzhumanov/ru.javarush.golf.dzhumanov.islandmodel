package IslandModel.Animals.Herbivores;

import IslandModel.Animals.Animal;
import IslandModel.Animals.Predators.Predator;
import IslandModel.Location;
import IslandModel.Plants.Plant;

import java.util.List;
import java.util.Objects;

public class Duck extends Animal implements Herbivore, Predator {

    String typeOfAnimal = "Duck";

    @Override
    public Object multiplyHerbivore(List<Herbivore> predatorList) {
        return new Duck();
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
    public void eatMeat(Location[][] locations, int x, int y) {

    }

    @Override
    public void multiplyPredator(Location[][] locations, int x, int y) {

    }

    @Override
    public String toString() {
        return "\uD83E\uDD86-Duck";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return Objects.equals(typeOfAnimal, duck.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }
}
