package islandmodel;

import islandmodel.animal.herbivore.Duck;
import islandmodel.animal.herbivore.Horse;
import islandmodel.animal.herbivore.Sheep;
import islandmodel.animal.predator.Bear;
import islandmodel.animal.predator.Wolf;
import islandmodel.plant.Fruit;
import islandmodel.plant.Herb;
import islandmodel.plant.Leaf;
import islandmodel.plant.Seed;

public class IslandRunner {

    public static void main(String[] args) {

        Island location1 = new Island(2, 2);
        Island location2 = new Island(2, 2);
        Island location3 = new Island(2, 2);

        Thread locationGroup1 = new Thread(location1);
        Thread locationGroup2 = new Thread(location2);
        Thread locationGroup3 = new Thread(location3);

        location1.initialize();
        location2.initialize();
        location3.initialize();

        System.out.println("Формирование острова...............");

        location1.print();
        location2.print();
        location3.print();

        System.out.println("Остров сформирован! \n");
        System.out.println("Статистика животных: \nВолков - " +  Wolf.count + "\nМедведей -"
        + Bear.count + "\nОвец - " + Sheep.count + "\nЛошадей - " + Horse.count + "\nУток - " + Duck.count);
        System.out.println("Статистика растений: \nФрукты - " +  Fruit.count + "\nЛистья -"
                + Leaf.count + "\nСемена - " + Seed.count + "\nТравы - " + Herb.count);

        System.out.println("=============================================");
        Island.index = 0;

        System.out.println("Начинаются события.............");

        locationGroup1.start();
        locationGroup2.start();
        locationGroup3.start();

        Island.sleep(3000);

        location1.print();
        location2.print();
        location3.print();

        System.out.println("Статистика животных после событий: \nВолков - " +  Wolf.count + "\nМедведей -"
                + Bear.count + "\nОвец - " + Sheep.count + "\nЛошадей - " + Horse.count + "\nУток - " + Duck.count);
        System.out.println("Статистика растений: \nФрукты - " +  Fruit.count + "\nЛистья -"
                + Leaf.count + "\nСемена - " + Seed.count + "\nТравы - " + Herb.count);

    }
}
