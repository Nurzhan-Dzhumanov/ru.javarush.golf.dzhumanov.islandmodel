package IslandModel.Animals.Predators;

import IslandModel.Animals.Animal;
import IslandModel.Location;

import java.util.List;

public class Bear extends Animal implements Predator {

    @Override
    public void multiplyPredator(Location[][] locations, int x, int y) {

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
    public void eatMeat(Location[][] locations, int x, int y) {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3B-Bear";
    }
}
