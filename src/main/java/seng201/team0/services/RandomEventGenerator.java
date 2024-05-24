package seng201.team0.services;

import seng201.team0.models.RandomEvent;

import java.util.Random;

/**
 * Class that handles random event generation
 */
public class RandomEventGenerator {
    /**
     * The likelihood of generating a bad event
     */
    int badEventLikelihood;
    /**
     * Random number generator
     */
    Random rnd = new Random();

    /**
     * Constructs a RandomEventGenerator with a specified likelihood of bad events.
     *
     * @param badEventLikelihood The likelihood of generating a bad event.
     */
    public RandomEventGenerator(int badEventLikelihood) {
        this.badEventLikelihood = badEventLikelihood;
    }

    /**
     * Generates a random number in the range of 1 to 15.
     *
     * @return A randomly generated number.
     */
    public int generate() { // in range 1 to 15
        return rnd.nextInt(11) + badEventLikelihood;
    }

    /**
     * Generates a random index for the first round.
     *
     * @return A random index in the range of 0 to 2.
     */
    public int generateRoundOneIndex() {
        return rnd.nextInt(3);
    }

    /**
     * Generates a random index for the rounds other than the first.
     *
     * @return A random index in the range of 0 to 4.
     */
    public int generateRoundIndex() {
        return rnd.nextInt(5);
    }

}
