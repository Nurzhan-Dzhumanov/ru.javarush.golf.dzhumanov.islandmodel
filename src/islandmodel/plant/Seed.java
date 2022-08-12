package islandmodel.plant;

import islandmodel.Location;

public class Seed extends Plant {

    public static int count = 0;

    public Seed() {
        count++;
    }

    @Override
    public void dead(Location[][] locations, int x, int y) {
        locations[x][y].plants.remove(this);
        count--;
    }
}
