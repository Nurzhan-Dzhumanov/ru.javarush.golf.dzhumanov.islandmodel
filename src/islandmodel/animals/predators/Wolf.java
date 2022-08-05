package islandmodel.animals.predators;

import islandmodel.animals.Animal;
import islandmodel.animals.herbivores.Duck;
import islandmodel.animals.herbivores.Horse;
import islandmodel.animals.herbivores.Sheep;
import islandmodel.Location;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wolf extends Animal implements Predator {

    public static int count = 0;

    int weight = 50;
    int numberOfAnimals = 30;
    int travelSpeed = 3;
    int foodForSatiety = 8;

    String typeOfAnimal = "Wolf";

    public Wolf() {
        count++;
    }

    @Override
    public void multiplyPredator(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].predators.size(); i++) {
            if (this.equals(locations[x][y].predators.get(i)) && count < numberOfAnimals && count > 1) {
                count++;
                locations[x][y].predators.add(new Wolf());
            }
        }
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {
        int moveX = (int) (Math.random() * travelSpeed);
        int moveY = (int) (Math.random() * travelSpeed);
        int sizeX = (x + moveX) % locations[x].length;
        int sizeY = (y + moveY) % locations[x].length;
        locations[x][y].predators.remove(this);
        locations[sizeX][sizeY].predators.add(this);

    }

    @Override
    public Object dead(List<Predator> predatorList) {
        count--;
        return predatorList.remove(new Wolf());
    }

    @Override
    public void eatMeat(Location[][] locations, int x, int y) {
        menuAnimals();
        for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
            for (int j = 0; j < menuAnimals().size(); j++) {
                if (locations[x][y].herbivores.get(i).equals(menuAnimals().get(j))) {
                    locations[x][y].herbivores.remove(i);
                    if (i >= locations[x][y].herbivores.size()) break;
                }
            }
        }

    }

    @Override
    public List<?> menuAnimals() {
        List<Animal> menuWolf = new ArrayList<>();
        menuWolf.add(new Sheep());
        menuWolf.add(new Horse());
        menuWolf.add(new Duck());
        return menuWolf;
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
