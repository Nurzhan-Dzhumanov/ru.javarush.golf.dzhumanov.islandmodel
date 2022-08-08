package islandmodel.animals.herbivores;

import islandmodel.animals.Animal;
import islandmodel.animals.predators.Predator;
import islandmodel.Location;
import islandmodel.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Duck extends Animal implements Herbivore, Predator {

    public static int count = 0;

    int weight = 1;
    int numberOfAnimals = 200;
    int travelSpeed = 4;
    double foodForSatiety = (int) (Math.random() * 15) * 0.01;

    String typeOfAnimal = "Duck";

    public Duck() {
        count++;
    }

    @Override
    public void multiplyHerbivore(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
            if (this.equals(locations[x][y].herbivores.get(i)) && count < numberOfAnimals && count > 1) {
                locations[x][y].herbivores.add(new Duck());
            }
        }
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {
        if (foodForSatiety < 0.15) {
            int moveX = (int) (Math.random() * travelSpeed);
            int moveY = (int) (Math.random() * travelSpeed);
            int sizeX = (x + moveX) % locations[x].length;
            int sizeY = (y + moveY) % locations[x].length;
            locations[x][y].herbivores.remove(this);
            locations[sizeX][sizeY].herbivores.add(this);
        }
    }

    @Override
    public void dead(Location[][] locations, int x, int y) {
        if (foodForSatiety == 0) {
            locations[x][y].herbivores.remove(this);
            count--;
        }
    }

    @Override
    public void eatPlant(Location[][] locations, int x, int y) {
        menuAnimals();
        if (foodForSatiety < 0.15) {
            for (int i = 0; i < locations[x][y].plants.size(); i++) {
                for (int j = 0; j < menuAnimals().size(); j++) {
                    if (locations[x][y].plants.get(i).equals(menuAnimals().get(j))) {
                        locations[x][y].plants.remove(i);
                        foodForSatiety++;
                        if (i >= locations[x][y].plants.size()) break;
                    }
                }
            }
        }
    }

    @Override
    public void eatMeat(Location[][] locations, int x, int y) {
        menuAnimals();
        if (foodForSatiety < 0.15) {
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
        List<Plant> menuDuck = new ArrayList<>();
        menuDuck.add(null);
        menuDuck.add(null);
        menuDuck.add(null);
        return menuDuck;
    }

    @Override
    public void multiplyPredator(Location[][] locations, int x, int y) {

    }

    @Override
    public String toString() {
        return "\uD83E\uDD86-Duck";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return Objects.equals(typeOfAnimal, duck.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }
}
