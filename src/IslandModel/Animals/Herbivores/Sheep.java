package IslandModel.Animals.Herbivores;

import IslandModel.Animals.Animal;
import IslandModel.Animals.Predators.Predator;
import IslandModel.Location;
import IslandModel.Plants.Plant;

import java.util.List;
import java.util.Objects;

public class Sheep extends Animal implements Herbivore {

    String typeOfAnimal = "Sheep";

    @Override
    public Object multiplyHerbivore(List<Herbivore> predatorList) {
        return null;
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
        return "\uD83D\uDC11-Sheep";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(typeOfAnimal, sheep.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }
}
