package islandmodel.animals;

import islandmodel.animals.predators.Predator;
import islandmodel.Location;

import java.util.List;

public abstract class Animal {

    public abstract void directionOfMovement(Location[][] locations, int x, int y);

    public abstract Object dead(List<Predator> predatorList);

    public abstract List<?> menuAnimals();

}
