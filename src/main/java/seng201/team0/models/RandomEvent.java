package seng201.team0.models;

import seng201.team0.services.RandomEventGenerator;

public class RandomEvent { // return a message and action based on generated event
    RandomEventGenerator randomGenerator;
    String eventName;
    String eventText;
    int eventNum;
    public void generateRandomEvent(double difficulty) {
        int badEventLikelihood = (int) Math.round(difficulty);
        System.out.println("bed event likelihood "+badEventLikelihood);
        if (badEventLikelihood > 5) {
            badEventLikelihood = 5;
        }
        randomGenerator = new RandomEventGenerator(badEventLikelihood);
        eventNum = randomGenerator.generate();
        System.out.println("eventNum "+eventNum);
        if (eventNum <= 5) {            //TODO TEST AND MAE IN FULL GAME
            this.generateGoodEvent();
        }
        else if (eventNum <= 10) {
            generateNeutralEvent();
        }
        else {
            generateBadEvent();
        }
    }
    public String getEventName(){
        return this.eventName;
    }
    public String getEventText(){
        return this.eventText;
    }
    public int generateEvent(){
        return randomGenerator.generate();
    }
    private void generateGoodEvent(){
        if (eventNum == 5 || eventNum == 1) {
            this.eventName = "Cart Reset";
            this.eventText = "One of the carts was reset!!";
        }
        else if (eventNum == 2 || eventNum == 3) {
            this.eventName = "Reset Towers";
            this.eventText = "All of the towers were reloaded!";
        }
        else {
            this.eventName = "Fill Cart";
            this.eventText = "The first non-empty cart was filled";
        }
    }
    private void generateNeutralEvent(){
        this.eventName = "Nothing";
        this.eventText = "Nothing happened!";
    }
    private void generateBadEvent(){
        if (eventNum == 14 || eventNum == 11) {
            this.eventName = "Steal Resources";
            this.eventText = "Some of your resources were stolen!";
        }
        else if (eventNum == 12 || eventNum == 13) {
            this.eventName = "Disable Tower";
            this.eventText = "A tower was used, but no cart was filled!";
        }
        else {
            this.eventName = "Actions Reset";
            this.eventText = "No actions this frame!";
        }
    }
    public int generateRoundOneIndex(){
        return randomGenerator.generateRoundOneIndex();
    }
    public int generateRoundIndex(){
        return randomGenerator.generateRoundIndex();
    }
}
