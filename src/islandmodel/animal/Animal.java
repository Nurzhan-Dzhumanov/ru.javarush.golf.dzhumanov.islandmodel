package islandmodel.animal;

import islandmodel.Location;


import java.util.List;

public abstract class Animal {

    public void eat(Location[][] locations, int x, int y) {
        getAnimalMenu();
        if (getFoodForSatiety() < getMaxFoodEat()) {
            conditionToEatFood(locations, x, y);
        }

    }

    public void multiply(Location[][] locations, int x, int y) {
        for (int i = 0; i < getAnimalList(locations, x, y).size(); i++) {
            if (getAnimal().equals(getAnimalList(locations, x, y).get(i))
                    && getCountAnimal() < getMaxNumberOfAnimal()
                    && getCountAnimal() > 1) {
                getAnimalList(locations, x, y).add(getAnimal());
            }
        }
    }

    public void directionOfMovement(Location[][] locations, int x, int y) {
        if (getFoodForSatiety() < getMaxFoodEat()) {
            int moveX = (int) (Math.random() * getTravelSpeed());
            int moveY = (int) (Math.random() * getTravelSpeed());
            int sizeX = (x + moveX) % locations[x].length;
            int sizeY = (y + moveY) % locations[x].length;
            leave(locations, x, y);
            getAnimalList(locations, sizeX, sizeY).add(getAnimal());
        }
    }

    public void dead(Location[][] locations, int x, int y) {
        if (getFoodForSatiety() == 0) {
            leave(locations, x, y);
        }
    }

    public abstract List<?> getAnimalList(Location[][] locations, int x, int y);

    public abstract List<?> getAnimalMenu();

    public abstract int getCountAnimal();

    public abstract <T> T getAnimal();

    public abstract int getMaxNumberOfAnimal();

    public abstract int getTravelSpeed();

    public abstract int getFoodForSatiety();

    public abstract int getMaxFoodEat();

    public abstract void leave(Location[][] locations, int x, int y);

    public abstract void conditionToEatFood(Location[][] locations, int x, int y);

}
