package IslandModel.Animals.Predators;

import IslandModel.Location;


public interface Predator {

    void eatMeat(Location[][] locations, int x, int y);

    void multiplyPredator(Location[][] locations, int x, int y);

}
