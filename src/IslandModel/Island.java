package IslandModel;

import IslandModel.Animals.Animal;
import IslandModel.Animals.Predators.Predator;
import IslandModel.Animals.Predators.Wolf;

public class Island {

    Location[][] locations;

    Island(int a, int b) {
        this.locations = new Location[a][b];
    }

    public void initialize() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }


    public void print() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                System.out.println(i + " " + locations[i][j]);
            }
        }
    }

    public void islandLaunch() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].calculate(locations, i, j);
            }
        }
    }

}
