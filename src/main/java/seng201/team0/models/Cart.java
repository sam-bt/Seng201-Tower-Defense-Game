package seng201.team0.models;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cart {
    public String cartName;
    public int capacity;
    public String resourceType;
    public int speed;
    public int distanceTravelled;
    public boolean endReached;

    public Cart(String cartName, String resourceType) {
        this.cartName = cartName;
        this.resourceType = resourceType;
        Random rng = new Random();
        List<Integer> speedList = Arrays.asList(10, 10, 20, 20, 50);
        int randomSpeed = rng.nextInt(5);
        this.speed = speedList.get(randomSpeed);
        List<Integer> capacityList = Arrays.asList(100, 200, 300);
        int randomCapacity = rng.nextInt(3);
        this.capacity = capacityList.get(randomCapacity);
    }

    public void resetDistance() {
        this.distanceTravelled = 0;
        this.endReached = false;
    }

    public void increaseDistance(int maxDistance) {
        if (distanceTravelled + speed >= maxDistance) {
            distanceTravelled = maxDistance;
            endReached = true;
        } else {
            distanceTravelled += speed;
        }
    }

    public String getCartName() {
        return cartName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public boolean getEndReached() {
        return endReached;
    }
}
