package seng201.team0.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Class for cart object
 */
public class Cart {
    /**
     * The name of the cart.
     */
    private final String cartName;

    /**
     * The capacity of the cart.
     */
    private final int capacity;

    /**
     * The cart's resource type.
     */
    private final String resourceType;

    /**
     * The speed of the cart.
     */
    private final int speed;

    /**
     * The distance the cart has traveled.
     */
    private double distanceTravelled;

    /**
     * Indicates whether the cart has reached the end of the track.
     */
    private boolean endReached;

    /**
     * The current fill amount of the cart.
     */
    private double currentFillAmount;

    /**
     * Indicates whether the cart is full.
     */
    private boolean full;

    /**
     * Indicates whether the cart has been filled before it has reached the end of the track.
     */
    private boolean cartSuccess;

    /**
     * The current fill representation for the UI.
     */
    private int currentFillDisplay;

    /**
     * The length of the track.
     */
    private final int trackLength;

    /**
     * Constructs a new Cart object with the specified name, resource type, difficulty, and track length.
     *
     * @param cartName The name of the cart.
     * @param resourceType The type of resource the cart transports.
     * @param difficulty The difficulty level, which affects the cart's capacity.
     * @param trackLength The length of the track the cart travels on.
     */
    public Cart(String cartName, String resourceType, double difficulty, int trackLength) {
        this.cartName = cartName;
        this.resourceType = resourceType;
        endReached = false;
        full = false;
        cartSuccess = false;
        currentFillDisplay = 0;
        this.trackLength = trackLength;
        Random rng = new Random();
        List<Integer> speedList = Arrays.asList(5, 8, 8, 10, 10, 15);
        int randomSpeed = rng.nextInt(6);
        speed = speedList.get(randomSpeed);
        List<Integer> capacityList = Arrays.asList(50 * (int) difficulty, 60 * (int) difficulty, 50 * (int) difficulty, 60 * (int) difficulty, 75 * (int) difficulty);
        int randomCapacity = rng.nextInt(3);
        if (Objects.equals(cartName, "Bonus")) {
            capacity = 100 + ((int) difficulty * 50);
        } else {
            capacity = capacityList.get(randomCapacity);
        }
    }

    /**
     * Resets the distance traveled.
     */
    public void resetDistance() {
        distanceTravelled = 0;
        endReached = false;
    }

    /**
     * Increases the distance traveled by the cart based on its speed and the track length.
     */
    public void increaseDistance() {
        double newDistanceTravelled = distanceTravelled + (double) speed / trackLength;
        if (distanceTravelled * 100 >= trackLength) {
            distanceTravelled = trackLength;
            endReached = true;
            if (!full) {
                cartSuccess = false;
            }
        } else {
            distanceTravelled = newDistanceTravelled;
        }
    }

    /**
     * Returns the name of the cart.
     *
     * @return The name of the cart.
     */
    public String getCartName() {
        return cartName;
    }

    /**
     * Returns the type of resource the cart transports.
     *
     * @return The type of resource the cart transports.
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Returns the capacity of the cart.
     *
     * @return The capacity of the cart.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the speed of the cart.
     *
     * @return The speed of the cart.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Returns the distance traveled by the cart.
     *
     * @return The distance traveled by the cart.
     */
    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    /**
     * Returns the current fill amount of the cart.
     *
     * @return The current fill amount of the cart.
     */
    public double getCurrentFillAmount() {
        return currentFillAmount;
    }

    /**
     * Returns the current fill display of the cart.
     *
     * @return The current fill display of the cart.
     */
    public int getCurrentFillDisplay() {
        return currentFillDisplay;
    }

    /**
     * Increases the fill amount of the cart by the specified tower fill amount.
     *
     * @param towerFillAmount The amount to increase the fill amount by.
     */
    public void increaseFillAmount(int towerFillAmount) {
        double newFillAmount = currentFillAmount + (double) towerFillAmount / capacity;
        if (newFillAmount >= 1) {
            currentFillAmount = 1;
            currentFillDisplay = capacity;
            full = true;
            if (!endReached) {
                cartSuccess = true;
            }
        } else if (newFillAmount <= 0) {
            currentFillAmount = 0;
            currentFillDisplay = 0;
        } else {
            currentFillAmount = newFillAmount;
            currentFillDisplay += towerFillAmount;
        }
    }

    /**
     * Returns whether the cart successfully reached the end of the track while full.
     *
     * @return True if the cart successfully reached the end of the track while full, otherwise false.
     */
    public boolean isCartSuccess() {
        return cartSuccess;
    }

    /**
     * Returns whether the cart is full.
     *
     * @return True if the cart is full, otherwise false.
     */
    public boolean isFull() {
        return full;
    }

    /**
     * Returns whether the cart has reached the end of the track.
     *
     * @return True if the cart has reached the end of the track, otherwise false.
     */
    public boolean isEndReached() {
        return endReached;
    }

    /**
     * Sets the cart as full.
     */
    public void fillCart() {
        full = true;
    }

    /**
     * Sets the cart as having reached the end of the track.
     */
    public void setEndReached() {
        endReached = true;
    }

    /**
     * Sets the cart as successful.
     */
    public void setCartSuccess() {
        cartSuccess = true;
    }
}
