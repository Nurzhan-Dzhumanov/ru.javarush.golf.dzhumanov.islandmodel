package islandmodel.animal.predator;

import islandmodel.animal.Animal;
import islandmodel.animal.herbivore.Duck;
import islandmodel.animal.herbivore.Herbivore;
import islandmodel.animal.herbivore.Horse;
import islandmodel.animal.herbivore.Sheep;
import islandmodel.Location;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wolf extends Animal implements Predator {

    private static final int MAX_WEIGHT_ANIMAL = 50;
    public static int count = 0;
    public String typeOfAnimal = "Wolf";
    private int foodForSatiety = (int) (Math.random() * getMaxFoodEat());

    public Wolf() {
        count++;
    }

    @Override
    public List<?> getAnimalList(Location[][] locations, int x, int y) {
        return locations[x][y].predators;
    }

    @Override
    public List<?> getAnimalMenu() {
        List<Animal> wolfMenu = new ArrayList<>();
        wolfMenu.add(new Sheep());
        wolfMenu.add(new Horse());
        wolfMenu.add(new Duck());
        return wolfMenu;
    }

    @Override
    public int getCountAnimal() {
        return count;
    }

    @Override
    public <T> T getAnimal() {
        return (T) new Wolf();
    }


    @Override
    public int getMaxNumberOfAnimal() {
        return 30;
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
        return 8;
    }

    @Override
    public void leave(Location[][] locations, int x, int y) {
        locations[x][y].predators.remove(this);
        count--;
    }

    @Override
    public void conditionToEatFood(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
            for (int j = 0; j < getAnimalMenu().size(); j++) {
                if (i >= locations[x][y].herbivores.size()) break;
                if (locations[x][y].herbivores.get(i).equals(getAnimalMenu().get(j))) {
                    Animal herbivore = (Animal) locations[x][y].herbivores.get(i);
                    herbivore.leave(locations, x, y);
                    foodForSatiety++;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A-Wolf";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf1 = (Wolf) o;
        return Objects.equals(typeOfAnimal, wolf1.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }
}
