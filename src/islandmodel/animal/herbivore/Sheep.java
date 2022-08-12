package islandmodel.animal.herbivore;

import islandmodel.animal.Animal;
import islandmodel.Location;
import islandmodel.plant.Fruit;
import islandmodel.plant.Herb;
import islandmodel.plant.Leaf;
import islandmodel.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sheep extends Animal implements Herbivore {

    public static int count = 0;
    public static final int MAX_WEIGHT_ANIMAL = 70;
    int foodForSatiety = (int) (Math.random() * getMaxFoodEat());
    public String typeOfAnimal = "Sheep";

    public Sheep() {
        count++;
    }

    @Override
    public List<?> getAnimalList(Location[][] locations, int x, int y) {
        return locations[x][y].herbivores;
    }

    @Override
    public List<?> getAnimalMenu() {
        List<Plant> menuSheep = new ArrayList<>();
        menuSheep.add(new Leaf());
        menuSheep.add(new Herb());
        menuSheep.add(new Fruit());
        return menuSheep;
    }

    @Override
    public int getCountAnimal() {
        return count;
    }

    @Override
    public <T> T getAnimal() {
        return (T) new Sheep();
    }

    @Override
    public int getMaxNumberOfAnimal() {
        return 140;
    }

    @Override
    public int getTravelSpeed() {
        return 3;
    }

    @Override
    public int getFoodForSatiety() {
        return foodForSatiety;
    }

    @Override
    public int getMaxFoodEat() {
        return 15;
    }

    @Override
    public void leave(Location[][] locations, int x, int y) {
        locations[x][y].herbivores.remove(this);
        count--;
    }

    @Override
    public void conditionToEatFood(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].plants.size(); i++) {
            for (int j = 0; j < getAnimalMenu().size(); j++) {
                if (i >= locations[x][y].herbivores.size()) break;
                if (locations[x][y].plants.get(i).equals(getAnimalMenu().get(j))) {
                    Plant plant = locations[x][y].plants.get(i);
                    plant.dead(locations, x, y);
                    foodForSatiety++;
                }
            }
        }
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
