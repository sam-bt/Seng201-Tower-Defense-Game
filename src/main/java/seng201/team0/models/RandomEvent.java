package seng201.team0.models;

import seng201.team0.services.RandomEventGenerator;

/**
 * Responsible for generating random events in the game.
 * Determines the type of event based on the difficulty level and the generated random number.
 */
public class RandomEvent { // return a message and action based on generated event
    /**
     * Empty Constructor for RandomEvent.
     */
    public RandomEvent() { }

    /**
     * Generator used to generate random events.
     */
    private RandomEventGenerator randomGenerator;

    /**
     * Name of the event.
     */
    private String eventName;

    /**
     * Event message.
     */
    private String eventText;

    /**
     * Number representing the event.
     */
    private int eventNum;

    /**
     * Generates a random event based on the difficulty level.
     *
     * @param difficulty The difficulty level of the game.
     */
    public void generateRandomEvent(final double difficulty) {
        int badEventLikelihood = (int) Math.round(difficulty);
        if (badEventLikelihood > 5) {
            badEventLikelihood = 5;
        }
        randomGenerator = new RandomEventGenerator(badEventLikelihood);
        eventNum = randomGenerator.generate();
        if (eventNum <= 5) {
            this.generateGoodEvent();
        } else if (eventNum <= 10) {
            generateNeutralEvent();
        } else {
            generateBadEvent();
        }
    }

    /**
     * Returns the name of the generated event.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * Returns the event message.
     *
     * @return The event message.
     */
    public String getEventText() {
        return this.eventText;
    }

    /**
     * Generates a good event based on the event number.
     */
    private void generateGoodEvent() {
        if (eventNum == 5 || eventNum == 1) {
            eventName = "Cart Reset";
            eventText = "One of the carts was reset!!";
        } else if (eventNum == 2 || eventNum == 3) {
            eventName = "Reset Towers";
            eventText = "All of the towers were reloaded!";
        } else {
            eventName = "Fill Cart";
            eventText = "A cart was filled!";
        }
    }

    /**
     * Generates a neutral event.
     */
    private void generateNeutralEvent() {
        eventName = "Nothing";
        eventText = "Nothing happened!";
    }

    /**
     * Generates a bad event based on the event number.
     */
    private void generateBadEvent() {
        if (eventNum == 14 || eventNum == 11) {
            eventName = "Steal Resources";
            eventText = "Some of your resources were stolen!";
        } else if (eventNum == 12 || eventNum == 13) {
            eventName = "Disable Tower";
            eventText = "A tower was used, but no cart was filled!";
        } else {
            eventName = "Actions Reset";
            eventText = "No actions this frame!";
        }
    }

    /**
     * Generates a random index for round one.
     *
     * @return The generated random index for round one.
     */
    public int generateRoundOneIndex() {
        return randomGenerator.generateRoundOneIndex();
    }

    /**
     * Generates a random index for rounds after one.
     *
     * @return The generated random index for rounds after one.
     */
    public int generateRoundIndex() {
        return randomGenerator.generateRoundIndex();
    }
}
