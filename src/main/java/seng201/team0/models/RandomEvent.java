package seng201.team0.models;

import seng201.team0.services.RandomEventGenerator;

public class RandomEvent { // return a message and action based on generated event
    public void generateRandomEvent(double difficulty) { // todo make bad events more likely as the difficulty increases
        int badEventLikelihood = (int) Math.round(difficulty);
        RandomEventGenerator randomGenerator = new RandomEventGenerator(badEventLikelihood);
    }
}
