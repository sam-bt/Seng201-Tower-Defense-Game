package seng201.team0.models;

import seng201.team0.services.RandomEventGenerator;

public class RandomEvent { // return a message and action based on generated event
    RandomEventGenerator randomGenerator;
    public void generateRandomEvent(double difficulty) { // todo make bad events more likely as the difficulty increases
        int badEventLikelihood = (int) Math.round(difficulty);
        randomGenerator = new RandomEventGenerator(badEventLikelihood);
    }
//    public void generateEvent(){
//        randomGenerator.generateEvent();
//    }
}
