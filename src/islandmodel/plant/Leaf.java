package islandmodel.plant;

import islandmodel.Location;

public class Leaf extends Plant{

    public static int count = 0;

    public Leaf() {
        count++;
    }

    @Override
    public void dead(Location[][] locations, int x, int y) {
        locations[x][y].plants.remove(this);
        count--;
    }
}
