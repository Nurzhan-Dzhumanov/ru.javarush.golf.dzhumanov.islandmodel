package islandmodel.animals.herbivores;

import islandmodel.animals.Animal;
import islandmodel.Location;
import islandmodel.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Horse extends Animal implements Herbivore {

    public static int count = 0;

    int weight = 400;
    int numberOfAnimals = 20;
    int travelSpeed = 4;
    int foodForSatiety = (int) (Math.random() * 60);

    String typeOfAnimal = "Horse";

    public Horse() {
        count++;
    }

    @Override
    public void multiplyHerbivore(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
            if (this.equals(locations[x][y].herbivores.get(i)) && count < numberOfAnimals && count > 1) {
                locations[x][y].herbivores.add(new Horse());
            }
        }
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {
        if (foodForSatiety < 60) {
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
        if (foodForSatiety < 60) {
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
    public List<?> menuAnimals() {
        List<Plant> menuHorse = new ArrayList<>();
        menuHorse.add(null);
        menuHorse.add(null);
        menuHorse.add(null);
        return menuHorse;
    }


    @Override
    public String toString() {
        return "\uD83D\uDC0E-Horse";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(typeOfAnimal, horse.typeOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAnimal);
    }
}
