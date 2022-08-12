package islandmodel.animal.predator;

import islandmodel.animal.Animal;
import islandmodel.Location;
import islandmodel.animal.herbivore.Duck;
import islandmodel.animal.herbivore.Horse;
import islandmodel.animal.herbivore.Sheep;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bear extends Animal implements Predator {

    public static int count = 0;
    private static final int MAX_WEIGHT_ANIMAL = 500;
    public String typeOfAnimal = "Bear";
    private int foodForSatiety = (int) (Math.random() * getMaxFoodEat());


    public Bear() {
        count++;
    }

    @Override
    public List<?> getAnimalList(Location[][] locations, int x, int y) {
        return locations[x][y].predators;
    }

    @Override
    public List<?> getAnimalMenu() {
        List<Animal> menuBear = new ArrayList<>();
        menuBear.add(new Sheep());
        menuBear.add(new Horse());
        menuBear.add(new Duck());
        return menuBear;
    }

    @Override
    public int getCountAnimal() {
        return count;
    }

    @Override
    public <T> T getAnimal() {
        return (T) new Bear();
    }

    @Override
    public int getMaxNumberOfAnimal() {
        return 5;
    }

    @Override
    public int getTravelSpeed() {
        return 2;
    }

    @Override
    public int getFoodForSatiety() {
        return foodForSatiety;
    }

    @Override
    public int getMaxFoodEat() {
        return 80;
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
        return "\uD83D\uDC3B-Bear";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bear bear = (Bear) o;
        return Objects.equals(typeOfAnimal, bear.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }

}
