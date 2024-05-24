package seng201.team0.services;

import java.util.Random;

public class TowerGenerator {
    /**
    * Calculates random health for heavy tower
    */
    public static int heavyTowerHealthGenerator() {
        Random rng = new Random();
        return rng.nextInt(101)+200;
    }
    public static int lightTowerHealthGenerator() {
        Random rng = new Random();
        return rng.nextInt(51) + 100;
    }
    public static int heavyTowerFillAmountGenerator() {
        Random rng = new Random();
        return rng.nextInt(21) + 40;
    }
    public static int lightTowerFillAmountGenerator() {
        Random rng = new Random();
        return rng.nextInt(11) + 20;
    }
    public static int heavyTowerReloadSpeedGenerator() {
        Random rng = new Random();
        return rng.nextInt(3) + 4;
    }
    public static int lightTowerReloadSpeedGenerator() {
        Random rng = new Random();
        return rng.nextInt(3) + 1;
    }
    public static double heavyTowerPriceGenerator(double difficulty) {
        Random rnd = new Random();
        double priceRandomInt = rnd.nextInt((301))+200 * (int) difficulty;
        return Math.round(priceRandomInt*100.0)/100.0;
    }
    public static double lightTowerPriceGenerator(double difficulty) {
        Random rnd = new Random();
        double priceRandomInt = rnd.nextInt((166))+100 * (int) difficulty;
        return Math.round(priceRandomInt*100.0)/100.0;
    }
}
