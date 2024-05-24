package seng201.team0.services;

import java.util.Random;

/**
 * Class for generating random tower attributes.
 */
public class TowerGenerator {

    /**
     * Generates a random health value for a heavy tower.
     *
     * @return The generated health value.
     */
    public static int heavyTowerHealthGenerator() {
        Random rng = new Random();
        return rng.nextInt(101) + 200;
    }

    /**
     * Generates a random health value for a light tower.
     *
     * @return The generated health value.
     */
    public static int lightTowerHealthGenerator() {
        Random rng = new Random();
        return rng.nextInt(51) + 100;
    }

    /**
     * Generates a random fill amount for a heavy tower.
     *
     * @return The generated fill amount.
     */
    public static int heavyTowerFillAmountGenerator() {
        Random rng = new Random();
        return rng.nextInt(21) + 40;
    }

    /**
     * Generates a random fill amount for a light tower.
     *
     * @return The generated fill amount.
     */
    public static int lightTowerFillAmountGenerator() {
        Random rng = new Random();
        return rng.nextInt(11) + 20;
    }

    /**
     * Generates a random reload speed for a heavy tower.
     *
     * @return The generated reload speed.
     */
    public static int heavyTowerReloadSpeedGenerator() {
        Random rng = new Random();
        return rng.nextInt(3) + 4;
    }

    /**
     * Generates a random reload speed for a light tower.
     *
     * @return The generated reload speed.
     */
    public static int lightTowerReloadSpeedGenerator() {
        Random rng = new Random();
        return rng.nextInt(3) + 1;
    }

    /**
     * Generates a random price for a heavy tower based on the given difficulty.
     *
     * @param difficulty The difficulty level of the game.
     * @return The generated price.
     */
    public static double heavyTowerPriceGenerator(double difficulty) {
        Random rnd = new Random();
        double priceRandomInt = rnd.nextInt((301)) + 200 * (int) difficulty;
        return Math.round(priceRandomInt * 100.0) / 100.0;
    }

    /**
     * Generates a random price for a light tower based on the given difficulty.
     *
     * @param difficulty The difficulty level of the game.
     * @return The generated price.
     */
    public static double lightTowerPriceGenerator(double difficulty) {
        Random rnd = new Random();
        double priceRandomInt = rnd.nextInt((166)) + 100 * (int) difficulty;
        return Math.round(priceRandomInt * 100.0) / 100.0;
    }
}
