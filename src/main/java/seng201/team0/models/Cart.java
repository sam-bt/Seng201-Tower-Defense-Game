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
    private int currentFillDisplay;
    int tracklength;

    public Cart(String cartName, String resourceType, double difficulty, int tracklength) {
        this.cartName = cartName;
        this.resourceType = resourceType;
        this.endReached = false;
        this.full = false;
        this.cartSuccess = false;
        this.currentFillDisplay=0;
        this.tracklength = tracklength;
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
        double newDistanceTravelled  = distanceTravelled + (double) speed / tracklength;
        if (newDistanceTravelled >= 1) {
            distanceTravelled = 1;
            endReached = true;
            if (!full) {cartSuccess = false;}
        } else {
            distanceTravelled = newDistanceTravelled;
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
    public int getCurrentFillDisplay() {
        return currentFillDisplay;
    }
    public void increaseFillAmount(int towerFillAmount) {
            double newFillAmount = currentFillAmount + (double) towerFillAmount / capacity;
            if (newFillAmount >= 1) {
                currentFillAmount = 1;
                currentFillDisplay = capacity;
                full = true;
                if (!endReached) {
                    cartSuccess = true;
                }
            } else {
                currentFillAmount = newFillAmount;
                currentFillDisplay += towerFillAmount;
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
