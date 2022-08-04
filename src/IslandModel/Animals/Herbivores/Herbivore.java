package IslandModel.Animals.Herbivores;

import IslandModel.Plants.Plant;

import java.util.List;

public interface Herbivore {

    void eatPlant(List<Plant> plants);

    Object multiplyHerbivore(List<Herbivore> predatorList);

}
