package islandmodel.animals.herbivores;

import islandmodel.animals.Animal;
import islandmodel.Location;
import islandmodel.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sheep extends Animal implements Herbivore {

    public static int count = 0;

    int weight = 70;
    int numberOfAnimals = 140;
    int travelSpeed = 3;
    int foodForSatiety = (int) (Math.random() * 15);

    String typeOfAnimal = "Sheep";

    public Sheep() {
        count++;
    }

    @Override
    public void multiplyHerbivore(Location[][] locations, int x, int y) {
        for (int i = 0; i < locations[x][y].herbivores.size(); i++) {
            if (this.equals(locations[x][y].herbivores.get(i)) && count < numberOfAnimals && count > 1) {
                locations[x][y].herbivores.add(new Sheep());
            }
        }
    }

    @Override
    public void directionOfMovement(Location[][] locations, int x, int y) {
        if (foodForSatiety < 15) {
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
        if (foodForSatiety < 15) {
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
        List<Plant> menuSheep = new ArrayList<>();
        menuSheep.add(null);
        menuSheep.add(null);
        menuSheep.add(null);
        return menuSheep;
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
