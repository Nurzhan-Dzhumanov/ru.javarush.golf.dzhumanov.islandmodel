package islandmodel;

public class LocationGroup implements Runnable {

    Location[][] locations;

    LocationGroup(int a, int b) {
        this.locations = new Location[a][b];
    }

    public void initialize() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    static int index = 0;

    public void print() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                System.out.println(index + 1 + " " + locations[i][j]);
                index++;
                sleep(1000);
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].calculate(locations, i, j);
            }
        }
        print();

    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
