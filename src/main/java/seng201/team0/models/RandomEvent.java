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
        if (eventNum <= 5) {
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
    private void generateGoodEvent(){
        if (eventNum == 5 || eventNum == 1) {
            eventName = "Cart Reset";
            eventText = "One of the carts was reset!!";
        }
        else if (eventNum == 2 || eventNum == 3) {
            eventName = "Reset Towers";
            eventText = "All of the towers were reloaded!";
        }
        else {
            eventName = "Fill Cart";
            eventText = "A cart was filled!";
        }
    }
    private void generateNeutralEvent(){
        eventName = "Nothing";
        eventText = "Nothing happened!";
    }
    private void generateBadEvent(){
        if (eventNum == 14 || eventNum == 11) {
            eventName = "Steal Resources";
            eventText = "Some of your resources were stolen!";
        }
        else if (eventNum == 12 || eventNum == 13) {
            eventName = "Disable Tower";
            eventText = "A tower was used, but no cart was filled!";
        }
        else {
            eventName = "Actions Reset";
            eventText = "No actions this frame!";
        }
    }
    public int generateRoundOneIndex(){
        return randomGenerator.generateRoundOneIndex();
    }
    public int generateRoundIndex(){
        return randomGenerator.generateRoundIndex();
    }
}
