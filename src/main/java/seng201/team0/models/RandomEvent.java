package seng201.team0.models;

import seng201.team0.services.RandomEventGenerator;

public class RandomEvent { // return a message and action based on generated event
    RandomEventGenerator randomGenerator;
    String eventName;
    String eventText;
    String eventAction;
    int eventNum;
    public void generateRandomEvent(double difficulty) {
        int badEventLikelihood = (int) Math.round(difficulty);
        if (badEventLikelihood > 5) {
            badEventLikelihood = 5;
        }
        randomGenerator = new RandomEventGenerator(badEventLikelihood);
        eventNum = this.generateEvent();
        if (eventNum <= 4) {
            this.generateGoodEvent();
        }
        if (eventNum <= 9) {
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
    public String getEventAction(){
        return this.eventAction;
    }
    public int generateEvent(){
        return randomGenerator.generate();
    }
    private void generateGoodEvent(){
        if (eventNum == 0 || eventNum == 1) {
            eventName = "Cart Reset";
            eventText = "One of the carts was reset!!";
            eventAction = "Reset Cart";
        }
        else if (eventNum == 2 || eventNum == 3) {
            eventName = "Reset Towers";
            eventText = "All of the towers were reloaded!";
            eventAction = "Reload Towers";
        }
        else {
            eventName = "Fill Cart";
            eventText = "A cart was filled!";
            eventAction = "Fill Cart";
        }
    }
    private void generateNeutralEvent(){
        eventName = "Nothing";
        eventText = "Nothing happened!";
        eventAction = "Nothing";
    }
    private void generateBadEvent(){
        if (eventNum == 10 || eventNum == 11) {
            eventName = "Steal Resources";
            eventText = "Some of your resources were stolen!";
            eventAction = "Steal Resources";
        }
        else if (eventNum == 12 || eventNum == 13) {
            eventName = "Disable Tower";
            eventText = "A tower has been disabled!";
            eventAction = "Disable Tower";
        }
        else {
            eventName = "Actions Reset";
            eventText = "No actions this frame!";
            eventAction = "Reset Actions";
        }
    }
//    public int generateRoundOneIndex(){
//
//    }
//    public int generateRoundIndex(){
//
//    }
}
