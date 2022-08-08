package islandmodel.animals;

import islandmodel.Location;

import java.util.List;

public abstract class Animal {

    public abstract void directionOfMovement(Location[][] locations, int x, int y);

    public abstract void dead(Location[][] locations, int x, int y);

    public abstract List<?> menuAnimals();

}
