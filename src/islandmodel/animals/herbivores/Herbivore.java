package islandmodel.animals.herbivores;

import islandmodel.plants.Plant;

import java.util.List;

public interface Herbivore {

    void eatPlant(List<Plant> plants);

    Object multiplyHerbivore(List<Herbivore> predatorList);

}
