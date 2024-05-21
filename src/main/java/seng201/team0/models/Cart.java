package seng201.team0.models;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cart {
    private String cartName;
    private int capacity;
    private String resourceType;
    private int speed;
    private double distanceTravelled;
    private boolean endReached;
    private double currentFillAmount;
    private boolean full;
    private boolean cartSuccess;

    public Cart(String cartName, String resourceType, double difficulty) {
        this.cartName = cartName;
        this.resourceType = resourceType;
        this.endReached = false;
        this.full = false;
        this.cartSuccess = false;
        Random rng = new Random();
        List<Integer> speedList = Arrays.asList(10, 10, 15, 15, 20);
        int randomSpeed = rng.nextInt(5);
        this.speed = speedList.get(randomSpeed);
        List<Integer> capacityList = Arrays.asList(50 * (int) difficulty, 60 * (int) difficulty,50 * (int) difficulty, 60 * (int) difficulty, 75* (int) difficulty);
        int randomCapacity = rng.nextInt(3);
        this.capacity = capacityList.get(randomCapacity);
    }

    public void resetDistance() {
        this.distanceTravelled = 0;
        this.endReached = false;
    }

    public void increaseDistance() {
        if (distanceTravelled + (double) speed /100 >= 1) {
            distanceTravelled = 1;
            endReached = true;
            if (!full) {cartSuccess = false;}
        } else {
            distanceTravelled += (double) speed /100;
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

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getCurrentFillAmount() {
        return currentFillAmount;
    }
    public void increaseFillAmount(int towerFillAmount) {
        if (currentFillAmount + (((double) towerFillAmount /100)/((double) capacity) / 100) >= 1) {
            currentFillAmount = capacity;
            full = true;
            if (!endReached) {
                cartSuccess = true;
            }
        } else {
            currentFillAmount += ((double) towerFillAmount /100)/((double) capacity / 100);
        }
    }

    public boolean isCartSuccess() {
        return cartSuccess;
    }
    public boolean isFull() {
        return full;
    }

    public boolean isEndReached() {
        return endReached;
    }
}
