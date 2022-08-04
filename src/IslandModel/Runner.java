package IslandModel;


public class Runner {

    public static void main(String[] args) {

        Island island = new Island(2, 2);

        island.initialize();
        island.print();
        System.out.println("==================================");
        island.islandLaunch();
        island.print();




    }

}
