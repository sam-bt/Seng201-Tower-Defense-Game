package seng201.team0.services;

import seng201.team0.models.RandomEvent;

import java.util.Random;

public class RandomEventGenerator {
    int badEventLikelihood;
    Random rnd = new Random();
    public RandomEventGenerator(int badEventLikelihood) { // generate a random event
        this.badEventLikelihood = badEventLikelihood;
    }
    public int generate() { // in range 0 to 14
        return rnd.nextInt(10)+badEventLikelihood;
    }

}
