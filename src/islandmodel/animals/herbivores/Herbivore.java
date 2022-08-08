package islandmodel.animals.herbivores;

import islandmodel.Location;

public interface Herbivore {

    void eatPlant(Location[][] locations, int x, int y);

    void multiplyHerbivore(Location[][] locations, int x, int y);

}
