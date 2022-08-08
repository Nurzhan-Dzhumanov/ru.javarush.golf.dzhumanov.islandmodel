package islandmodel;


public class Runner {

    public static void main(String[] args) {

        Island island = new Island(8, 4);

        island.initialize();
        island.print();
        System.out.println("=================================================");
        island.islandLaunch();
        island.print();


    }

}
