package seng201.team0.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
        endReached = false;
        full = false;
        cartSuccess = false;
        currentFillDisplay=0;
        this.tracklength = tracklength;
        Random rng = new Random();
        List<Integer> speedList = Arrays.asList(5, 8, 8, 10, 10,15);
        int randomSpeed = rng.nextInt(6);
        speed = speedList.get(randomSpeed);
        List<Integer> capacityList = Arrays.asList(50 * (int) difficulty, 60 * (int) difficulty,50 * (int) difficulty, 60 * (int) difficulty, 75* (int) difficulty);
        int randomCapacity = rng.nextInt(3);
        if (Objects.equals(cartName, "Bonus")) {
            capacity = 100 +((int) difficulty * 50);
        }
        else {
        capacity = capacityList.get(randomCapacity);
        }
    }

    public void resetDistance() {
        distanceTravelled = 0;
        endReached = false;
    }

    public void increaseDistance() {
        double newDistanceTravelled = distanceTravelled + (double) speed / tracklength;
        if (distanceTravelled*100 >= tracklength) {
            distanceTravelled = tracklength;
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
            }
            else if (newFillAmount <= 0) {
                currentFillAmount = 0;
                currentFillDisplay = 0;
            }
            else {
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
