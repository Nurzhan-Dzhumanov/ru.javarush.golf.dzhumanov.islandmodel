package islandmodel;


public class Island {

    public static void main(String[] args) {

        LocationGroup location1 = new LocationGroup(2, 2);
        LocationGroup location2 = new LocationGroup(2, 2);
        LocationGroup location3 = new LocationGroup(2, 2);

        Thread locationGroup1 = new Thread(location1);
        Thread locationGroup2 = new Thread(location2);
        Thread locationGroup3 = new Thread(location3);

        location1.initialize();
        location2.initialize();
        location3.initialize();

        location1.print();
        location2.print();
        location3.print();

        System.out.println("=================================================");
        LocationGroup.index = 0;

        locationGroup1.start();
        locationGroup2.start();
        locationGroup3.start();

    }

}
