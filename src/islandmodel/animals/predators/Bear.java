package islandmodel.animals.predators;

import islandmodel.animals.Animal;
import islandmodel.Location;
import islandmodel.animals.herbivores.Duck;
import islandmodel.animals.herbivores.Horse;
import islandmodel.animals.herbivores.Sheep;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bear extends Animal implements Predator {

    public static int count = 0;

    int weight = 500;
    int numberOfAnimals = 5;
    int travelSpeed = 2;
    int foodForSatiety = (int) (Math.random() * 80);

    String typeOfAnimal = "Bear";

    public Bear() {
        count++;
    }

    @Override
    public void multiplyPredator(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].predators.size(); i++) {
            if (this.equals(locations[x][y].predators.get(i)) && count < numberOfAnimals && count > 1) {
                locations[x][y].predators.add(new Bear());
            }
        }
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {
        if (foodForSatiety < 80) {
            int moveX = (int) (Math.random() * travelSpeed);
            int moveY = (int) (Math.random() * travelSpeed);
            int sizeX = (x + moveX) % locations[x].length;
            int sizeY = (y + moveY) % locations[x].length;
            locations[x][y].predators.remove(this);
            locations[sizeX][sizeY].predators.add(this);
        }
    }

    @Override
    public void dead(Location[][] locations, int x, int y) {
        if (foodForSatiety == 0) {
            locations[x][y].predators.remove(this);
            count--;
        }
    }



    @Override
    public void eatMeat(Location[][] locations, int x, int y) {
        menuAnimals();
        if (foodForSatiety < 80) {
            for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
                for (int j = 0; j < menuAnimals().size(); j++) {
                    if (locations[x][y].herbivores.get(i).equals(menuAnimals().get(j))) {
                        locations[x][y].herbivores.remove(i);
                        foodForSatiety++;
                        if (i >= locations[x][y].herbivores.size()) break;
                    }
                }
            }
        }

    }

    @Override
    public List<?> menuAnimals() {
        List<Animal> menuBear = new ArrayList<>();
        menuBear.add(new Sheep());
        menuBear.add(new Horse());
        menuBear.add(new Duck());
        return menuBear;
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
